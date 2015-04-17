package com.example.iit.dhakathon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by IIT on 4/17/2015.
 */
public class Info2 extends Fragment {

    View view;
    TextView tvInfo;
    ImageButton ibBack, ibForward;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.info1, container, false);
        init();

        return view;
    }

    private void init() {
        tvInfo = (TextView)view.findViewById(R.id.tvInfo);
        tvInfo.setText(R.string.info2);
        ibBack = (ImageButton)view.findViewById(R.id.imageButtonBack);
        ibBack.setVisibility(View.VISIBLE);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info1 info1 = new Info1();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, info1)
                        .commit();
            }
        });
        ibForward = (ImageButton)view.findViewById(R.id.imageButtonForward);
        ibForward.setVisibility(View.VISIBLE);
        ibForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info3 info3 = new Info3();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, info3)
                        .commit();
            }
        });
    }
}
