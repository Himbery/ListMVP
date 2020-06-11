package com.single.mvpandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.single.mvpandroid.mvp.MainContract;
import com.single.mvpandroid.mvp.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    RecyclerView recyclerView;
    FitAdapter adapter;
    List<Fit> fitList = new ArrayList<>();
    MainContract.Presenter presenter;
    MainContract.Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        presenter.getFits();
        presenter.onSuccess(fitList);
    }

    @Override
    public void displayFitData(List<Fit> list) {
        recyclerView = findViewById(R.id.list_fit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FitAdapter(list);
        recyclerView.setAdapter(adapter);

    }
}
