package marta.rodriguez.mercadonaapp.mercadona.ui;

import android.os.Bundle;

import butterknife.ButterKnife;
import marta.rodriguez.mercadonaapp.mercadona.R;
import marta.rodriguez.mercadonaapp.mercadona.ui.fragments.SupermarketsListFragment;

public class SupermarketsListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarkets_list);

        getIntent().setAction(SupermarketsListActivity.class.getCanonicalName());

        ButterKnife.bind(this);

        initToolbar();
        setupDrawerLayout();

        getFragmentManager().beginTransaction()
                .add(R.id.content, SupermarketsListFragment.newInstance(null))
                .commit();
    }
}
