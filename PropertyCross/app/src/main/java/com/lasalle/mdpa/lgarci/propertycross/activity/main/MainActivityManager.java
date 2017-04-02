package com.lasalle.mdpa.lgarci.propertycross.activity.main;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.lasalle.mdpa.lgarci.propertycross.R;
import com.lasalle.mdpa.lgarci.propertycross.activity.main.fragment.FavouriteFragment;
import com.lasalle.mdpa.lgarci.propertycross.activity.main.fragment.MapFragment;
import com.lasalle.mdpa.lgarci.propertycross.activity.main.fragment.search.SearchFragment;
import com.lasalle.mdpa.lgarci.propertycross.activity.main.fragment.UserFragment;
import com.lasalle.mdpa.lgarci.propertycross.activity.search.SearchActivity;

import static com.lasalle.mdpa.lgarci.propertycross.Constant.FRAGMENT_ID_FAVOURITE;
import static com.lasalle.mdpa.lgarci.propertycross.Constant.FRAGMENT_ID_MAP;
import static com.lasalle.mdpa.lgarci.propertycross.Constant.FRAGMENT_ID_SEARCH;
import static com.lasalle.mdpa.lgarci.propertycross.Constant.FRAGMENT_ID_USER;

/**
 * Created by FurruPi on 1/4/17.
 */

public class MainActivityManager {

    private ActionBar actionBar;
    private FragmentManager fragmentManager;

    /**
     * Manager constructor
     */
    public MainActivityManager(MainActivity activity){
        initViewLayout(activity);
        this.fragmentManager = activity.getSupportFragmentManager();
        this.actionBar = activity.getSupportActionBar();
    }

    /**
     * Bottom Navigation Listener
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(FRAGMENT_ID_SEARCH);
                    return true;
                case R.id.navigation_favourite:
                    changeFragment(FRAGMENT_ID_FAVOURITE);
                    return true;
                case R.id.navigation_user:
                    changeFragment(FRAGMENT_ID_USER);
                    return true;
            }
            return false;
        }

    };

    /**
     * Initialize Layout
     */
    private void initViewLayout(MainActivity activity){
        activity.setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) activity.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    /**
     * Hide or Unhide ActionBar
     */
    private void hideOrUnhideSupportActionBar(boolean hide) {
        if ( hide ) {
            actionBar.hide();
        } else {
            actionBar.show();
        }
    }

    /**
     * Orientation Management
     */
    public void onOrientationChange(int newOrientation){
        changeFragment(newOrientation == Configuration.ORIENTATION_LANDSCAPE ? FRAGMENT_ID_MAP : FRAGMENT_ID_SEARCH);
    }

    /**
     * Navigation Management
     */
    public void navigateToSearchActivity(MainActivity activity){
        Intent intent = new Intent(activity, SearchActivity.class);
        Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(activity, android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
        activity.startActivityForResult(intent, 123, bundle);
    }

    /**********************************************************************************************/
    /**
     * Fragment Management
     */

    /**
     * Put Fragment
     */
    private void setFragment(Fragment fragment, String tag){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        //fragmentTransaction.add(R.id.content, fragment, tag);
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Change Fragment
     */
    private void changeFragment(String fragmentId){
        Fragment fragment =  fragmentManager.findFragmentById(R.id.content);
        switch (fragmentId){
            case FRAGMENT_ID_FAVOURITE:
                changeToFavouriteFragment(fragment);
                break;
            case FRAGMENT_ID_SEARCH:
                changeToSearchFragment(fragment);
                break;
            case FRAGMENT_ID_USER:
                changeToUserFragment(fragment);
                break;
            case FRAGMENT_ID_MAP:
                changeToMapFragment(fragment);
                break;
        }
    }


    private void changeToFavouriteFragment(Fragment fragment){
        if (!(fragment instanceof FavouriteFragment)){
            fragment = createFavouriteFragment();
            setFragment(fragment, FRAGMENT_ID_FAVOURITE);
        }
    }
    private void changeToSearchFragment(Fragment fragment){
        if (!(fragment instanceof SearchFragment)){
            fragment = createSearchFragment();
            setFragment(fragment, FRAGMENT_ID_SEARCH);
        }
    }
    private void changeToUserFragment(Fragment fragment){
        if (!(fragment instanceof UserFragment)){
            fragment = createUserFragment();
            setFragment(fragment, FRAGMENT_ID_USER);
        }
    }

    private void changeToMapFragment(Fragment fragment){
        if (!(fragment instanceof MapFragment)){
            fragment = createMapFragment();
            setFragment(fragment, FRAGMENT_ID_MAP);
        }
    }

    /**
     * Create Fragment
     */
    private FavouriteFragment createFavouriteFragment(){
        FavouriteFragment fragment = new FavouriteFragment();
        return fragment;
    }
    private SearchFragment createSearchFragment(){
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }
    private UserFragment createUserFragment(){
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    private MapFragment createMapFragment(){
        MapFragment fragment = new MapFragment();
        return fragment;
    }

}
