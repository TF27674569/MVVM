package org.demo.model.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.NonNull;
import org.demo.model.repository.BaseRepository;
import org.demo.model.utils.Utils;
import java.lang.reflect.Constructor;

/**
 * create by TIAN FENG on 2020/3/10
 */
public class BaseViewModel<T extends BaseRepository> extends AndroidViewModel implements LifecycleObserver {

    protected T repository;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        Class<T> repositoryClass = Utils.getGenericSuperclass(this);
        try {
            Constructor<T> constructor = repositoryClass.getConstructor();
            constructor.setAccessible(true);
            repository = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(repositoryClass.getName() + "  must contain a constructor with no parameters");
        }
    }
}
