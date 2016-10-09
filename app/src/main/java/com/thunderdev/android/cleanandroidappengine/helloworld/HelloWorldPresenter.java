package com.thunderdev.android.cleanandroidappengine.helloworld;

import android.support.annotation.NonNull;

import com.thunderdev.android.cleanandroidappengine.UseCase;
import com.thunderdev.android.cleanandroidappengine.helloworld.domain.usecase.SayHello;
import com.thunderdev.android.cleanandroidappengine.threading.UseCaseHandler;
import com.thunderdev.android.cleanandroidappengine.utils.Event;

/**
 * Created by Audrik ! on 09/10/2016.
 */

public class HelloWorldPresenter implements HelloWorldContract.Presenter {
    private final HelloWorldContract.View mView;

    private final SayHello mUsecase;

    private final UseCaseHandler mUseCaseHandler;

    public HelloWorldPresenter(@NonNull UseCaseHandler useCaseHandler, @NonNull HelloWorldContract.View helloView,
                               @NonNull SayHello helloUsecase) {
        mView = helloView;
        mUsecase = helloUsecase;
        mUseCaseHandler = useCaseHandler;

        mView.setPresenter(this);
    }

    @Override
    public void start() {
        sayHello();
    }

    @Override
    public void sayHello() {
        mView.showProgress("Please wait");

        mUseCaseHandler.execute(mUsecase,
                new SayHello.RequestValues(),
                new UseCase.UseCaseCallback<SayHello.ResponseValues>() {
                    @Override
                    public void onSuccess(SayHello.ResponseValues response) {
                        mView.showHelloMessage(response.getMessage().getMessage());
                    }

                    @Override
                    public void onError() {
                        mView.showMessage(new Event(Event.EVENT_TYPE_ERROR, "Error when getting message"));
                    }
                });
    }
}
