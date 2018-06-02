package com.example.home.authentic_art_works;

import java.util.Date;

/**
 * Created by home on 06-Apr-18.
 */

public class Updates {
    String title;

    String desc;
    int image,likescount;
    String date;

    public Updates(String title,int image,int likescount,String date,String desc){
        this.title=title;
        this.image=image;
        this.likescount=likescount;
        this.date=date;
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public int getLikescount() {
        return likescount;
    }

    public void setLikescount(int likescount) {
        this.likescount = likescount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
