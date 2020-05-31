package com.example.abanoub.topsportstories_MVP.main;

import com.example.abanoub.topsportstories_MVP.StoriesAdapter;

/**
 * Created by Abanoub on 2018-02-28.
 */

public interface MainContract {

    interface view {

        void setListAdapter(StoriesAdapter adapter);
    }

    interface presenter {

        void startAsyncTask();
    }
}
