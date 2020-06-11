package com.single.mvpandroid.mvp;

import com.single.mvpandroid.Fit;
import com.single.mvpandroid.MainApi;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FitModel implements MainContract.Model {
    private List<Fit> fitlist;

    @Override
    public void getFitList(MainContract.Presenter listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sample.fitnesskit-admin.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        final MainApi api = retrofit.create(MainApi.class);
        Call<List<Fit>> call = api.data();
        call.enqueue(new Callback<List<Fit>>() {
            @Override
            public void onResponse(Call<List<Fit>> call, Response<List<Fit>> response) {
                if (response.isSuccessful()) {
                    fitlist = response.body();
                    listener.onSuccess(fitlist);
                }
            }

            @Override
            public void onFailure(Call<List<Fit>> call, Throwable t) {
                listener.onError(t);

            }
        });
    }
}
