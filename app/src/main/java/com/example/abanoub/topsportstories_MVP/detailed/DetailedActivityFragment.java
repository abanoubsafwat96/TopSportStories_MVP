package com.example.abanoub.topsportstories_MVP.detailed;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abanoub.topsportstories_MVP.R;
import com.example.abanoub.topsportstories_MVP.Story;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailedActivityFragment extends Fragment implements DetailedContract.view {

    DetailedPresenter presenter;
    Story story;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_detailed, container, false);

        story = getArguments().getParcelable("story");

        presenter=new DetailedPresenter(this);

        ((TextView) root.findViewById(R.id.section)).setText(story.section);
        ((TextView) root.findViewById(R.id.subsection)).setText(story.subsection);
        ((TextView) root.findViewById(R.id.title)).setText(story.title);
        ((TextView) root.findViewById(R.id.byline)).setText(story.byline);

        presenter.splitPublished_date(story.published_date);
        ((TextView) root.findViewById(R.id.published_date)).setText(story.published_date);

        Glide.with(this)
                .load(story.HD_photo_url)
                .into((ImageView) root.findViewById(R.id.photo));

        ((TextView) root.findViewById(R.id.caption)).setText(story.photo_caption);
        ((TextView) root.findViewById(R.id.copyright)).setText(story.photo_copyright);
        ((TextView) root.findViewById(R.id.description)).setText(story.abstract_);

        TextView url = (TextView) root.findViewById(R.id.url);

        url.setClickable(true);
        url.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='" + story.url + "'> " + story.url + " </a>";
        url.setText(Html.fromHtml(text));

        return root;
    }

    @Override
    public void setPublish_date(String publish_date) {
        story.published_date=publish_date;
    }
}
