package marta.rodriguez.mercadonaapp.mercadona.ui;

import android.os.Bundle;

import butterknife.ButterKnife;
import marta.rodriguez.mercadonaapp.mercadona.R;
import marta.rodriguez.mercadonaapp.mercadona.ui.fragments.MercadonaMapFragment;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initToolbar();
        setupDrawerLayout();

        getFragmentManager().beginTransaction()
                .add(R.id.content, MercadonaMapFragment.newInstance(null))
                .commit();
    }

}
