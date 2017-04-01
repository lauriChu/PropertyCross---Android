package com.lasalle.mdpa.lgarci.propertycross.activity.init;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.lasalle.mdpa.lgarci.propertycross.R;

public class InitActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // TODO: Dialogo fallo en connexión ubicación
    }

    @Override
    protected void onStart() {
        //initActivityManager.doGoogleConnect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        //initActivityManager.doGoogleDisconnect();
        super.onStop();
    }
}
