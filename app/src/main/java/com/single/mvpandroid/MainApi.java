package com.single.mvpandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MainApi {

    @GET("schedule/get_group_lessons_v2/1")
    Call<List<Fit>> data();
}
