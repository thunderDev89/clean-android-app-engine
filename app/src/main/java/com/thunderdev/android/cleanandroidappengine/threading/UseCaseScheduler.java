package com.thunderdev.android.cleanandroidappengine.threading;

import com.thunderdev.android.cleanandroidappengine.UseCase;

/**
 * Created by Audrik ! on 08/10/2016.
 */

public interface UseCaseScheduler {
    void execute(Runnable runnable);

    <V extends UseCase.ResponseValues> void notifyResponse(final V response,
                                                           final UseCase.UseCaseCallback<V> useCaseCallback);

    <V extends UseCase.ResponseValues> void onError(final UseCase.UseCaseCallback<V> useCaseCallback);
}
