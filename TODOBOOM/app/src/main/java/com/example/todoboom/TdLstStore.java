package com.example.todoboom;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TdLstStore {

    SharedPreferences sp;
    ArrayList<Todo> myLst;
    Gson gson;

    TdLstStore(Context context){

        sp = PreferenceManager.getDefaultSharedPreferences(context);
        myLst = new ArrayList<Todo>();
        gson = new Gson();
    }


    public ArrayList<Todo> restore(){

        String spLst = sp.getString("tdLst", null); //null as default if not found

        if(spLst != null){
            myLst = gson.fromJson(spLst, new TypeToken<ArrayList<Todo>>(){}.getType());
        }

        return myLst;
    }

    public void save(ArrayList<Todo> lstTodos){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("tdLst", gson.toJson(lstTodos)); // Something with jsn to check
        editor.apply(); // ALWAYS
    }


}
