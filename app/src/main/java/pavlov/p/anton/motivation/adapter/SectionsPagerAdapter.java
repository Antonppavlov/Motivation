package pavlov.p.anton.motivation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import pavlov.p.anton.motivation.fragment.PlaceholderFragment;
import pavlov.p.anton.motivation.object.Post;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    private List<Post> postList;

    public SectionsPagerAdapter(FragmentManager fm, List<Post> postList) {
        super(fm);
        this.postList = postList;
    }


    @Override
    public Fragment getItem(int position) {
        Post post = postList.get(position);
        return PlaceholderFragment.newInstance(post);
    }


    @Override
    public int getCount() {
        return postList.size();
    }

}
