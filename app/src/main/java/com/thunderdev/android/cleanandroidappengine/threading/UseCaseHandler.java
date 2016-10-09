package com.thunderdev.android.cleanandroidappengine.threading;

/**
 * Created by Audrik ! on 08/10/2016.
 */

import com.thunderdev.android.cleanandroidappengine.UseCase;

/**
 * Runs {@link UseCase}s using a {@link UseCaseScheduler}.
 */
public class UseCaseHandler {
    private static UseCaseHandler INSTANCE;

    private final UseCaseScheduler mUseCaseScheduler;

    private UseCaseHandler(UseCaseScheduler useCaseScheduler) {
        mUseCaseScheduler = useCaseScheduler;
    }

    public <R extends UseCase.RequestValues, Q extends UseCase.ResponseValues> void execute(
            final UseCase<R, Q> useCase, R values, UseCase.UseCaseCallback<Q> useCaseCallback) {
        useCase.setRequestValues(values);
        useCase.setUseCaseCallback(new UiCallbackWrapper(useCaseCallback, this));

        mUseCaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }

    public <V extends UseCase.ResponseValues> void notifyResponse(final V response, final UseCase.UseCaseCallback<V> useCaseCallback) {
        mUseCaseScheduler.notifyResponse(response, useCaseCallback);
    }

    public <V extends UseCase.ResponseValues> void onError(final UseCase.UseCaseCallback<V> useCaseCallback) {
        mUseCaseScheduler.onError(useCaseCallback);
    }

    private static final class UiCallbackWrapper<V extends UseCase.ResponseValues> implements UseCase.UseCaseCallback<V> {
        private final UseCase.UseCaseCallback<V> mUseCaseCallback;
        private final UseCaseHandler mUseCaseHandler;

        public UiCallbackWrapper(UseCase.UseCaseCallback<V> useCaseCallback, UseCaseHandler useCaseHandler) {
            this.mUseCaseCallback = useCaseCallback;
            this.mUseCaseHandler = useCaseHandler;
        }

        @Override
        public void onSuccess(V response) {
            mUseCaseHandler.notifyResponse(response, mUseCaseCallback);
        }

        @Override
        public void onError() {
            mUseCaseHandler.onError(mUseCaseCallback);
        }
    }

    public static UseCaseHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UseCaseHandler(new UseCaseThreadPoolScheduler());
        }
        return INSTANCE;
    }
}
