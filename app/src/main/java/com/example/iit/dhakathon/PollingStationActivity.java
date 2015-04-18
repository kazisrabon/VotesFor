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
import android.widget.ListView;
import android.widget.Toast;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;


public class PollingStationActivity extends ActionBarActivity {
    ListView lv;
    String [] data=new String[]{"A","B"};
    private Drawer.Result result;
    private AccountHeader.Result headerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling_station);
        initDrawer();
        lv= (ListView) findViewById(R.id.lv);

        ArrayAdapter adapter = new ArrayAdapter<String>(PollingStationActivity.this,R.layout.activity_listview, Data.getLocation());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(PollingStationActivity.this,PollMap.class);
                intent.putExtra("lat",Data.latitudelist.get(i));
                intent.putExtra("lon",Data.longitudelist.get(i));
                intent.putExtra("name", Data.locationName.get(i));
                startActivity(intent);
                Toast.makeText(PollingStationActivity.this, Data.locationName.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDrawer() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MAP view");
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
                                startActivity(new Intent(PollingStationActivity.this, MainActivity.class));
                            } else if (drawerItem.getIdentifier() == 1) {
                                //startActivity(new Intent(PollingStationActivity.this, PollingStationActivity.class));
                            } else if (drawerItem.getIdentifier() == 2) {
                                startActivity(new Intent(PollingStationActivity.this, Map.class));
                            } else if (drawerItem.getIdentifier() == 3) {
                                startActivity(new Intent(PollingStationActivity.this, NearestVenue.class));
                            } else if (drawerItem.getIdentifier() == 4) {
                                startActivity(new Intent(PollingStationActivity.this, ShareActivity.class));
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


                .withSelectedItem(1)
                .build();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(false);
//        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }
}
