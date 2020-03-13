package org.demo.mvvm.activity;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import org.demo.model.activity.BaseActivity;
import org.demo.model.model.Chapters;
import org.demo.model.utils.MyLogger;
import org.demo.mvvm.R;
import org.demo.mvvm.viewmodel.MainModel;


public class MainActivity extends BaseActivity<MainModel> implements View.OnClickListener {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        viewModel.getChapters()
                .observe(this, new Observer<Chapters>() {
                    @Override
                    public void onChanged(@Nullable Chapters chapters) {
                        MyLogger.tLog().d(chapters);
                    }
                });
    }


    @Override
    public void onClick(View v) {

    }
}
