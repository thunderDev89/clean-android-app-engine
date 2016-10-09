package com.thunderdev.android.cleanandroidappengine.repository;

import com.thunderdev.android.cleanandroidappengine.helloworld.domain.model.Message;
import com.thunderdev.android.cleanandroidappengine.helloworld.repo.HelloWorldRepository;

/**
 * Created by Audrik ! on 09/10/2016.
 */

public class DefaultRepository implements HelloWorldRepository {
    private static DefaultRepository INSTANCE;

    private DefaultRepository() {}

    public static DefaultRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DefaultRepository();
        }
        return INSTANCE;
    }

    @Override
    public void getMessage(Callback callback) {
        Message message = new Message("Welcome Dude !");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.onSuccess(message);
    }
}
