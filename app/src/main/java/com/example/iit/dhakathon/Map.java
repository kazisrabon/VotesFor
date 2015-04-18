package com.example.iit.dhakathon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
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

/**
 * Created by IIT on 4/17/2015.
 */
public class Map extends ActionBarActivity {

    // Google Map
    private GoogleMap googleMap;
    private double latitude;
    private double longitude;
    public static List<Double> latitudelist = new ArrayList<Double>();
    public static List<Double> longitudelist = new ArrayList<Double>();
    public static List<String> locationName = new ArrayList<String>();
    private String name;
    private Drawer.Result result;
    private AccountHeader.Result headerResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        init();
        initDrawer();

        try {
            // Loading map_ratting
            initilizeMap();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        locationName.add("Scholastica School ");
        latitudelist.add(new Double(23.858419));
        longitudelist.add(new Double(90.405663));
        locationName.add("Armed Police Battalion School ");
        latitudelist.add(new Double(23.858587));
        longitudelist.add(new Double(90.405663));
        locationName.add("Uttara High School and College ");
        latitudelist.add(new Double(23.871218));
        longitudelist.add(new Double(90.397972));
        locationName.add("IES School and College ");
        latitudelist.add(new Double(23.86245));
        longitudelist.add(new Double(90.390289));
        locationName.add("Uttara Girls High School and College ");
        latitudelist.add(new Double(23.87326));
        longitudelist.add(new Double(90.403992));
        locationName.add("Milestone School and College ");
        latitudelist.add(new Double(23.878138));
        longitudelist.add(new Double(90.390709));
        locationName.add("Maleka Banu Ideal Bidya Niketon ");
        latitudelist.add(new Double(23.878374));
        longitudelist.add(new Double(90.401588));
        locationName.add("Khalilur Rahman Govt. Model High School ");
        latitudelist.add(new Double(23.83374));
        longitudelist.add(new Double(90.37046));
        locationName.add("Rashid Ideal High School ");
        latitudelist.add(new Double(23.82542));
        longitudelist.add(new Double(90.37302));
        locationName.add("Shaheed Zia Girls Laboratory Institute ");
        latitudelist.add(new Double(23.82656));
        longitudelist.add(new Double(90.37267));
        locationName.add("Non-Local Free School ");
        latitudelist.add(new Double(23.82659));
        longitudelist.add(new Double(90.37234));
        locationName.add("Bangabandhu College, Shaheedbagh ");
        latitudelist.add(new Double(23.83003));
        longitudelist.add(new Double(90.37527));
        locationName.add("Bangladesh Ideal Shikkha Niketon Primary School ");
        latitudelist.add(new Double(23.82831));
        longitudelist.add(new Double(90.36973));
        locationName.add("Nahar Academy High School ");
        latitudelist.add(new Double(23.82642));
        longitudelist.add(new Double(90.36462));
        locationName.add("MDC Model Institute ");
        latitudelist.add(new Double(23.8241));
        longitudelist.add(new Double(90.36601));
        locationName.add("Dr. Muhammmad Shahidullah Ideal High School ");
        latitudelist.add(new Double(23.82615));
        longitudelist.add(new Double(90.36595));
        locationName.add("MDC Model Institute ");
        latitudelist.add(new Double(23.8241));
        longitudelist.add(new Double(90.36601));
        locationName.add("Shaheed Zia Women College ");
        latitudelist.add(new Double(23.82322));
        longitudelist.add(new Double(90.37272));
        locationName.add("Sultan Molla Ideal High School ");
        latitudelist.add(new Double(23.824));
        longitudelist.add(new Double(90.37008));
        locationName.add("Shaheed Abu Taleb high School ");
        latitudelist.add(new Double(23.80968));
        longitudelist.add(new Double(90.36931));
        locationName.add("Alhaj Modhu Bepari High School ");
        latitudelist.add(new Double(23.81179));
        longitudelist.add(new Double(90.36825));
        locationName.add("Senapara Porbota Govt. Primary  School ");
        latitudelist.add(new Double(23.80769));
        longitudelist.add(new Double(90.37026));
        locationName.add("Mirpur Girls Ideal Laboratory Institute ");
        latitudelist.add(new Double(23.80728));
        longitudelist.add(new Double(90.37102));
        locationName.add("Mirpur Udayan School ");
        latitudelist.add(new Double(23.81352));
        longitudelist.add(new Double(90.3737));
        locationName.add("Pragoti High School ");
        latitudelist.add(new Double(23.81804));
        longitudelist.add(new Double(90.37447));
        locationName.add("Mirpur Shaheen School ");
        latitudelist.add(new Double(23.81593));
        longitudelist.add(new Double(90.37422));
        locationName.add("Alhaj Abbas Uddin High School ");
        latitudelist.add(new Double(23.81344));
        longitudelist.add(new Double(90.37637));
        locationName.add("Madrasa Wajia Arabia Hafijia ");
        latitudelist.add(new Double(23.81589));
        longitudelist.add(new Double(90.37644));
        locationName.add("Haji Ali Hossain High School ");
        latitudelist.add(new Double(23.807249));
        longitudelist.add(new Double(90.379295));
        locationName.add("SOS Herman Meinar College ");
        latitudelist.add(new Double(23.805027));
        longitudelist.add(new Double(90.376877));
        locationName.add("Govt. Unani and Ayurbedik Degree College ");
        latitudelist.add(new Double(23.804159));
        longitudelist.add(new Double(90.377632));
        locationName.add("National Special Education Centre ");
        latitudelist.add(new Double(23.802929));
        longitudelist.add(new Double(90.387749));
        locationName.add("Rotary School and College ");
        latitudelist.add(new Double(23.800854));
        longitudelist.add(new Double(90.381256));
        locationName.add("Shaheen Memorial High School And College ");
        latitudelist.add(new Double(23.800022));
        longitudelist.add(new Double(90.384895));
        locationName.add("Shere-E-Bangla Govt. Primary School ");
        latitudelist.add(new Double(23.806929));
        longitudelist.add(new Double(90.380775));
        locationName.add("Al Jahara Girls Madrasa Academy ");
        latitudelist.add(new Double(23.811447));
        longitudelist.add(new Double(90.380058));
        locationName.add("Mirpur Bangla School and College(Boys) ");
        latitudelist.add(new Double(23.81459));
        longitudelist.add(new Double(90.36742));
        locationName.add("Abdul Manna Govt. Primary School ");
        latitudelist.add(new Double(23.81908));
        longitudelist.add(new Double(90.37127));
        locationName.add("Jannat Academy High School ");
        latitudelist.add(new Double(23.81548));
        longitudelist.add(new Double(90.367));
        locationName.add("Pre-cadet Child Care Homes ");
        latitudelist.add(new Double(23.81826));
        longitudelist.add(new Double(90.36623));
        locationName.add("Kalshee Islamia High School ");
        latitudelist.add(new Double(23.22113));
        longitudelist.add(new Double(90.37675));
        locationName.add("Ananda Niketon Primary School ");
        latitudelist.add(new Double(23.822111));
        longitudelist.add(new Double(90.379921));
        locationName.add("Urban School ");
        latitudelist.add(new Double(23.822201));
        longitudelist.add(new Double(90.379021));
        locationName.add("Journalist Resident Area School ");
        latitudelist.add(new Double(23.820738));
        longitudelist.add(new Double(90.373695));
        locationName.add("Darul Ulum Mohiusunnah Madrasa and Rahmania Orphanagae ");
        latitudelist.add(new Double(23.814299));
        longitudelist.add(new Double(90.380547));
        locationName.add("Palash Nagar Model School ");
        latitudelist.add(new Double(23.816483));
        longitudelist.add(new Double(90.377472));
        locationName.add("Bauniabadh A Block Primary School ");
        latitudelist.add(new Double(23.819361));
        longitudelist.add(new Double(90.381935));
        locationName.add("Ananda Niketon Primary School ");
        latitudelist.add(new Double(23.819901));
        longitudelist.add(new Double(90.379272));
        locationName.add("Bauniabadh E Block Primary School ");
        latitudelist.add(new Double(23.819361));
        longitudelist.add(new Double(90.381935));
        locationName.add("Bauniabadh E Block Primary School ");
        latitudelist.add(new Double(23.817781));
        longitudelist.add(new Double(90.380692));
        locationName.add("Bauniabadh Ideal High School ");
        latitudelist.add(new Double(23.818615));
        longitudelist.add(new Double(90.380363));
        locationName.add("Ahasina Mission College ");
        latitudelist.add(new Double(23.822401));
        longitudelist.add(new Double(90.354309));
        locationName.add("Rupnagar ideal High School ");
        latitudelist.add(new Double(23.822113));
        longitudelist.add(new Double(90.356873));
        locationName.add("Rupnagar ideal High School ");
        latitudelist.add(new Double(23.822113));
        longitudelist.add(new Double(90.356873));
        locationName.add("Mirpur Bangla School and College(Girls) ");
        latitudelist.add(new Double(23.81428));
        longitudelist.add(new Double(90.364098));
        locationName.add("Mirpur Ideal Bidya Niketon ");
        latitudelist.add(new Double(23.811541));
        longitudelist.add(new Double(90.364227));
        locationName.add("Mirpur Shaheed Memorial High School ");
        latitudelist.add(new Double(23.815685));
        longitudelist.add(new Double(90.365761));
        locationName.add("Mirpur Ideal Bidya Niketon ");
        latitudelist.add(new Double(23.811541));
        longitudelist.add(new Double(90.364227));
        locationName.add("Islamia High School ");
        latitudelist.add(new Double(23.812908));
        longitudelist.add(new Double(90.359802));
        locationName.add("Mirpur Bangla School and College(Girls) ");
        latitudelist.add(new Double(23.81428));
        longitudelist.add(new Double(90.364098));
        locationName.add("Sheikh Kamal Primary School ");
        latitudelist.add(new Double(23.818598));
        longitudelist.add(new Double(90.363251));
        locationName.add("Bangabandhu Bidyaniketon ");
        latitudelist.add(new Double(23.81645));
        longitudelist.add(new Double(90.361954));
        locationName.add("Dhaka Cadet Madrasa ");
        latitudelist.add(new Double(23.819794));
        longitudelist.add(new Double(90.357658));
        locationName.add("Saotul Quran Madrasa ");
        latitudelist.add(new Double(23.81765));
        longitudelist.add(new Double(90.359024));
        locationName.add("Digun Govt. Primary  School ");
        latitudelist.add(new Double(23.834703));
        longitudelist.add(new Double(90.356522));
        locationName.add("Madrasa-E Madinatul Ulum and Orphanage ");
        latitudelist.add(new Double(23.826639));
        longitudelist.add(new Double(90.355324));
        locationName.add("Pallbi Degree College ");
        latitudelist.add(new Double(23.827295));
        longitudelist.add(new Double(90.357605));
        locationName.add("Pallabi Majedul Islam Model High School ");
        latitudelist.add(new Double(23.825726));
        longitudelist.add(new Double(90.361374));
        locationName.add("Pallabi Aftab Uddin Madrasa ");
        latitudelist.add(new Double(23.822248));
        longitudelist.add(new Double(90.3591));
        locationName.add("Pallabi Govt. Primary School ");
        latitudelist.add(new Double(23.825315));
        longitudelist.add(new Double(90.361855));
        locationName.add("Dhaka Commerce College ");
        latitudelist.add(new Double(23.806438));
        longitudelist.add(new Double(90.352783));
        locationName.add("Islamia Ideal High School ");
        latitudelist.add(new Double(23.804916));
        longitudelist.add(new Double(90.355995));
        locationName.add("Sheikh Fajilatunnesa Islamia Women Degree College ");
        latitudelist.add(new Double(23.804401));
        longitudelist.add(new Double(90.359924));
        locationName.add("Mirpur University College ");
        latitudelist.add(new Double(23.803999));
        longitudelist.add(new Double(90.361351));
        locationName.add("National Govt. Primary School ");
        latitudelist.add(new Double(23.805107));
        longitudelist.add(new Double(90.361015));
        locationName.add("National Bangla High School ");
        latitudelist.add(new Double(23.804955));
        longitudelist.add(new Double(90.362915));
        locationName.add("Rupnagar Model High School and College ");
        latitudelist.add(new Double(23.81489));
        longitudelist.add(new Double(90.354591));
        locationName.add("Kamal Ahmed Majumdar School and College ");
        latitudelist.add(new Double(23.817043));
        longitudelist.add(new Double(90.355553));
        locationName.add("Monipur High School ");
        latitudelist.add(new Double(23.812902));
        longitudelist.add(new Double(90.355247));
        locationName.add("Usha Bidya Niketon Primary School ");
        latitudelist.add(new Double(23.808722));
        longitudelist.add(new Double(90.356453));
        locationName.add("Monipur High School ");
        latitudelist.add(new Double(23.812902));
        longitudelist.add(new Double(90.355247));
        locationName.add("Baitul  Mosharaf Senior Madrasa ");
        latitudelist.add(new Double(23.809047));
        longitudelist.add(new Double(90.363838));
        locationName.add("Baitul  Mosharaf Senior Madrasa ");
        latitudelist.add(new Double(23.809047));
        longitudelist.add(new Double(90.363838));
        locationName.add("Mirpur Govt. High School ");
        latitudelist.add(new Double(23.79878));
        longitudelist.add(new Double(90.351501));
        locationName.add("Kazipara Govt. Primary School ");
        latitudelist.add(new Double(23.804094));
        longitudelist.add(new Double(90.34626));
        locationName.add("Samata Model High School ");
        latitudelist.add(new Double(23.806116));
        longitudelist.add(new Double(90.349724));
        locationName.add("Kazipara Govt. Primary School ");
        latitudelist.add(new Double(23.804094));
        longitudelist.add(new Double(90.34626));
        locationName.add("Dargaon Govt. Primary School ");
        latitudelist.add(new Double(23.798454));
        longitudelist.add(new Double(90.349274));
        locationName.add("Hazrat Shah Ali Girls High School ");
        latitudelist.add(new Double(23.79841));
        longitudelist.add(new Double(90.350174));
        locationName.add("Nababer Bagh Govt. Primary School ");
        latitudelist.add(new Double(23.80949));
        longitudelist.add(new Double(90.341415));
        locationName.add("Hazrat Shah Ali Girls High School and College ");
        latitudelist.add(new Double(23.796843));
        longitudelist.add(new Double(90.349976));
        locationName.add("Majidul Akbar Complex Hafijia Madrasa ");
        latitudelist.add(new Double(23.801981));
        longitudelist.add(new Double(90.350563));
        locationName.add("Monikanon High School ");
        latitudelist.add(new Double(23.801138));
        longitudelist.add(new Double(90.353661));
        locationName.add("Sub-Town Govt. Primary School ");
        latitudelist.add(new Double(23.799765));
        longitudelist.add(new Double(90.353058));
        locationName.add("Zoo Botanical High School ");
        latitudelist.add(new Double(23.814724));
        longitudelist.add(new Double(90.349075));
        locationName.add("Mirpur Siddhanta High School ");
        latitudelist.add(new Double(23.791746));
        longitudelist.add(new Double(90.342554));
        locationName.add("Jamia Hosainia Azarabad Madrasa ");
        latitudelist.add(new Double(23.790821));
        longitudelist.add(new Double(90.342323));
        locationName.add("Jahanabad Govt. Primary School ");
        latitudelist.add(new Double(23.792604));
        longitudelist.add(new Double(90.342255));
        locationName.add("Mirpur Laboratory High School ");
        latitudelist.add(new Double(23.786074));
        longitudelist.add(new Double(90.339935));
        locationName.add("Panjjeri High School ");
        latitudelist.add(new Double(23.785088));
        longitudelist.add(new Double(90.340668));
        locationName.add("Doel Kinder Garten ");
        latitudelist.add(new Double(23.794893));
        longitudelist.add(new Double(90.341774));
        locationName.add("Shaheed Abdul Mannan Khan Model School ");
        latitudelist.add(new Double(23.792789));
        longitudelist.add(new Double(90.341026));
        locationName.add("Fulkurhi Kinder Garten ");
        latitudelist.add(new Double(23.785088));
        longitudelist.add(new Double(90.340668));
        locationName.add("Baganbari Govt. Primary School ");
        latitudelist.add(new Double(23.785151));
        longitudelist.add(new Double(90.341125));
        locationName.add("Asma Bidya Niketon ");
        latitudelist.add(new Double(23.789524));
        longitudelist.add(new Double(90.342072));
        locationName.add("Juvenile Care School ");
        latitudelist.add(new Double(23.786463));
        longitudelist.add(new Double(90.346268));
        locationName.add("Soptorshi Kinder Garten ");
        latitudelist.add(new Double(23.784046));
        longitudelist.add(new Double(90.347305));
        locationName.add("Gabtali Govt. Primary School ");
        latitudelist.add(new Double(23.783051));
        longitudelist.add(new Double(90.348396));
        locationName.add("Bangladesh Korea Technical Training Centre ");
        latitudelist.add(new Double(23.781269));
        longitudelist.add(new Double(90.352165));
        locationName.add("New Bud Ideal Bidya Niketon ");
        latitudelist.add(new Double(23.788872));
        longitudelist.add(new Double(90.348244));
        locationName.add("Kabi Nazrul Academy ");
        latitudelist.add(new Double(23.790051));
        longitudelist.add(new Double(90.348389));
        locationName.add("Hazrat Shah Ali Model School And College ");
        latitudelist.add(new Double(23.786718));
        longitudelist.add(new Double(90.347343));
        locationName.add("Darus salam Govt. Primary School ");
        latitudelist.add(new Double(23.78002));
        longitudelist.add(new Double(90.353828));
        locationName.add("FM international School and College ");
        latitudelist.add(new Double(23.796453));
        longitudelist.add(new Double(90.347832));
        locationName.add("RC Govt. Primary School ");
        latitudelist.add(new Double(23.78314));
        longitudelist.add(new Double(90.347969));
        locationName.add("Kalyanpur Girls  School And College ");
        latitudelist.add(new Double(23.782715));
        longitudelist.add(new Double(90.359833));
        locationName.add("kalyanpur Model Govt. Primary School ");
        latitudelist.add(new Double(23.981412));
        longitudelist.add(new Double(90.363213));
        locationName.add("Riaz Uddin High School ");
        latitudelist.add(new Double(23.787521));
        longitudelist.add(new Double(90.360107));
        locationName.add("Khan International School ");
        latitudelist.add(new Double(23.783875));
        longitudelist.add(new Double(90.361183));
        locationName.add("Model Academy Paikpara ");
        latitudelist.add(new Double(23.785046));
        longitudelist.add(new Double(90.354767));
        locationName.add("Haqqani Mission Bidyapith and Moha Bidyaloy ");
        latitudelist.add(new Double(23.787392));
        longitudelist.add(new Double(90.361084));
        locationName.add("Shaheed Memorial Govt. Primary School ");
        latitudelist.add(new Double(23.787758));
        longitudelist.add(new Double(90.354691));
        locationName.add("Mohammadia Islamia Alim Madrasa ");
        latitudelist.add(new Double(23.789703));
        longitudelist.add(new Double(90.359779));
        locationName.add("Model Academy Paikpara ");
        latitudelist.add(new Double(23.785046));
        longitudelist.add(new Double(90.354767));
        locationName.add("Cosmic Kinder Garten ");
        latitudelist.add(new Double(23.790817));
        longitudelist.add(new Double(90.358635));
        locationName.add("Khan International School ");
        latitudelist.add(new Double(23.783875));
        longitudelist.add(new Double(90.361183));
        locationName.add("Bashir Uddin Ideal School And College ");
        latitudelist.add(new Double(23.793522));
        longitudelist.add(new Double(90.358086));
        locationName.add("Paikpara Govt. Primary School ");
        latitudelist.add(new Double(23.79385));
        longitudelist.add(new Double(90.358495));
        locationName.add("Morning Advance School ");
        latitudelist.add(new Double(23.790817));
        longitudelist.add(new Double(90.358635));
        locationName.add("Dhaka Ahsania Mission girls High School ");
        latitudelist.add(new Double(23.795864));
        longitudelist.add(new Double(90.354614));
        locationName.add("Dhaka Laboratory Institute ");
        latitudelist.add(new Double(23.795208));
        longitudelist.add(new Double(90.358231));
        locationName.add("Combined International School ");
        latitudelist.add(new Double(23.793051));
        longitudelist.add(new Double(90.354286));
        locationName.add("Education Board Laboratory High School And College ");
        latitudelist.add(new Double(23.793463));
        longitudelist.add(new Double(90.353661));
        locationName.add("Shapla Bidya niketon ");
        latitudelist.add(new Double(23.79911));
        longitudelist.add(new Double(90.356232));
        locationName.add("UCEP Ismail School ");
        latitudelist.add(new Double(23.796389));
        longitudelist.add(new Double(90.357689));
        locationName.add("Paikpara Stuff Quarter High School ");
        latitudelist.add(new Double(23.793983));
        longitudelist.add(new Double(90.354622));
        locationName.add("BADC High School ");
        latitudelist.add(new Double(23.786608));
        longitudelist.add(new Double(90.353874));
        locationName.add("Wakeup Govt. Primary School ");
        latitudelist.add(new Double(23.790096));
        longitudelist.add(new Double(90.352997));
        locationName.add("Monipur High School(Boys) ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("Pirerbagh Govt. Primary School ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373862));
        locationName.add("Alim Uddin High School ");
        latitudelist.add(new Double(23.788305));
        longitudelist.add(new Double(90.367706));
        locationName.add("New Model International School ");
        latitudelist.add(new Double(23.792408));
        longitudelist.add(new Double(90.367409));
        locationName.add("Dhaka Edward School and College ");
        latitudelist.add(new Double(23.786774));
        longitudelist.add(new Double(90.368271));
        locationName.add("Monipur Govt. Primary School ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("Monipur High School(Girls) ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("Cosmopolitan Laboratory Institute ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("Monipur Cadet School and College ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("Scholar Kinder Garden ");
        latitudelist.add(new Double(23.792034));
        longitudelist.add(new Double(90.373862));
        locationName.add("Island Pre-cadet School ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("North South International School ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("Holy Crescent School and School ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.373878));
        locationName.add("Mamtaj uddin Memorial Ideal School ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373862));
        locationName.add("Haji Ashraf Ali High School ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("East West International School and College ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.373878));
        locationName.add("Ibrahimpur Salauddin Shikkhyaloy ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.373878));
        locationName.add("Haji Ashraf Ali High School ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("Kazipara Haji Yusuf Ali Govt. Primary School ");
        latitudelist.add(new Double(23.797407));
        longitudelist.add(new Double(90.374161));
        locationName.add("Monipur High School Branch-3 ");
        latitudelist.add(new Double(23.79203));
        longitudelist.add(new Double(90.373863));
        locationName.add("Kazipara Siddiqia Senior Madrasa ");
        latitudelist.add(new Double(23.797068));
        longitudelist.add(new Double(90.373009));
        locationName.add("Soroj International School and College ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.373878));
        locationName.add("Mirpur Ideal High School ");
        latitudelist.add(new Double(23.791966));
        longitudelist.add(new Double(90.373882));
        locationName.add("Balughat High School ");
        latitudelist.add(new Double(23.82983));
        longitudelist.add(new Double(90.391113));
        locationName.add("Dhamalkot Ideal High School ");
        latitudelist.add(new Double(23.805042));
        longitudelist.add(new Double(90.989428));
        locationName.add("Homiopathic Govt. Degree College ");
        latitudelist.add(new Double(23.803106));
        longitudelist.add(new Double(90.388031));
        locationName.add("Manikdi Ideal Institute ");
        latitudelist.add(new Double(23.824915));
        longitudelist.add(new Double(90.394104));
        locationName.add("Green Heaven International School ");
        latitudelist.add(new Double(23.826805));
        longitudelist.add(new Double(90.392769));
        locationName.add("Care Pre-cadet Institute ");
        latitudelist.add(new Double(23.823112));
        longitudelist.add(new Double(90.38636));
        locationName.add("Manikdi Islamia Senior Madrasa ");
        latitudelist.add(new Double(23.824207));
        longitudelist.add(new Double(90.393456));
        locationName.add("Child Welfare Govt. Primary School ");
        latitudelist.add(new Double(23.819906));
        longitudelist.add(new Double(90.396431));
        locationName.add("Blue Bard Academy ");
        latitudelist.add(new Double(23.81958));
        longitudelist.add(new Double(90.394859));
        locationName.add("Little Child Care School ");
        latitudelist.add(new Double(23.815313));
        longitudelist.add(new Double(90.387215));
        locationName.add("Bhasantek High School ");
        latitudelist.add(new Double(23.811298));
        longitudelist.add(new Double(90.39518));
        locationName.add("Bhasantek High School ");
        latitudelist.add(new Double(23.811298));
        longitudelist.add(new Double(90.39518));
        locationName.add("Bhasantek High School ");
        latitudelist.add(new Double(23.811298));
        longitudelist.add(new Double(90.39518));
        locationName.add("Bhasantek High School ");
        latitudelist.add(new Double(23.811298));
        longitudelist.add(new Double(90.39518));
        locationName.add("Freedom Fighter High School ");
        latitudelist.add(new Double(23.813375));
        longitudelist.add(new Double(90.390732));
        locationName.add("West Bhasantek Govt. Primary School ");
        latitudelist.add(new Double(23.813286));
        longitudelist.add(new Double(90.390694));
        locationName.add("Haji Shahabuddin Precadet Academy ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.373878));
        locationName.add("Ibrahimpur Govt. Primary School ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.373878));
        locationName.add("Monipur School and College, Branch-2 ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.373878));
        locationName.add("Cheri Grammar English Version School ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.373878));
        locationName.add("Fulkurhi English Version School ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.373878));
        locationName.add("GildBud kinder Garden ");
        latitudelist.add(new Double(23.792593));
        longitudelist.add(new Double(90.383827));
        locationName.add("Fantasy Ready For School ");
        latitudelist.add(new Double(23.792372));
        longitudelist.add(new Double(90.383873));
        locationName.add("Bright Dawn Kinder Garden ");
        latitudelist.add(new Double(23.797359));
        longitudelist.add(new Double(90.381958));
        locationName.add("Dhiman Bidya Niketon ");
        latitudelist.add(new Double(23.791965));
        longitudelist.add(new Double(90.37378));
        locationName.add("Sunflower Public High School ");
        latitudelist.add(new Double(23.794678));
        longitudelist.add(new Double(90.380562));
        locationName.add("Adventist International Mission School ");
        latitudelist.add(new Double(23.793619));
        longitudelist.add(new Double(90.380463));
        locationName.add("North Kafrul High School ");
        latitudelist.add(new Double(23.791915));
        longitudelist.add(new Double(90.3733878));
        locationName.add("South Kafrul Model High School ");
        latitudelist.add(new Double(23.784758));
        longitudelist.add(new Double(90.383842));
        locationName.add("Saint Vincent Saint De Pauls Primary School ");
        latitudelist.add(new Double(23.786333));
        longitudelist.add(new Double(90.384621));
        locationName.add("Bijoy International Kinder Garden ");
        latitudelist.add(new Double(23.78866));
        longitudelist.add(new Double(90.387238));
        locationName.add("Halim Foundation School ");
        latitudelist.add(new Double(23.785145));
        longitudelist.add(new Double(90.375801));
        locationName.add("Ava Advance Education School ");
        latitudelist.add(new Double(23.784594));
        longitudelist.add(new Double(90.376549));
        locationName.add("Jani-e-Alam Govt. High School ");
        latitudelist.add(new Double(23.830702));
        longitudelist.add(new Double(90.401588));
        locationName.add("Nikunja Model College ");
        latitudelist.add(new Double(23.828196));
        longitudelist.add(new Double(90.418365));
        locationName.add("New Light High School and College ");
        latitudelist.add(new Double(23.814327));
        longitudelist.add(new Double(90.417603));
        locationName.add("Jasim Uddin Institute ");
        latitudelist.add(new Double(23.813976));
        longitudelist.add(new Double(90.416267));
        locationName.add("Gunshan Colleege ");
        latitudelist.add(new Double(23.814476));
        longitudelist.add(new Double(90.416267));
        locationName.add("Gulshan Degree College ");
        latitudelist.add(new Double(23.814655));
        longitudelist.add(new Double(90.416229));
        locationName.add("Kuril Kuratali Ideal High School ");
        latitudelist.add(new Double(23.820843));
        longitudelist.add(new Double(90.422707));
        locationName.add("Ideal Bidyapit ");
        latitudelist.add(new Double(23.816959));
        longitudelist.add(new Double(90.422813));
        locationName.add("Bidyasagar School & College ");
        latitudelist.add(new Double(23.81953));
        longitudelist.add(new Double(90.424377));
        locationName.add("Shere-- Bangla Ideal High School ");
        latitudelist.add(new Double(23.817358));
        longitudelist.add(new Double(90.421501));
        locationName.add("RS Ideal School ");
        latitudelist.add(new Double(23.818162));
        longitudelist.add(new Double(90.42379));
        locationName.add("Khilkhet Islamia Dakhil Madrasa ");
        latitudelist.add(new Double(23.834133));
        longitudelist.add(new Double(90.426201));
        locationName.add("Anwesha High School ");
        latitudelist.add(new Double(23.831585));
        longitudelist.add(new Double(90.427071));
        locationName.add("Kurmitola High School ");
        latitudelist.add(new Double(23.83024));
        longitudelist.add(new Double(90.422005));
        locationName.add("Kurmitola Govt. Primary School ");
        latitudelist.add(new Double(23.830246));
        longitudelist.add(new Double(90.422195));
        locationName.add("Kalachadpur High School ");
        latitudelist.add(new Double(23.809309));
        longitudelist.add(new Double(90.418251));
        locationName.add("House No-3, Road No-10, Baridhara, Gulshan, Dhaka ");
        latitudelist.add(new Double(23.806074));
        longitudelist.add(new Double(90.419312));
        locationName.add("Shahjadpur Najar Mahmud Alim Madrasa ");
        latitudelist.add(new Double(23.790754));
        longitudelist.add(new Double(90.426003));
        locationName.add("Shahjadpur Model Govt. Primary School ");
        latitudelist.add(new Double(23.79443));
        longitudelist.add(new Double(90.424141));
        locationName.add("Banani Model School ");
        latitudelist.add(new Double(23.788885));
        longitudelist.add(new Double(90.403069));
        locationName.add("Jamia Mohammadia Islamia Karail TNT Colony Madrasa ");
        latitudelist.add(new Double(23.785826));
        longitudelist.add(new Double(90.408554));
        locationName.add("Manarat Dhaka International College ");
        latitudelist.add(new Double(23.790783));
        longitudelist.add(new Double(90.420494));
        locationName.add("Gulshal Model School and College ");
        latitudelist.add(new Double(23.796894));
        longitudelist.add(new Double(90.415817));
        locationName.add("Banani Educational Institute ");
        latitudelist.add(new Double(23.795492));
        longitudelist.add(new Double(90.403831));
        locationName.add("TNT Ideal Girls High School ");
        latitudelist.add(new Double(23.78288));
        longitudelist.add(new Double(90.404488));
        locationName.add("Abdul Hamid Tailor Govt. Primary School ");
        latitudelist.add(new Double(23.780062));
        longitudelist.add(new Double(90.405571));
        locationName.add("Mohakhali Model High School ");
        latitudelist.add(new Double(23.780062));
        longitudelist.add(new Double(90.405571));
        locationName.add("TNT Women Degree College ");
        latitudelist.add(new Double(23.783279));
        longitudelist.add(new Double(90.403984));
        locationName.add("Govt. Titumir Degree College ");
        latitudelist.add(new Double(23.780825));
        longitudelist.add(new Double(90.404198));
        locationName.add("Institute of Health And Technology ");
        latitudelist.add(new Double(23.776606));
        longitudelist.add(new Double(90.402763));
        locationName.add("I.P.H School And College ");
        latitudelist.add(new Double(23.776405));
        longitudelist.add(new Double(90.403946));
        locationName.add("Amtali Stuff Welfare Govt. Primary School ");
        latitudelist.add(new Double(23.775631));
        longitudelist.add(new Double(90.399109));
        locationName.add("Niketon Housing Society Office ");
        latitudelist.add(new Double(23.725985));
        longitudelist.add(new Double(90.323006));
        locationName.add("North Badda Govt. Primary School ");
        latitudelist.add(new Double(23.78441));
        longitudelist.add(new Double(90.422585));
        locationName.add("Badda Girls High  School ");
        latitudelist.add(new Double(23.784328));
        longitudelist.add(new Double(90.422585));
        locationName.add("Badda Alatunnessa  Boys High  School ");
        latitudelist.add(new Double(23.776659));
        longitudelist.add(new Double(90.423004));
        locationName.add("Mohanagar University ");
        latitudelist.add(new Double(23.774824));
        longitudelist.add(new Double(90.427124));
        locationName.add("Badda High School ");
        latitudelist.add(new Double(23.779383));
        longitudelist.add(new Double(90.421883));
        locationName.add("Bhula Govt. Primary School ");
        latitudelist.add(new Double(23.776541));
        longitudelist.add(new Double(90.423843));
        locationName.add("Badda Govt. Primary School ");
        latitudelist.add(new Double(23.778797));
        longitudelist.add(new Double(90.425606));
        locationName.add("Rampura Ideal School ");
        latitudelist.add(new Double(23.764555));
        longitudelist.add(new Double(90.418037));
        locationName.add("Quality Learners High School ");
        latitudelist.add(new Double(23.764004));
        longitudelist.add(new Double(90.418114));
        locationName.add("Khaled Haider Memorial High School ");
        latitudelist.add(new Double(23.766594));
        longitudelist.add(new Double(90.41777));
        locationName.add("Laisiam Grammar School ");
        latitudelist.add(new Double(23.759499));
        longitudelist.add(new Double(90.417732));
        locationName.add("Sky Line School ");
        latitudelist.add(new Double(23.759699));
        longitudelist.add(new Double(90.416077));
        locationName.add("Ideal School and College ");
        latitudelist.add(new Double(23.762577));
        longitudelist.add(new Double(90.415894));
        locationName.add("Akramunnesa High School ");
        latitudelist.add(new Double(23.766022));
        longitudelist.add(new Double(90.421455));
        locationName.add("Al Furqan Eng. School ");
        latitudelist.add(new Double(23.764071));
        longitudelist.add(new Double(90.415431));
        locationName.add("World View Intl. School ");
        latitudelist.add(new Double(23.763189));
        longitudelist.add(new Double(90.415901));
        locationName.add("Motherland Grammar School ");
        latitudelist.add(new Double(23.763002));
        longitudelist.add(new Double(90.418556));
        locationName.add("Don view Grammar School ");
        latitudelist.add(new Double(23.761881));
        longitudelist.add(new Double(90.420181));
        locationName.add("Holy Crescent Intl. School ");
        latitudelist.add(new Double(23.763281));
        longitudelist.add(new Double(90.428238));
        locationName.add("Ideal School and College ");
        latitudelist.add(new Double(23.762857));
        longitudelist.add(new Double(90.431847));
        locationName.add("East Rampura High School ");
        latitudelist.add(new Double(23.760702));
        longitudelist.add(new Double(90.421768));
        locationName.add("Anowarul Uloom Madrasha ");
        latitudelist.add(new Double(23.760323));
        longitudelist.add(new Double(90.424706));
        locationName.add("Knowledge Syndicate KG School ");
        latitudelist.add(new Double(23.760485));
        longitudelist.add(new Double(90.419922));
        locationName.add("New Moel Intl. School ");
        latitudelist.add(new Double(23.759048));
        longitudelist.add(new Double(90.427422));
        locationName.add("Dhaka Intl.  School ");
        latitudelist.add(new Double(23.760883));
        longitudelist.add(new Double(90.423759));
        locationName.add("Malibag Chowdhurypara Govt. Primary School ");
        latitudelist.add(new Double(23.753338));
        longitudelist.add(new Double(90.419357));
        locationName.add("Fayzur Rahman Ideal Institute ");
        latitudelist.add(new Double(23.753006));
        longitudelist.add(new Double(90.416565));
        locationName.add("Ikra Bangladesh Madrasha ");
        latitudelist.add(new Double(23.756433));
        longitudelist.add(new Double(90.417915));
        locationName.add("Shiekh Junoruddin Shamsul Uloom Chy para Madrasha ");
        latitudelist.add(new Double(23.7558));
        longitudelist.add(new Double(90.416122));
        locationName.add("Madrasha Darul Ulo Nurbag Masjid ");
        latitudelist.add(new Double(23.752602));
        longitudelist.add(new Double(90.422852));
        locationName.add("Shahid Muno Miyya High School ");
        latitudelist.add(new Double(23.766453));
        longitudelist.add(new Double(90.398468));
        locationName.add("B.G. Press Govt. Primary School ");
        latitudelist.add(new Double(23.75456));
        longitudelist.add(new Double(90.399452));
        locationName.add("Tejgaon Commercial Area Govt. Primary School ");
        latitudelist.add(new Double(23.766981));
        longitudelist.add(new Double(90.403915));
        locationName.add("Farid Uddin Pre-Cadet High School ");
        latitudelist.add(new Double(23.675774));
        longitudelist.add(new Double(90.408752));
        locationName.add("Siddiqi School ");
        latitudelist.add(new Double(23.765676));
        longitudelist.add(new Double(90.406937));
        locationName.add("Bangladesh Textile University ");
        latitudelist.add(new Double(23.760271));
        longitudelist.add(new Double(90.399765));
        locationName.add("Bangladesh Institute of Glass and Ceramic ");
        latitudelist.add(new Double(23.757887));
        longitudelist.add(new Double(90.399117));
        locationName.add("Technical Teachers Training Center ");
        latitudelist.add(new Double(23.75841));
        longitudelist.add(new Double(90.399902));
        locationName.add("Civil Aviation High School ");
        latitudelist.add(new Double(23.775461));
        longitudelist.add(new Double(90.392776));
        locationName.add("Haji Moron Ali Fazil Madrasha Complex ");
        latitudelist.add(new Double(23.773867));
        longitudelist.add(new Double(90.396896));
        locationName.add("Nakhalpara Govt. Primary School ");
        latitudelist.add(new Double(23.772734));
        longitudelist.add(new Double(90.395424));
        locationName.add("Nakhalpara Govt. Primary School ");
        latitudelist.add(new Double(23.772734));
        longitudelist.add(new Double(90.395424));
        locationName.add("Haji Moron Ali Islamia Kamil Madrasha ");
        latitudelist.add(new Double(23.770658));
        longitudelist.add(new Double(90.396622));
        locationName.add("Tejgaon   Govt. Girls High School ");
        latitudelist.add(new Double(23.757311));
        longitudelist.add(new Double(90.390511));
        locationName.add("Govt. Science College ");
        latitudelist.add(new Double(23.75741));
        longitudelist.add(new Double(90.392389));
        locationName.add("Govt. Science College ");
        latitudelist.add(new Double(23.75741));
        longitudelist.add(new Double(90.392389));
        locationName.add("Tejgaon Girls  College ");
        latitudelist.add(new Double(23.755766));
        longitudelist.add(new Double(90.392952));
        locationName.add("Botmoli Home Girls High School ");
        latitudelist.add(new Double(23.760151));
        longitudelist.add(new Double(90.391663));
        locationName.add("Tejgaon Model High School ");
        latitudelist.add(new Double(23.762529));
        longitudelist.add(new Double(90.394005));
        locationName.add("Dhaka High School ");
        latitudelist.add(new Double(23.758381));
        longitudelist.add(new Double(90.381187));
        locationName.add("Tejgaon Farm Govt. Primary School ");
        latitudelist.add(new Double(23.761524));
        longitudelist.add(new Double(90.386345));
        locationName.add("Dhaka High School ");
        latitudelist.add(new Double(23.758381));
        longitudelist.add(new Double(90.381187));
        locationName.add("Dhaka Tutorial ");
        latitudelist.add(new Double(23.755936));
        longitudelist.add(new Double(90.382298));
        locationName.add("Naznin School and College ");
        latitudelist.add(new Double(23.753313));
        longitudelist.add(new Double(90.386963));
        locationName.add("Rotary Govt. Primary School ");
        latitudelist.add(new Double(23.753481));
        longitudelist.add(new Double(90.387062));
        locationName.add("Tejgaon   College ");
        latitudelist.add(new Double(23.758329));
        longitudelist.add(new Double(90.388733));
        locationName.add("Public Building Govt. Boys/Girls High School ");
        latitudelist.add(new Double(23.768524));
        longitudelist.add(new Double(90.373001));
        locationName.add("Shere Bangla  Govt.Girls High School ");
        latitudelist.add(new Double(23.774576));
        longitudelist.add(new Double(90.37439));
        locationName.add("Shaheed Shahabuddin Memorial High School ");
        latitudelist.add(new Double(23.779999));
        longitudelist.add(new Double(90.371063));
        locationName.add("Agargaon Taltola Govt. Colony High School and Women College ");
        latitudelist.add(new Double(23.78075));
        longitudelist.add(new Double(90.37455));
        locationName.add("Tawheed Laboratory School ");
        latitudelist.add(new Double(23.780357));
        longitudelist.add(new Double(90.369446));
        locationName.add("Lions Advance Shikkha Niketon ");
        latitudelist.add(new Double(23.782667));
        longitudelist.add(new Double(90.37796));
        locationName.add("Shyamoli Ideal Technical School and College ");
        latitudelist.add(new Double(23.775854));
        longitudelist.add(new Double(90.368286));
        locationName.add("Kishaloy Girls School and College ");
        latitudelist.add(new Double(23.765682));
        longitudelist.add(new Double(90.363098));
        locationName.add("Bangabandhu Govt. Primary School ");
        latitudelist.add(new Double(23.763828));
        longitudelist.add(new Double(90.360374));
        locationName.add("Kaderia Toiyybia Alia Madrasa ");
        latitudelist.add(new Double(23.767546));
        longitudelist.add(new Double(90.362633));
        locationName.add("King Faisal Institute ");
        latitudelist.add(new Double(23.772106));
        longitudelist.add(new Double(90.361511));
        locationName.add("Mohammadpur Govt. Boys High school ");
        latitudelist.add(new Double(23.767269));
        longitudelist.add(new Double(90.364517));
        locationName.add("Barabo Mohanpur Govt. Primary School ");
        latitudelist.add(new Double(23.23768322));
        longitudelist.add(new Double(90.361626));
        locationName.add("Gauisia Islamia Fazil Madrasa ");
        latitudelist.add(new Double(23.772032));
        longitudelist.add(new Double(90.363541));
        locationName.add("Queens School and Collge ");
        latitudelist.add(new Double(23.772327));
        longitudelist.add(new Double(90.360291));
        locationName.add("Road and Highway Office ");
        latitudelist.add(new Double(23.775972));
        longitudelist.add(new Double(90.363533));
        locationName.add("Dhaka Mission School ");
        latitudelist.add(new Double(23.772734));
        longitudelist.add(new Double(90.358284));
        locationName.add("Hazrat Ayesha(MAPUH) Academy ");
        latitudelist.add(new Double(23.769939));
        longitudelist.add(new Double(90.35038));
        locationName.add("Nabadiganta Ideal High School ");
        latitudelist.add(new Double(23.769707));
        longitudelist.add(new Double(90.345314));
        locationName.add("Adabar Model School ");
        latitudelist.add(new Double(23.779711));
        longitudelist.add(new Double(90.354721));
        locationName.add("British Colombia School and College ");
        latitudelist.add(new Double(23.773968));
        longitudelist.add(new Double(90.358925));
        locationName.add("Adabar Ideal School ");
        latitudelist.add(new Double(23.776897));
        longitudelist.add(new Double(90.357788));
        locationName.add("Mission International Girls School and College ");
        latitudelist.add(new Double(23.774075));
        longitudelist.add(new Double(90.355408));
        locationName.add("Queens College ");
        latitudelist.add(new Double(23.770689));
        longitudelist.add(new Double(90.358727));
        locationName.add("Greenland Residential School and College ");
        latitudelist.add(new Double(23.772352));
        longitudelist.add(new Double(90.35804));
        locationName.add("Greenland Residential School and College ");
        latitudelist.add(new Double(23.772352));
        longitudelist.add(new Double(90.35804));
        locationName.add("Children Academy ");
        latitudelist.add(new Double(23.768654));
        longitudelist.add(new Double(90.357605));
        locationName.add("Pisciculture Housing Public School ");
        latitudelist.add(new Double(23.7693));
        longitudelist.add(new Double(90.355812));
        locationName.add("Saint Francis School ");
        latitudelist.add(new Double(23.769787));
        longitudelist.add(new Double(90.357338));
        locationName.add("Shyamoli Public School ");
        latitudelist.add(new Double(23.768934));
        longitudelist.add(new Double(90.354843));
        locationName.add("Begum Nurjahan Memorial Girls High School ");
        latitudelist.add(new Double(23.766155));
        longitudelist.add(new Double(90.358192));
        locationName.add("Encyclopedia International School ");
        latitudelist.add(new Double(23.764473));
        longitudelist.add(new Double(90.350767));
        locationName.add("Fulkurhi Kindergarten and High School ");
        latitudelist.add(new Double(23.763962));
        longitudelist.add(new Double(90.350269));
        locationName.add("Nabodoy Pre-cadet and High School ");
        latitudelist.add(new Double(23.763216));
        longitudelist.add(new Double(90.35186));
        locationName.add("Mohammadpur Girls High School ");
        latitudelist.add(new Double(23.762367));
        longitudelist.add(new Double(90.361092));
        locationName.add("Mohammadpur Central University and College ");
        latitudelist.add(new Double(23.762543));
        longitudelist.add(new Double(90.359421));
        locationName.add("Mohammadpur Central University and College ");
        latitudelist.add(new Double(23.762543));
        longitudelist.add(new Double(90.359421));
        locationName.add("Mohammadpur Govt. Primary School ");
        latitudelist.add(new Double(23.758293));
        longitudelist.add(new Double(90.359421));
        locationName.add("Baitul Falah Islamia Madrasa and Orphanage ");
        latitudelist.add(new Double(23.791787));
        longitudelist.add(new Double(90.364029));
        locationName.add("Nabazug Ideal Primary School ");
        latitudelist.add(new Double(23.761633));
        longitudelist.add(new Double(90.365395));
        locationName.add("Bengali Medium High School ");
        latitudelist.add(new Double(23.758436));
        longitudelist.add(new Double(90.361916));
        locationName.add("Dhaka State College ");
        latitudelist.add(new Double(23.758385));
        longitudelist.add(new Double(90.36129));
        locationName.add("Lalmatia Housing Society Boys High School ");
        latitudelist.add(new Double(23.758051));
        longitudelist.add(new Double(90.371277));
        locationName.add("Lamatia Women College ");
        latitudelist.add(new Double(23.755951));
        longitudelist.add(new Double(90.367744));
        locationName.add("Dhaka Residential Model College ");
        latitudelist.add(new Double(23.763826));
        longitudelist.add(new Double(90.365631));
        locationName.add("Jamila Ainul Ananda High School ");
        latitudelist.add(new Double(23.772738));
        longitudelist.add(new Double(90.366562));
        locationName.add("Mohammadia Ashraful Madrasa and Orphanage ");
        latitudelist.add(new Double(23.761436));
        longitudelist.add(new Double(90.355354));
        locationName.add("Green Woods School ");
        latitudelist.add(new Double(23.7624));
        longitudelist.add(new Double(90.358337));
        locationName.add("Jamia Mohammadia Arabia Madrasa ");
        latitudelist.add(new Double(23.760738));
        longitudelist.add(new Double(90.3572854));
        locationName.add("Determined Model School ");
        latitudelist.add(new Double(23.760099));
        longitudelist.add(new Double(90.357445));
        locationName.add("Physical Study College ");
        latitudelist.add(new Double(23.755461));
        longitudelist.add(new Double(90.363487));
        locationName.add("Alhaj Makbul Hossain University College ");
        latitudelist.add(new Double(23.754263));
        longitudelist.add(new Double(90.36084));
        locationName.add("Borabo Govt. Primary School ");
        latitudelist.add(new Double(23.757483));
        longitudelist.add(new Double(90.360428));
        locationName.add("Newnation School and College ");
        latitudelist.add(new Double(23.758476));
        longitudelist.add(new Double(90.359505));
        locationName.add("Bashbari High School ");
        latitudelist.add(new Double(23.760111));
        longitudelist.add(new Double(90.358871));
        locationName.add("Bachila Old Govt. Primary School ");
        latitudelist.add(new Double(23.747583));
        longitudelist.add(new Double(90.34655));
        locationName.add("Mohammadia Alim Madrasa ");
        latitudelist.add(new Double(23.747583));
        longitudelist.add(new Double(90.365723));
        locationName.add("Rajmushuri Govt. Primary School ");
        latitudelist.add(new Double(23.743944));
        longitudelist.add(new Double(90.366737));
        locationName.add("West Dhanmondi Yusuf High School ");
        latitudelist.add(new Double(23.749369));
        longitudelist.add(new Double(90.3666));
        locationName.add("Rayer Bazar Community Centre ");
        latitudelist.add(new Double(23.748974));
        longitudelist.add(new Double(90.363792));
        locationName.add("Ali Hossain Girls High School ");
        latitudelist.add(new Double(23.749369));
        longitudelist.add(new Double(90.3666));
        locationName.add("Jafarabad Ideal Govt. Primary School ");
        latitudelist.add(new Double(23.749475));
        longitudelist.add(new Double(90.363625));
        locationName.add("Buming child Kindergarten and School ");
        latitudelist.add(new Double(23.751226));
        longitudelist.add(new Double(90.36322));
        locationName.add("Chinnamul Govt. Primary School ");
        latitudelist.add(new Double(23.747671));
        longitudelist.add(new Double(90.366867));
        locationName.add("Chinnamul Govt. Primary School ");
        latitudelist.add(new Double(23.747671));
        longitudelist.add(new Double(90.366867));
        locationName.add("Nazrul Shikkhaloy ");
        latitudelist.add(new Double(23.74903333));
        longitudelist.add(new Double(90.4074));
        locationName.add("Provati High School Home ");
        latitudelist.add(new Double(23.74953333));
        longitudelist.add(new Double(90.40043333));
        locationName.add("Shahnuri Model High School ");
        latitudelist.add(new Double(23.75083333));
        longitudelist.add(new Double(90.40366667));
        locationName.add("Big Mogbazar Govt. Primary School ");
        latitudelist.add(new Double(23.74948333));
        longitudelist.add(new Double(90.40361667));
        locationName.add("Ispahani Girls High School and College ");
        latitudelist.add(new Double(23.74843333));
        longitudelist.add(new Double(90.40263333));
        locationName.add("Modern Childs Educare ");
        latitudelist.add(new Double(23.75151667));
        longitudelist.add(new Double(90.40603333));
        locationName.add("Shahnuri Model High School ");
        latitudelist.add(new Double(23.75435));
        longitudelist.add(new Double(90.40763333));
        locationName.add("Noyatola A.U.N Kamil Madrasha ");
        latitudelist.add(new Double(23.758));
        longitudelist.add(new Double(90.41036667));
        locationName.add("Sher-e-Bangla School and College ");
        latitudelist.add(new Double(23.75666667));
        longitudelist.add(new Double(90.41141667));
        locationName.add("Noyatola Govt. Primary School ");
        latitudelist.add(new Double(23.75358333));
        longitudelist.add(new Double(90.4077));
        locationName.add("Lions Model School ");
        latitudelist.add(new Double(23.75625));
        longitudelist.add(new Double(90.40913333));
        locationName.add("UCEP Tweet Bud Field School ");
        latitudelist.add(new Double(23.7563));
        longitudelist.add(new Double(90.40948333));
        locationName.add("BTCL Ideal School and College ");
        latitudelist.add(new Double(23.75298333));
        longitudelist.add(new Double(90.41031667));

    }

    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
                    R.id.map1)).getMap();
            googleMap.setBuildingsEnabled(true);
            // check if map_ratting is created successfully or not
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
                R.id.map1)).getMap();

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)) // Sets the center of the map_ratting to
                .zoom(13)                   // Sets the zoom
                .bearing(0) // Sets the orientation of the camera to east
                .tilt(0)    // Sets the tilt of the camera to 30 degrees
                .build();    // Creates a CameraPosition from the builder
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Showing Current Location
//        mMap.setMyLocationEnabled(true); // false to disable

        //Zooming Buttons
        googleMap.getUiSettings().setZoomControlsEnabled(true); // true to enable

        //Zooming Functionality
        googleMap.getUiSettings().setZoomGesturesEnabled(true);

        //Compass Functionality
        googleMap.getUiSettings().setCompassEnabled(true);

        //My Location Button
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);

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
        if(latitudelist.size() >0){
            for(int i=0; i< latitudelist.size(); i++){
                latitude = latitudelist.get(i);
                longitude = longitudelist.get(i);
                name = locationName.get(i);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

            }
        }
        //            final List<Beep> results = mBeepTable.execute().get();
//        23.794799, 90.419385     23.798883, 90.416434
        Log.e("Map", "Started map4");
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
                                startActivity(new Intent(Map.this, MainActivity.class));
                            } else if (drawerItem.getIdentifier() == 1) {
                                startActivity(new Intent(Map.this, PollingStationActivity.class));
                            } else if (drawerItem.getIdentifier() == 2) {
                                //startActivity(new Intent(Map.this, Map.class));
                            } else if (drawerItem.getIdentifier() == 3) {
                                startActivity(new Intent(Map.this, NearestVenue.class));
                            } else if (drawerItem.getIdentifier() == 4) {
                                startActivity(new Intent(Map.this, ShareActivity.class));
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


                .withSelectedItem(2)
                .build();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(false);
//        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
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
