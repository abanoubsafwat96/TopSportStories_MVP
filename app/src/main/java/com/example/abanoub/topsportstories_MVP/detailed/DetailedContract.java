package com.example.abanoub.topsportstories_MVP.detailed;

/**
 * Created by Abanoub on 2018-02-28.
 */

public interface DetailedContract {

    interface view{
        void setPublish_date(String publish_date);
    }
    interface presenter{
        void splitPublished_date(String published_date);
    }
}
