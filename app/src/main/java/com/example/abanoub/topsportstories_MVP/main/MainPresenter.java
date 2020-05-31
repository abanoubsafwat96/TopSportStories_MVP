package com.example.abanoub.topsportstories_MVP.main;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.abanoub.topsportstories_MVP.StoriesAdapter;
import com.example.abanoub.topsportstories_MVP.Story;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Abanoub on 2018-02-28.
 */

public class MainPresenter implements MainContract.presenter {

    ArrayList<Story> list = new ArrayList<>();
    MainContract.view view;
    Context context;

    public MainPresenter(Context context,MainContract.view view) {
        this.context=context;
        this.view=view;
    }

    @Override
    public void startAsyncTask(){

        StoriesAsyncTask storiesAsyncTask = new StoriesAsyncTask();
        storiesAsyncTask.execute("http://api.nytimes.com/svc/topstories/v2/sports.json?api-key=4a89767769cf4cc583728f4e3d997252");
    }

    class StoriesAsyncTask extends AsyncTask<String, Void, ArrayList<Story>> {

        @Override
        protected ArrayList<Story> doInBackground(String... params) {
            HttpURLConnection connection = null;
            InputStream inputstream = null;
            BufferedReader bufferedreader = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                inputstream = connection.getInputStream();

                bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = bufferedreader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJson = buffer.toString();

                JSONObject jobj = new JSONObject(finalJson);
                JSONArray jarr = jobj.getJSONArray("results");

                for (int i = 0; i < jarr.length(); i++) {
                    Story story = new Story();

                    JSONObject jrealobj = jarr.getJSONObject(i);
                    story.section = jrealobj.getString("section");
                    story.subsection = jrealobj.getString("subsection");
                    story.title = jrealobj.getString("title");
                    story.abstract_ = jrealobj.getString("abstract");
                    story.url = jrealobj.getString("url");
                    story.byline = jrealobj.getString("byline");
                    story.published_date = jrealobj.getString("published_date");

                    JSONArray jarr2 = jrealobj.getJSONArray("multimedia");
                    for (int j = 3; j < 5; j++) {
                        jrealobj = jarr2.getJSONObject(j);
                        if (j == 3)
                            story.photo_url = jrealobj.getString("url");
                        if (j == 4) {
                            story.HD_photo_url = jrealobj.getString("url");
                            story.HD_photo_height = jrealobj.getString("height");
                            story.HD_photo_width = jrealobj.getString("width");
                            story.photo_caption = jrealobj.getString("caption");
                            story.photo_copyright = jrealobj.getString("copyright");
                        }
                    }

                    list.add(story);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                Log.e("doInBackground: ", e + "");
            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<Story> result) {
            super.onPostExecute(result);

            StoriesAdapter adapter = new StoriesAdapter(context, list);
            view.setListAdapter(adapter);
        }
    }
}
