package pavlov.p.anton.motivation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
//        TextView textCategoryView = (TextView) rootView.findViewById(R.id.category_text);


        textQuoteView.setText(citation.getQuote());
        textSourceView.setText(citation.getAuthor());
//        textCategoryView.setText(firstUpperCase(citation.getCategoryName()));

        return rootView;
    }

//    public String firstUpperCase(String word) {
//        if (word == null || word.isEmpty()) return "";//или return word;
//        return word.substring(0, 1).toUpperCase() + word.substring(1);
//    }
}
