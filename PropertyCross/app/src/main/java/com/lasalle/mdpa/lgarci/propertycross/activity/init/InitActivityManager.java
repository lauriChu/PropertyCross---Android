package com.lasalle.mdpa.lgarci.propertycross.activity.init;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.lasalle.mdpa.lgarci.propertycross.R;
import com.lasalle.mdpa.lgarci.propertycross.activity.main.MainActivity;
import com.lasalle.mdpa.lgarci.propertycross.googleapi.LocationManager;

import static com.lasalle.mdpa.lgarci.propertycross.Argument.TEXT_SEARCH;
import static com.lasalle.mdpa.lgarci.propertycross.Argument.TYPE_SEARCH;
import static com.lasalle.mdpa.lgarci.propertycross.viewmodel.Property.PROPERTY_TYPE_RENT;
import static com.lasalle.mdpa.lgarci.propertycross.viewmodel.Property.PROPERTY_TYPE_SELL;

/**
 * Created by FurruPi on 1/4/17.
 */

public class InitActivityManager extends LocationManager{
    private InitActivity mActivity; //InitActivity

    /**
     * Layout Views
     */
    private Button searchButton, rentButton, sellButton;
    private ImageButton locationButton;
    private TextInputEditText searchEditText;
    private String searchTypeSelected;

    /**
     * GoogleApi - Get current location
     */
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;

    /**
     * Public constructor of manager
     * @param initActivity
     */
    public InitActivityManager(InitActivity initActivity){
        this.mActivity = initActivity;
        this.mActivity.setContentView(R.layout.activity_init);
        mGoogleApiClient = getDefaultGoogleConnection(mActivity);
        initViewLayout();
    }

    /**
     * Initialize Layout
     */
    public void initViewLayout(){
        mActivity.getSupportActionBar().hide();
        inflateAllViews();
        addListeners();
    }

    /**
     * Inflate All Views of the Layout
     */
    private void inflateAllViews() {
        searchButton = (Button) mActivity.findViewById(R.id.button_search);
        rentButton = (Button) mActivity.findViewById(R.id.button_rent);
        sellButton = (Button) mActivity.findViewById(R.id.button_sell);
        locationButton = (ImageButton) mActivity.findViewById(R.id.imageButton_location);
        searchEditText = (TextInputEditText) mActivity.findViewById(R.id.editText_search);
        searchEditText.clearFocus();
    }

    /**
     * Add Listeners for buttons
     */
    private void addListeners() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchEditText.getText() != null && !searchEditText.getText().toString().isEmpty()) {
                    toMainActivity();
                } else {
                    searchEditText.setError(mActivity.getString(R.string.search_error_message));
                }
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchTypeSelected = PROPERTY_TYPE_SELL;
            }
        });

        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchTypeSelected = PROPERTY_TYPE_RENT;
            }
        });

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mLastLocation != null) {
                    setTextOfLocation();
                }else{
                    mGoogleApiClient.connect();
                }
            }
        });
    }

    /**
     * Add Text Of Current Location
     */
    private void setTextOfLocation(){
        searchEditText.setText(String.valueOf(mLastLocation.getLatitude()) + " " +
                String.valueOf(mLastLocation.getLongitude()));
        // TODO: APi Google for extract the name
    }

    /**
     * On GoogleConnection established method - obtains current location
     */
    public void onGoogleConnected(){
        if (ActivityCompat.checkSelfPermission(mActivity,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_FINE_LOCATION);

            mGoogleApiClient.disconnect();
            return;
        }

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);

        if (mLastLocation != null) {
            setTextOfLocation();
        }
    }

    @Override
    public void doGoogleConnect() {
        mGoogleApiClient.connect();
    }

    @Override
    public void doGoogleDisconnect() {
        mGoogleApiClient.disconnect();
    }

    /**
     * Navigates To MainActivity
     */
    private void toMainActivity() {
        Intent intent = new Intent(mActivity, MainActivity.class);
        intent.putExtra(TYPE_SEARCH, searchTypeSelected != null ? searchTypeSelected : PROPERTY_TYPE_SELL);
        intent.putExtra(TEXT_SEARCH, searchEditText.getText().toString());
        mActivity.startActivity(intent);
    }
}
