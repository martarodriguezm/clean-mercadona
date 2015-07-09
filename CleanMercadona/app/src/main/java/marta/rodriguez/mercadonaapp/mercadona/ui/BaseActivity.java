package marta.rodriguez.mercadonaapp.mercadona.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import marta.rodriguez.mercadonaapp.mercadona.R;

/**
 * Created by martarodriguez on 8/7/15.
 */
public class BaseActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM = "SELECTED_ITEM";

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;

    private int selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        selectedItem = getIntent().getIntExtra(SELECTED_ITEM, R.id.drawer_map);
    }

    protected void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.accent));
            drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_white_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    protected void setupDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView.getMenu().findItem(selectedItem).setChecked(true);

                navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        Intent currentIntent = BaseActivity.this.getIntent();
                        switch (menuItem.getItemId()) {
                            case R.id.drawer_map:
                                if (!currentIntent.getAction().equals(MainActivity.class.getCanonicalName())) {
                                    Intent intent = new Intent(BaseActivity.this, MainActivity.class);
                                    intent.putExtra(SELECTED_ITEM, menuItem.getItemId());
                                    startActivity(intent);
                                    finish();
                                }
                                return true;
                            case R.id.drawer_list:
                                if (!currentIntent.getAction().equals(SupermarketsListActivity.class.getCanonicalName())) {
                                    Intent intent = new Intent(BaseActivity.this, SupermarketsListActivity.class);
                                    intent.putExtra(SELECTED_ITEM, menuItem.getItemId());
                                    startActivity(intent);
                                    finish();
                                }
                                break;
                        }
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }

    protected boolean isNavDrawerOpen() {
        return drawerLayout != null && drawerLayout.isDrawerOpen(Gravity.START);
    }

    protected void closeNavDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(Gravity.START);
        }
    }
}
