package com.thunderdev.android.cleanandroidappengine.helloworld.domain.usecase;

import com.thunderdev.android.cleanandroidappengine.UseCase;
import com.thunderdev.android.cleanandroidappengine.helloworld.domain.model.Message;
import com.thunderdev.android.cleanandroidappengine.helloworld.repo.HelloWorldRepository;

/**
 * Created by Audrik ! on 09/10/2016.
 */

public class SayHello extends UseCase<SayHello.RequestValues, SayHello.ResponseValues> {
    private final HelloWorldRepository mRepository;

    public SayHello(final HelloWorldRepository repository) {
        this.mRepository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        mRepository.getMessage(new HelloWorldRepository.Callback() {
            @Override
            public void onSuccess(Message message) {
                getUseCaseCallback().onSuccess(new ResponseValues(message));
            }

            @Override
            public void onError() {
                getUseCaseCallback().onError();
            }
        });
    }

    public static final class RequestValues implements UseCase.RequestValues {
    }

    public static final class ResponseValues implements UseCase.ResponseValues {
        private final Message mMessage;

        public ResponseValues(Message message) {
            this.mMessage = message;
        }

        public Message getMessage() {
            return mMessage;
        }
    }
}
