package com.example.iit.dhakathon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by IIT on 4/17/2015.
 */
public class Info1 extends Fragment {

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
        tvInfo.setText(R.string.info1);
        ibBack = (ImageButton)view.findViewById(R.id.imageButtonBack);
        ibBack.setVisibility(View.INVISIBLE);
        ibForward = (ImageButton)view.findViewById(R.id.imageButtonForward);
        ibForward.setVisibility(View.VISIBLE);
        ibForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info2 info2 = new Info2();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, info2)
                        .commit();
            }
        });
    }
}
