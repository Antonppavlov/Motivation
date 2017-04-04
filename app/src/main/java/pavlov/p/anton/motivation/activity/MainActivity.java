package pavlov.p.anton.motivation.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import pavlov.p.anton.motivation.R;
import pavlov.p.anton.motivation.adapter.SectionsPagerAdapter;
import pavlov.p.anton.motivation.app.DbConnection;
import pavlov.p.anton.motivation.dao.FilterDAO;
import pavlov.p.anton.motivation.dao.Type;
import pavlov.p.anton.motivation.database.Initializer;
import pavlov.p.anton.motivation.object.Post;

public class MainActivity extends AppCompatActivity {

    private final static int LAYOUT = R.layout.activity_main;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            DbConnection.initConnection(getApplicationContext());
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getSQLState(), Toast.LENGTH_SHORT).show();
        }

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setTheme(R.style.AppTheme_NoActionBar);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(LAYOUT);
        initToolbar();

        List<Post> shufflePostList = Initializer.getCreatePosts().getFilterDAO().getPostList();

        createViewPager(shufflePostList);

        initNavigationView();
    }

    private void createViewPager(List<Post> postList) {
        mViewPager = (ViewPager) findViewById(R.id.container);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), postList);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        toolbar.setTitle(R.string.random);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.search: {
                        toolbar.setTitle(R.string.found);
                        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

                        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                FilterDAO filterDAO = Initializer.getCreatePosts().getFilterDAO();
                                List<Post> filterPostsByText = null;
                                try {
                                    filterPostsByText = filterDAO.getFilterPostsByText(query);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    Toast.makeText(getApplicationContext(), e.getSQLState(), Toast.LENGTH_SHORT).show();
                                }
                                createViewPager(filterPostsByText);
                                Toast toast = Toast.makeText(getApplicationContext(), "Результат поиска: " + filterPostsByText.size(), Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP, 0, 150);
                                toast.show();
                                searchView.setIconified(false);
                                searchView.onActionViewCollapsed();

                                toolbar.collapseActionView();
                                searchView.onFinishTemporaryDetach();
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(String newText) {
                                return false;
                            }
                        });

                        return false;
                    }
                }
                return false;
            }
        });
    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                toolbar.collapseActionView();
                FilterDAO filterDAO = Initializer.getCreatePosts().getFilterDAO();

                switch (item.getItemId()) {

                    case R.id.item_nav_menu_random: {
                        createViewPager(filterDAO.getShufflePostList());
                        toolbar.setTitle(R.string.random);
                        break;
                    }
                    case R.id.item_nav_menu_our_films: {
                        createViewPager(filterDAO.getPostList(Type.OUR_FILMS));
                        toolbar.setTitle(R.string.our_films);
                        break;
                    }
                    case R.id.item_nav_menu_foreign_films: {
                        createViewPager(filterDAO.getPostList(Type.FOREIGN_FILMS));
                        toolbar.setTitle(R.string.foreign_films);
                        break;
                    }
                    case R.id.item_nav_menu_people: {
                        createViewPager(filterDAO.getPostList(Type.PEOPLE));
                        toolbar.setTitle(R.string.people);
                        break;
                    }
                    case R.id.item_nav_menu_cartoons: {
                        createViewPager(filterDAO.getPostList(Type.CARTOONS));
                        toolbar.setTitle(R.string.cartoons);
                        break;
                    }
                    case R.id.item_nav_menu_favorites: {
                        try {
                            createViewPager(filterDAO.getFavoriteAllPost());
                        } catch (SQLException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), e.getSQLState(), Toast.LENGTH_SHORT).show();
                        }
                        toolbar.setTitle(R.string.faforites);
                        break;
                    }
                }
                return true;
            }
        });
    }


    public void clickText(View view) {
        toolbar.collapseActionView();
    }

    public void clickFavorite(View view) throws SQLException {
        FilterDAO filterDAO = Initializer.getCreatePosts().getFilterDAO();
        CheckBox checkBox = (CheckBox) view;
        boolean checked = checkBox.isChecked();


        String text;
        if (checked) {
            text = "В избранное!";
        } else {
            text = "Удалено из избранного!";
        }
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();


        TextView idText = (TextView) findViewById(R.id.id_text);
        Integer id = Integer.valueOf(idText.getText().toString());
        filterDAO.updateQuoteStatusFavorite(checked, id);
    }
}
