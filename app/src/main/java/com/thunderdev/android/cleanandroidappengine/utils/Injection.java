package com.thunderdev.android.cleanandroidappengine.utils;

import com.thunderdev.android.cleanandroidappengine.helloworld.domain.usecase.SayHello;
import com.thunderdev.android.cleanandroidappengine.repository.DefaultRepository;
import com.thunderdev.android.cleanandroidappengine.threading.UseCaseHandler;

/**
 * Created by Audrik ! on 09/10/2016.
 */

public class Injection {
    private static DefaultRepository provideRepository() {
        return DefaultRepository.getInstance();
    }

    public static SayHello provideSayHelloUsecase() {
        return new SayHello(provideRepository());
    }

    public static UseCaseHandler provideUsecaseHandler() {
        return UseCaseHandler.getInstance();
    }
}
