package com.example.moon.fragmentdemo.activities;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.moon.fragmentdemo.R;
import com.example.moon.fragmentdemo.fragments.FragmentFour;
import com.example.moon.fragmentdemo.fragments.FragmentOne;
import com.example.moon.fragmentdemo.fragments.FragmentThree;
import com.example.moon.fragmentdemo.fragments.FragmentTwo;
import com.example.moon.fragmentdemo.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements FragmentOne.postData,FragmentTwo.ChangeFragOne {

    public static final String Key = "data";
    private static final String TAG = "MainActivity";
    FragmentManager fragmentManager;
    public String data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_one_container,new FragmentOne()).addToBackStack(null).commit();
        fragmentManager.beginTransaction().replace(R.id.fragment_two_container,new FragmentTwo()).addToBackStack(null).commit();
        fragmentManager.beginTransaction().replace(R.id.fragment_three_container,new FragmentThree()).addToBackStack(null).commit();
        fragmentManager.beginTransaction().replace(R.id.fragment_four_container,new FragmentFour()).addToBackStack(null).commit();

    }

    @Override
    public void sendData(String string) {
        Log.i(TAG, "sendData: "+string);
        setData(string);
        FragmentTwo fragmentTwo = new FragmentTwo();
        fragmentManager.beginTransaction().replace(R.id.fragment_two_container,fragmentTwo).commit();

    }


    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public void change(String string) {
        setData(string);
        FragmentOne fragmentOne = new FragmentOne();
        fragmentManager.beginTransaction().replace(R.id.fragment_one_container,fragmentOne).commit();
    }
}
