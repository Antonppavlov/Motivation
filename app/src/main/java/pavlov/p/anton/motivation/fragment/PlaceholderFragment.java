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
    //private String textMain;
//    private String textSource;
    private Citation citation;

    public PlaceholderFragment(Citation citation) {
        this.citation = citation;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textMainView = (TextView) rootView.findViewById(R.id.main_text);
        TextView textSourceView = (TextView) rootView.findViewById(R.id.source_text);
        textMainView.setText(citation.getTextMain());
        textSourceView.setText(citation.getSourceMain());
        return rootView;
    }

//    public void setText(Citation text) {
//        this.textMain = text.getTextMain();
//        this.textSource = text.getSourceMain();
//    }
}
