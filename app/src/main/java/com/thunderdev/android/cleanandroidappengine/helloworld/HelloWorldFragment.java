package com.thunderdev.android.cleanandroidappengine.helloworld;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.thunderdev.android.cleanandroidappengine.R;
import com.thunderdev.android.cleanandroidappengine.utils.Event;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Audrik ! on 09/10/2016.
 */

public class HelloWorldFragment extends Fragment implements HelloWorldContract.View {
    private HelloWorldContract.Presenter mPresenter;
    private ProgressDialog mProgessDialog;

    @BindView(R.id.hello_textview)
    TextView mHelloTextview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.helloworld_fragment, container, false);
        mProgessDialog = new ProgressDialog(getContext());

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showHelloMessage(String message) {
        hideProgress();
        mHelloTextview.setText(message);
    }

    @Override
    public void showProgress(String msg) {
        if (mProgessDialog != null) {
            mProgessDialog.setMessage(msg);
            mProgessDialog.show();
        }
    }

    @Override
    public void hideProgress() {
        if (mProgessDialog != null) {
            mProgessDialog.dismiss();
        }
    }

    @Override
    public void setPresenter(HelloWorldContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMessage(Event event) {
        hideProgress();
        Toast.makeText(getContext(), event.getEventType()+" : "+ event.getMessage(), Toast.LENGTH_LONG).show();
    }
}
