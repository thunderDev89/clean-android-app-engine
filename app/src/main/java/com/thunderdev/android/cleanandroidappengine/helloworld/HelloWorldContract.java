package com.thunderdev.android.cleanandroidappengine.helloworld;

import com.thunderdev.android.cleanandroidappengine.BasePresenter;
import com.thunderdev.android.cleanandroidappengine.BaseView;
import com.thunderdev.android.cleanandroidappengine.utils.Event;

/**
 * Created by Audrik ! on 09/10/2016.
 */
/**
 * This specifies the contract between the view and the presenter.
 */
public interface HelloWorldContract {
    interface View extends BaseView<Presenter> {
        void showHelloMessage(String message);

        void showProgress(String msg);

        void hideProgress();

        void showMessage(Event event);
    }

    interface Presenter extends BasePresenter {
        void sayHello();
    }
}
