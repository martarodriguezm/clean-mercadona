package marta.rodriguez.mercadonaapp.mercadona.ui.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import marta.rodriguez.mercadonaapp.mercadona.R;
import marta.rodriguez.mercadonaapp.mercadona.model.Supermarket;
import marta.rodriguez.mercadonaapp.mercadona.ui.adapters.SupermarketAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SupermarketsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SupermarketsListFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PROVINCE_PARAM = "province_param";

    private String mProvince;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param province province.
     * @return A new instance of fragment SupermarketsListFragment.
     */
    public static SupermarketsListFragment newInstance(String province) {
        SupermarketsListFragment fragment = new SupermarketsListFragment();
        Bundle args = new Bundle();
        if(province == null) {
            province = "Madrid";
        }
        args.putString(PROVINCE_PARAM, province);
        fragment.setArguments(args);
        return fragment;
    }

    public SupermarketsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mProvince = getArguments().getString(PROVINCE_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_supermarkets_list, container, false);
        ButterKnife.bind(this, view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new SupermarketAdapter(new ArrayList<Supermarket>(), R.layout.supermarket_row));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

}
