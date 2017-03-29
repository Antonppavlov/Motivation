package pavlov.p.anton.motivation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import pavlov.p.anton.motivation.R;
import pavlov.p.anton.motivation.object.Post;


public class PlaceholderFragment extends Fragment {

    private Post citation;

    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance(Post citation) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        fragment.citation = citation;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView textQuoteView = (TextView) rootView.findViewById(R.id.quote_text);
        TextView textSourceView = (TextView) rootView.findViewById(R.id.source_text);


        CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.chbFavorite);
        checkBox.setChecked(citation.getFavorite());

        textQuoteView.setText(citation.getQuote());
        textSourceView.setText(citation.getAuthor());

        return rootView;
    }


}
