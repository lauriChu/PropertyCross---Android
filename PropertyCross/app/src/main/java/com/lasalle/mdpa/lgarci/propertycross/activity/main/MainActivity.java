package com.lasalle.mdpa.lgarci.propertycross.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.lasalle.mdpa.lgarci.propertycross.R;

public class MainActivity extends AppCompatActivity implements OnMainReceiveEvent{

    private MainActivityManager mainActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityManager = new MainActivityManager(this);

    }


    @Override
    public void onNavigateToProperty(int propertyId) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mainActivityManager.onOrientationChange(newConfig.orientation);
    }

    @Override
    public void onBackPressed() {
        /*Intent data = new Intent();
        Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
        data.putExtra("a", bundle);
        setResult(123, data);*/
        // add data to Intent

        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
