package com.single.mvpandroid.mvp;

import com.single.mvpandroid.Fit;
import java.util.List;
import io.reactivex.annotations.NonNull;

public interface MainContract {

    interface View {
        void displayFitData(List<Fit> list);

    }
    interface Presenter {
        void getFits();

        void onSuccess(@NonNull List list);

        void onError(@NonNull Throwable throwable);
    }
    interface Model {
        void getFitList(Presenter listener);
    }

}
