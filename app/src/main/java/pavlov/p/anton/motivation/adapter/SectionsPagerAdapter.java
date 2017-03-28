package pavlov.p.anton.motivation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

import pavlov.p.anton.motivation.R;
import pavlov.p.anton.motivation.create.CreatePosts;
import pavlov.p.anton.motivation.fragment.PlaceholderFragment;
import pavlov.p.anton.motivation.object.Post;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    private List<Post> postList;
    private AppCompatActivity mainActivity;

    public SectionsPagerAdapter(AppCompatActivity mainActivity, FragmentManager fm, List<Post> postList) {
        super(fm);
        this.mainActivity = mainActivity;
        this.postList = postList;
    }

    @Override
    public Fragment getItem(int position) {
        Post post = postList.get(position);

        PlaceholderFragment placeholderFragment = PlaceholderFragment.newInstance(post);

        Toolbar toolbar = (Toolbar) mainActivity.findViewById(R.id.toolbar);
        toolbar.setTitle(firstUpperCase(post.getCategory()));

        return placeholderFragment;
    }

    @Override
    public int getCount() {
        return postList.size();
    }



    public String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
