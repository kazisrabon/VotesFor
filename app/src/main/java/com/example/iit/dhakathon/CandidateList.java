package com.example.iit.dhakathon;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import java.util.ArrayList;
import java.util.List;


public class CandidateList extends ActionBarActivity implements View.OnClickListener {
    Spinner spCityCorporation, spCandidateType;

    int spCCTypeSelected = 0;
    int spCouncilorTypeSelected = 0;
    Button bSearch;
    private Drawer.Result result;
    private AccountHeader.Result headerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_list);

        init();

       initDrawer();
    }

    private void init() {
        spCandidateType = (Spinner) findViewById(R.id.spCityCorporationType);
        spCityCorporation = (Spinner) findViewById(R.id.spCityCorporationName);
        setSpinnerAdapter();
        setSpinnerListener();
        bSearch = (Button) findViewById(R.id.bSearch);
        bSearch.setOnClickListener(this);
    }

    private void setSpinnerListener() {
        spCityCorporation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spCCTypeSelected = i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spCCTypeSelected = 0;
            }
        });

        spCandidateType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spCouncilorTypeSelected = i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spCouncilorTypeSelected = 0;
            }
        });
    }

    private void setSpinnerAdapter() {
        List<String> listOfRMO = new ArrayList<String>();


        listOfRMO.add("Dhaka North City Corporation");
        listOfRMO.add("Dhaka South City Corporation");
        listOfRMO.add("Chittagong City Corporation");
        ArrayAdapter<String> dataAdapterOfRMO = new ArrayAdapter<String>(this,
                R.layout.custom_simple_spinner, listOfRMO);
        dataAdapterOfRMO.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCityCorporation.setAdapter(dataAdapterOfRMO);

        List<String> listOfRMO2 = new ArrayList<String>();

        listOfRMO2.add("Mayor");
        listOfRMO2.add("Councilor");
        listOfRMO2.add("Reserved Councilor");
        ArrayAdapter<String> dataAdapterOfRMO2 = new ArrayAdapter<String>(this,
                R.layout.custom_simple_spinner, listOfRMO2);
        dataAdapterOfRMO2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCandidateType.setAdapter(dataAdapterOfRMO2);

    }

    private void initDrawer() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        headerResult = new AccountHeader()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Test").withEmail("test@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        // Handle Toolbar
        result = new Drawer()
                .withActivity(this)
                .withHeader(R.layout.header)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_candidates).withIcon(FontAwesome.Icon.faw_male).withIdentifier(0),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_polling_stations).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_map).withIcon(FontAwesome.Icon.faw_globe).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_section_nearest).withIcon(FontAwesome.Icon.faw_map_marker).withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_share).withIcon(FontAwesome.Icon.faw_share_alt).withIdentifier(4),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_info).withIcon(FontAwesome.Icon.faw_info_circle).withIdentifier(5)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem instanceof Nameable) {

                            Fragment fragment = null;
                            if (drawerItem.getIdentifier() == 0) {
                                //startActivity(new Intent(CandidateList.this, CandidateList.class));
                            } else if (drawerItem.getIdentifier() == 1) {
                                startActivity(new Intent(CandidateList.this, PollingStationActivity.class));
                            } else if (drawerItem.getIdentifier() == 2) {
                                startActivity(new Intent(CandidateList.this, Map.class));
                            } else if (drawerItem.getIdentifier() == 3) {
                                startActivity(new Intent(CandidateList.this, NearestVenue.class));
                            } else if (drawerItem.getIdentifier() == 4) {
                                startActivity(new Intent(CandidateList.this, ShareActivity.class));
                            } else if (drawerItem.getIdentifier() == 5) {
                                fragment = new Info1();
                            }
                            if (fragment != null) {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.fragment_container, fragment)
                                        .commit();
                            }
                        }
                    }
                })


                .withSelectedItem(0)
                .build();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(false);
//        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }

    @Override
    public void onClick(View view) {
        if (view == bSearch) {
            Intent intent=new Intent(CandidateList.this,ListViewOfCandidates.class);
            intent.putExtra("url",URL.URL[spCCTypeSelected][spCouncilorTypeSelected]);
            startActivity(intent);
        }
    }
}
