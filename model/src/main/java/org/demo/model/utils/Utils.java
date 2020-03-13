package org.demo.model.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * create by TIAN FENG on 2020/3/10
 */
public class Utils {

    public static <T> Class<T> getGenericSuperclass(Object o) {
        Type type = o.getClass().getGenericSuperclass();
        if (type == null) {
            throw new NullPointerException("not fond generic model class (BaseViewModel).");
        }
        // class<T extends Object ,U extends Object>
        // T type =  getActualTypeArguments()[0]
        // U type =  getActualTypeArguments()[1]
        // ...
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type trueType = parameterizedType.getActualTypeArguments()[0];
        return (Class<T>) trueType;
    }



    private Utils() {
        throw new IllegalStateException("Unable to initialize!");
    }

}
