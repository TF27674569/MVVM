package org.demo.mvvm.repository;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import org.demo.model.http.RetrofitService;
import org.demo.model.model.Chapters;
import org.demo.model.repository.BaseRepository;

import io.reactivex.functions.Consumer;

/**
 * create by TIAN FENG on 2020/3/13
 */
public class MainRepository extends BaseRepository {

    public LiveData<Chapters> getChapters() {
        final MutableLiveData<Chapters> liveData = new MutableLiveData<>();
        RetrofitService.get().getChapters().subscribe(new Consumer<Chapters>() {
            @Override
            public void accept(Chapters chapters) throws Exception {
                liveData.postValue(chapters);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                liveData.postValue(null);
            }
        });
        return liveData;
    }
}
