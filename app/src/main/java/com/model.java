package com;

import android.widget.ImageView;

public class model {


    String Title;
    int image;

    public model(String title, int image) {
        Title = title;
        this.image = image;
    }

    model(){}

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
