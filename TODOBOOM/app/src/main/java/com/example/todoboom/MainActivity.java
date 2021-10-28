package com.example.todoboom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private String myEdit;
    ArrayList<Todo> myList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText = (EditText) findViewById(R.id.my_input);
        Button button = (Button) findViewById(R.id.create_button);

        final Context myView = this;
        MyAwesomeApp app = (MyAwesomeApp) getApplicationContext();
        myList = app.tdLst.restore();

        // When the app launches, regardsless of the specific screen, you will load and log
        // (to the default logger, A.K.A android.util.Log) the current size of your TODOs list.
        Log.d("MainActivitySize",Integer.toString(myList.size()));

        final RecyclerView myRecycler = (RecyclerView) findViewById(R.id.my_recycler_view);
        myRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


        if(savedInstanceState!=null){

            myEdit = savedInstanceState.getString("myText");
            editText.setText(savedInstanceState.getString("myText"));

//            int count = savedInstanceState.getInt("count");
//
//            // Failed to save an array list of the todos so creating 2 different array for their
//            // description and is done
//            String[] allTodos = savedInstanceState.getStringArray("allTodos");
//            boolean[] allDones = savedInstanceState.getBooleanArray("allDones");
//
//            for(int i = 0; i < count; i++){
//                myList.add(new Todo(allTodos[i], allDones[i]));
//            }

        }

        final Adaptater myAdaptater = new Adaptater(myList, app);
        myRecycler.setAdapter(myAdaptater);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextString = editText.getText().toString();
                if(editTextString.isEmpty())
                {
                    Toast.makeText(myView, "You can't create an empty TODO item, oh silly !", Toast.LENGTH_LONG).show();
                }
                else{
                    editText.getText().clear();
                    myAdaptater.addItem(new Todo(editTextString, false));
                    myAdaptater.notifyItemInserted(myAdaptater.getItemCount()-1);

                }
            }
        });

    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("myText", editText.getText().toString());
//        outState.putInt("count", myList.size());
//
//        String[] allTodos = new String[myList.size()];
//        boolean[] allDones = new boolean[myList.size()];
//
//        for(int i = 0; i < myList.size(); i++){
//            allTodos[i] = myList.get(i).getDescription();
//            allDones[i] = myList.get(i).getDone();
//        }
//
//        outState.putStringArray("allTodos", allTodos);
//        outState.putBooleanArray("allDones", allDones);

        super.onSaveInstanceState(outState);
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        editText.setText(savedInstanceState.getString("my_text"));
//    }

}
