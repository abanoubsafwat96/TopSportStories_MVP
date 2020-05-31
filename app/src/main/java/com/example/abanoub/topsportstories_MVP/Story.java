package com.example.abanoub.topsportstories_MVP;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Abanoub on 2018-01-31.
 */

public class Story implements Parcelable {
    public String section;
    public String subsection;
    public String title;
    public String abstract_;
    public String url;
    public String byline;
    public String published_date;
    public String photo_url;
    public String photo_caption;
    public String photo_copyright;

    public String HD_photo_url;
    public String HD_photo_height;
    public String HD_photo_width;

    public Story() {
    }

    protected Story(Parcel in) {
        section = in.readString();
        subsection = in.readString();
        title = in.readString();
        abstract_ = in.readString();
        url = in.readString();
        byline = in.readString();
        published_date = in.readString();
        photo_url = in.readString();
        photo_caption = in.readString();
        photo_copyright = in.readString();
        HD_photo_url = in.readString();
        HD_photo_height = in.readString();
        HD_photo_width = in.readString();
    }

    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(section);
        dest.writeString(subsection);
        dest.writeString(title);
        dest.writeString(abstract_);
        dest.writeString(url);
        dest.writeString(byline);
        dest.writeString(published_date);
        dest.writeString(photo_url);
        dest.writeString(photo_caption);
        dest.writeString(photo_copyright);
        dest.writeString(HD_photo_url);
        dest.writeString(HD_photo_height);
        dest.writeString(HD_photo_width);
    }
}
