package com.example.moon.fragmentdemo.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.fragmentdemo.R;
import com.example.moon.fragmentdemo.activities.MainActivity;

public class FragmentTwo extends Fragment {
    TextView textView_fg_two;
    Button button_fg_two;
    private String data;
    private static final String TAG = "FragmentTwo";
    ChangeFragOne changeFragOne;

    public interface ChangeFragOne{
        public void change(String string);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        changeFragOne = (ChangeFragOne)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_two_layout, container, false);
        textView_fg_two = (TextView)view.findViewById(R.id.tv_frag_two);
        button_fg_two = (Button)view.findViewById(R.id.btn_frag_two);
        MainActivity activity = (MainActivity) getActivity();
        String data = activity.getData();
        if(!TextUtils.isEmpty(data)){
            textView_fg_two.setText(data);
        }else{
            Log.i(TAG, "onCreateView: "+"Null String");
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        button_fg_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(),"Frag 2 Clicked",Toast.LENGTH_SHORT).show();
                changeFragOne.change("Changed By Frag Two");
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
