package marta.rodriguez.mercadonaapp.mercadona.ui.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import marta.rodriguez.mercadonaapp.mercadona.R;

/**
 * Created by martarodriguez on 8/7/15.
 */
public class SupermarketsMapFragment extends Fragment implements OnMapReadyCallback, LocationListener {

    private static final String PROVINCE_PARAM = "province_param";
    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;

    private String mProvince;

    private LocationManager locationManager;
    private GoogleMap mMap;
    private MapFragment mMapFragment;
    private View rootView;

    public static SupermarketsMapFragment newInstance(String province) {
        SupermarketsMapFragment fragment = new SupermarketsMapFragment();
        Bundle args = new Bundle();
        if(province == null) {
            province = "Madrid";
        }
        args.putString(PROVINCE_PARAM, province);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setRetainInstance(true);

        if (getArguments() != null) {
            mProvince = getArguments().getString(PROVINCE_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_map, container, false);

            mMapFragment = MapFragment.newInstance();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.map_container, mMapFragment).commit();
            getChildFragmentManager().executePendingTransactions();


            initMap();
        }
        return rootView;
    }

    private void initMap() {
        if(mMap == null) {
            mMapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (mMap != null) {
            mMap.setMyLocationEnabled(true);

            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        initMap();
        if(mMap != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        }
        locationManager.removeUpdates(this);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //Nothing to do
    }

    @Override
    public void onProviderEnabled(String provider) {
        //Nothing to do
    }

    @Override
    public void onProviderDisabled(String provider) {
        //Nothing to do
    }
}
