package com.example.todoboom;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    private TextView myText;
    private ImageView myImage;

    Holder(@NonNull View view){
        super(view);
        myText = view.findViewById(R.id.todo_text);
        myImage = view.findViewById(R.id.check_image);
    }

    public ImageView getMyImage() {
        return myImage;
    }

    public TextView getMyText() {
        return myText;
    }

    public void setMyImage(ImageView myImage) {
        this.myImage = myImage;
    }

    public void setMyText(TextView myText) {
        this.myText = myText;
    }
}
