package com.example.iit.dhakathon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by IIT on 4/17/2015.
 */
public class MapActivity extends ActionBarActivity {

    // Google Map
    private GoogleMap googleMap;
    private double latitude;
    private double longitude;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        try {
            // Loading map
            initilizeMap();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
                    R.id.map)).getMap();
            googleMap.setBuildingsEnabled(true);
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
            if (googleMap != null) {
                setUpMap();
            }
        }else {
            setUpMap();
        }
    }

    private void setUpMap() {
        LocationService locationService = new LocationService(this);
        Location nwLocation = locationService.getLocation(LocationManager.NETWORK_PROVIDER);

        if (nwLocation != null) {
            latitude = nwLocation.getLatitude();
            longitude = nwLocation.getLongitude();

        } else {
            showSettingsAlert("NETWORK");
            //Toast.makeText(getApplicationContext(), "Network Provider not enabled.", Toast.LENGTH_LONG).show();
        }

        googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
                R.id.map)).getMap();

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)) // Sets the center of the map to
                .zoom(18)                   // Sets the zoom
                .bearing(0) // Sets the orientation of the camera to east
                .tilt(90)    // Sets the tilt of the camera to 30 degrees
                .build();    // Creates a CameraPosition from the builder
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Showing Current Location
//        mMap.setMyLocationEnabled(true); // false to disable

        //Zooming Buttons
//        mMap.getUiSettings().setZoomControlsEnabled(true); // true to enable

        //Zooming Functionality
        googleMap.getUiSettings().setZoomGesturesEnabled(true);

        //Compass Functionality
//        mMap.getUiSettings().setCompassEnabled(true);

        //My Location Button
//        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        //Map Rotate Gesture
        googleMap.getUiSettings().setRotateGesturesEnabled(true);

        //Map toolbar
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.setLocationSource(new CurrentLocationProvider(this));
        Log.e("Map", "Started map3");
        googleMap.addMarker(new MarkerOptions().position(new LatLng(23.8153059, 90.41311)).title("Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        //            final List<Beep> results = mBeepTable.execute().get();
        Log.e("Map", "Started map4");
    }

    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

    public void showSettingsAlert(String provider) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getApplicationContext());

        alertDialog.setTitle(provider + " SETTINGS");

        alertDialog
                .setMessage(provider + " is not enabled! Want to go to settings menu?");

        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        getApplicationContext().startActivity(intent);
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }
}
