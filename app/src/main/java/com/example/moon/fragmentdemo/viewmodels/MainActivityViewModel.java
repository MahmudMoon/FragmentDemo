package com.example.moon.fragmentdemo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<String> mutableLiveData;
    public MutableLiveData<String> mutableLiveData2;

    public void init(){
        if(mutableLiveData==null || mutableLiveData2==null){
            mutableLiveData2 = new MutableLiveData<>();
            mutableLiveData = new MutableLiveData<>();
            setValueFromFour("Hay Baby");
            setValueFromThree("Love You");
        }
    }

    public MutableLiveData<String> getDataForFour(){
        return mutableLiveData2;
    }

    public MutableLiveData<String> getDataForThree(){
        return mutableLiveData;
    }

    public void setValueFromFour(String s) {
        mutableLiveData.setValue(s);
    }


    public void setValueFromThree(String string) {
        mutableLiveData2.setValue(string);
    }


}
