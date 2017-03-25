package pavlov.p.anton.motivation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pavlov.p.anton.motivation.R;
import pavlov.p.anton.motivation.object.Citation;


public class PlaceholderFragment extends Fragment {

    private Citation citation;

    public PlaceholderFragment(Citation citation) {
        this.citation = citation;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView textQuoteView = (TextView) rootView.findViewById(R.id.quote_text);
        TextView textSourceView = (TextView) rootView.findViewById(R.id.source_text);
        TextView textCategoryView = (TextView) rootView.findViewById(R.id.category_text);
        textQuoteView.setText(citation.getQuoteName());
        textSourceView.setText(citation.getSourceName());
        textCategoryView.setText(citation.getCategoryName());

        return rootView;
    }

}
