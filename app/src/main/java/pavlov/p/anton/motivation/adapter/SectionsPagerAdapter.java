package pavlov.p.anton.motivation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import pavlov.p.anton.motivation.create.CreateCitation;
import pavlov.p.anton.motivation.database.Initializer;
import pavlov.p.anton.motivation.fragment.PlaceholderFragment;
import pavlov.p.anton.motivation.object.Citation;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    private List<Citation> citationList;

    public SectionsPagerAdapter(FragmentManager fm,List<Citation> citationList) {
        super(fm);
        this.citationList=citationList;
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("DEV",String.valueOf(position));
        Log.i("DEV",citationList.get(position).getTextMain());
        Log.i("DEV",citationList.get(position).getSourceMain());

//        PlaceholderFragment placeholderFragment = new PlaceholderFragment();
//        placeholderFragment.setText(citationList.get(position));

        return new PlaceholderFragment(citationList.get(position));
    }

    @Override
    public int getCount() {
        return citationList.size();
    }


}
