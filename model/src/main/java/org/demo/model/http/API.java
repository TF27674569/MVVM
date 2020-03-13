package org.demo.model.http;

import org.demo.model.model.Chapters;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * create by TIAN FENG on 2020/3/10
 */
public interface API {


    /**
     * 公众号列表
     */
    @GET(Url.CHAPTERS)
    Observable<Chapters> getChapters();
}
