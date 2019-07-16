package com.example.moon.fragmentdemo.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.fragmentdemo.R;
import com.example.moon.fragmentdemo.activities.MainActivity;

public class FragmentOne extends Fragment {
    TextView textView_fg_one;
    Button button_fg_one;

    postData postData;

    public interface postData{
        public void sendData(String string);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        postData = (postData)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_one_layout, container, false);
        textView_fg_one = (TextView)view.findViewById(R.id.tv_frag_one);
        button_fg_one = (Button)view.findViewById(R.id.btn_frag_one);

        MainActivity mainActivity = (MainActivity)getActivity();
        String data = mainActivity.getData();
        if(!TextUtils.isEmpty(data)){
            textView_fg_one.setText(data);
        }

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        button_fg_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(),"Frag 1 Clicked",Toast.LENGTH_SHORT).show();
                postData.sendData("Changed Value By One");
            }
        });

    }


    @Override
    public void onPause() {
        super.onPause();
    }


}
