package pavlov.p.anton.motivation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.sql.SQLException;

import pavlov.p.anton.motivation.R;
import pavlov.p.anton.motivation.dao.FilterDAO;
import pavlov.p.anton.motivation.database.Initializer;
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
//        final TextView textIdText = (TextView) rootView.findViewById(R.id.id_text);
        final CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.chbFavorite);

        boolean statusCheckBox = false;
        if (citation.getFavorite().equals("true")) {
            statusCheckBox = true;
        }

        textQuoteView.setText(citation.getQuote());
        textSourceView.setText(citation.getAuthor());
//        textIdText.setText(String.valueOf(citation.getId()));
        checkBox.setChecked(statusCheckBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            FilterDAO filterDAO = Initializer.getCreatePosts().getFilterDAO();
                                            try {
                                                filterDAO.updateQuoteStatusFavorite(checkBox.isChecked(), citation.getId());
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }

                                            Log.i("ID", String.valueOf(citation.getId()) + "     checked:   " + String.valueOf(checkBox.isChecked()));

                                        }
                                    }
        );
        return rootView;
    }


}
