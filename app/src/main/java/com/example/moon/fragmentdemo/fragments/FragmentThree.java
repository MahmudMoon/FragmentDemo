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
import com.example.moon.fragmentdemo.activities.MainActivity;
import com.example.moon.fragmentdemo.viewmodels.MainActivityViewModel;


public class FragmentThree extends Fragment {

    MainActivityViewModel mainActivityViewModel;
    TextView textView_frag_three;
    Button button_frag_three;

    public FragmentThree() {

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


        View view = inflater.inflate(R.layout.fragment_three_layout, container, false);
        textView_frag_three = (TextView)view.findViewById(R.id.tv_frag_three);

        mainActivityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        mainActivityViewModel.init();

        MutableLiveData<String> dataForFour = mainActivityViewModel.getDataForThree();
        dataForFour.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView_frag_three.setText(s);
            }
        });

        button_frag_three = (Button) view.findViewById(R.id.btn_frag_three);
        button_frag_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.setValueFromThree("Changed By Three");
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
