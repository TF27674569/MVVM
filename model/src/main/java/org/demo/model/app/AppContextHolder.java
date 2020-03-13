package org.demo.model.app;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * create by TIAN FENG on 2020/3/13
 */
public class AppContextHolder {

    private WeakReference<Context> mWeakReference;

    private AppContextHolder() {
    }

    public static AppContextHolder get() {
        return INNER.INSTANCE.holder;
    }

    public void init(Context context) {
        if (mWeakReference != null) {
            mWeakReference.clear();
        }
        mWeakReference = new WeakReference<>(context.getApplicationContext());
    }

    /**
     * 返回Application context
     */
    public Context getContext() {
        if (mWeakReference == null) {
            throw new RuntimeException("请先初始化AppContextHolder");
        } else {
            return mWeakReference.get();
        }
    }


    private enum INNER {
        INSTANCE;
        private AppContextHolder holder;

        INNER() {
            holder = new AppContextHolder();
        }
    }
}
