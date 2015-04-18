package com.example.iit.dhakathon;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class PollingStationActivity extends ActionBarActivity {
    ListView lv;
    String [] data=new String[]{"A","B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling_station);
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


}
