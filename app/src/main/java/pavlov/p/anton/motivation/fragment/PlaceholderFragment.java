package pavlov.p.anton.motivation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pavlov.p.anton.motivation.R;


public class PlaceholderFragment extends Fragment {
    private String text;

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.main_text);
        textView.setText(text);
        return rootView;
    }

    public void setText(String text) {
        this.text = text;
    }
}
