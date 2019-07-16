package com.example.moon.fragmentdemo.fragments;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.moon.fragmentdemo.R;
import com.example.moon.fragmentdemo.viewmodels.MainActivityViewModel;


public class FragmentFour extends Fragment {

    TextView textView_frag_four;
    Button button_frag_four;
    MainActivityViewModel mainActivityViewModel;

    public FragmentFour() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_four_layout, container, false);
        textView_frag_four = (TextView)view.findViewById(R.id.tv_frag_four);

        mainActivityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        mainActivityViewModel.init();

        MutableLiveData<String> dataForFour = mainActivityViewModel.getDataForFour();
        dataForFour.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView_frag_four.setText(s);
            }
        });

        button_frag_four = (Button) view.findViewById(R.id.btn_frag_four);
        button_frag_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.setValueFromFour("Changed By Four");
            }
        });
        return view;

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
