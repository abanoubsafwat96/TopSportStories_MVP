package com.example.abanoub.topsportstories_MVP.main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.abanoub.topsportstories_MVP.Communicator;
import com.example.abanoub.topsportstories_MVP.R;
import com.example.abanoub.topsportstories_MVP.StoriesAdapter;
import com.example.abanoub.topsportstories_MVP.Story;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainContract.view {

    MainPresenter mainPresenter;
    Communicator mainCommunicator;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        listView = (ListView) root.findViewById(R.id.listview);

        // Create the presenter
        mainPresenter = new MainPresenter(getContext(), this);
        mainPresenter.startAsyncTask();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Story story = (Story) adapterView.getAdapter().getItem(position);
                mainCommunicator.sendStory(story);
            }
        });

        return root;
    }

    // used to make two pane UI
    public void setActivityReference(Communicator mainCommunicator) {
        this.mainCommunicator = mainCommunicator;
    }

    @Override
    public void setListAdapter(StoriesAdapter adapter) {
        listView.setAdapter(adapter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mainCommunicator = null;
    }
}
