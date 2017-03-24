package pavlov.p.anton.motivation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.List;

import pavlov.p.anton.motivation.R;
import pavlov.p.anton.motivation.adapter.SectionsPagerAdapter;
import pavlov.p.anton.motivation.app.DbConnection;
import pavlov.p.anton.motivation.database.Initializer;
import pavlov.p.anton.motivation.object.Citation;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.AppTheme_NoActionBar);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        mViewPager = (ViewPager) findViewById(R.id.container);
        //  List<Citation> citationList = new Initializer().l();
        mSectionsPagerAdapter = new SectionsPagerAdapter(
                getSupportFragmentManager(),
                Initializer.getCitationList());

        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

}
