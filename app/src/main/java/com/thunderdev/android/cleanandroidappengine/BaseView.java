package com.thunderdev.android.cleanandroidappengine;

/**
 * Created by Audrik ! on 08/10/2016.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
