package com.thunderdev.android.cleanandroidappengine.helloworld.repo;

import com.thunderdev.android.cleanandroidappengine.helloworld.domain.model.Message;

/**
 * Created by Audrik ! on 09/10/2016.
 */

public interface HelloWorldRepository {
    interface Callback {
        void onSuccess(Message message);

        void onError();
    }

    void getMessage(Callback callback);
}
