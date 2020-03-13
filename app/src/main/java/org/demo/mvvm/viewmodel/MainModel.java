package org.demo.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import org.demo.model.model.Chapters;
import org.demo.model.viewmodel.BaseViewModel;
import org.demo.mvvm.repository.MainRepository;

import io.reactivex.Observable;


/**
 * create by TIAN FENG on 2020/3/11
 */
public class MainModel extends BaseViewModel<MainRepository> {

    public MainModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Chapters> getChapters(){
        return repository.getChapters();
    }
}
