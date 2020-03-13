package org.demo.model.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.demo.model.utils.Utils;
import org.demo.model.viewmodel.BaseViewModel;


/**
 * create by TIAN FENG on 2020/3/10
 */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

    protected T viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        // get T.class
        Class<T> modelClass = Utils.getGenericSuperclass(this);
        // get view model
        viewModel = ViewModelProviders.of(this).get(modelClass);
        getLifecycle().addObserver(viewModel);
        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

}
