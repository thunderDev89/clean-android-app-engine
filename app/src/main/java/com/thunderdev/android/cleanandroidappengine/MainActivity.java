package com.thunderdev.android.cleanandroidappengine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thunderdev.android.cleanandroidappengine.helloworld.HelloWorldFragment;
import com.thunderdev.android.cleanandroidappengine.helloworld.HelloWorldPresenter;
import com.thunderdev.android.cleanandroidappengine.utils.Injection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloWorldFragment helloWorldFragment = (HelloWorldFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if (helloWorldFragment == null) {
            helloWorldFragment = new HelloWorldFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFrame, helloWorldFragment)
                    .commit();
        }

        new HelloWorldPresenter(Injection.provideUsecaseHandler(),
                helloWorldFragment,
                Injection.provideSayHelloUsecase());
    }
}
