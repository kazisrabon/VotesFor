package com.example.iit.dhakathon;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;


public class MainActivity extends ActionBarActivity {

    private Drawer.Result result;
    private AccountHeader.Result headerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDrawer(savedInstanceState);
        sendNotification("9 days remaining,Dhaka City Corporation Election", R.mipmap.ic_launcher);
    }

    private void initDrawer(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                .withToolbar(toolbar)
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
                            getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
//                            Fragment fragment = null;
                            if (drawerItem.getIdentifier() == 0) {
                                startActivity(new Intent(MainActivity.this,CandidateList.class));
                            } else if (drawerItem.getIdentifier() == 1) {
                                startActivity(new Intent(MainActivity.this, PollingStationActivity.class));
                            } else if (drawerItem.getIdentifier() == 2) {
                                startActivity(new Intent(MainActivity.this, Map.class));
                            } else if (drawerItem.getIdentifier() == 3) {
                                startActivity(new Intent(MainActivity.this, NearestVenue.class));
                            } else if (drawerItem.getIdentifier() == 4) {
                                startActivity(new Intent(MainActivity.this, ShareActivity.class));
                            } else if (drawerItem.getIdentifier() == 5) {
                                startActivity(new Intent(MainActivity.this, Info1.class));
                            }
                        }
                    }
                })
                .withFireOnInitialOnClick(true)
                .withSelectedItem(0)
                .build();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(false);
//        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }

    private void sendNotification(String alert, int icon) {
        Intent intent = new Intent(this, PushResultActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setAutoCancel(true);
        builder.setContentTitle("VotesFor");
        builder.setContentText(alert);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.addAction(icon, "Click to see!!!", pIntent);
        builder.setVibrate(new long[(int) 1]);
        builder.setAutoCancel(true);

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(8, notification);
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
