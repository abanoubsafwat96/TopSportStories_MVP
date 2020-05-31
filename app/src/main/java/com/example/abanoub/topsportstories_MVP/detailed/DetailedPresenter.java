package com.example.abanoub.topsportstories_MVP.detailed;

/**
 * Created by Abanoub on 2018-02-28.
 */

public class DetailedPresenter implements DetailedContract.presenter{

    DetailedContract.view view;

    public DetailedPresenter(DetailedContract.view view) {
        this.view = view;
    }

    @Override
    public void splitPublished_date(String published_date) {
        String[] arr = published_date.split("T");
        view.setPublish_date(arr[0]);
    }
}
