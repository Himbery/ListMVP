package com.single.mvpandroid.mvp;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mainView;
    private MainContract.Model mainModel;

    public  MainPresenter(MainContract.View mView){
        mainView = mView;
        mainModel = new FitModel();

    }
    @Override
    public void getFits() {
        mainModel.getFitList(this);
    }

    @Override
    public void onSuccess(List list) {
        mainView.displayFitData(list);
    }

    @Override
    public void onError(Throwable throwable) {

    }
}
