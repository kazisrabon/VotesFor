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

import java.util.ArrayList;


public class ListViewOfCandidates extends ActionBarActivity implements AsyncResponce{
    String url;
    ListView lv;
    private Drawer.Result result;
    private AccountHeader.Result headerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_of_candidates);
        init();
//        initDrawer(savedInstanceState);

        JsonParse jsonParse=new JsonParse(ListViewOfCandidates.this,this,url);
        jsonParse.execute();
    }

    private void init() {
        url=getIntent().getStringExtra("url");
        lv= (ListView) findViewById(R.id.lv);
    }

    @Override
    public void processFinish(final ArrayList<CandidateDataObject> listOfCandidateDataObjects) {
        String[] data=new String[listOfCandidateDataObjects.size()];
        for(int i=0; i<listOfCandidateDataObjects.size();i++){
            data[i]=listOfCandidateDataObjects.get(i).getName();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(ListViewOfCandidates.this,R.layout.activity_listview, data);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(ListViewOfCandidates.this,ProfileActivity.class);
                intent.putExtra("name",listOfCandidateDataObjects.get(i).getName());
                intent.putExtra("location",listOfCandidateDataObjects.get(i).getPresent_address());
                intent.putExtra("url", listOfCandidateDataObjects.get(i).getImage_link());
                startActivity(intent);
                Toast.makeText(ListViewOfCandidates.this,listOfCandidateDataObjects.get(i).getPresent_address(),Toast.LENGTH_SHORT).show();
            }
        });

        //listViewGeneration(data);

    }

    private void listViewGeneration(String[] data) {

    }

}
