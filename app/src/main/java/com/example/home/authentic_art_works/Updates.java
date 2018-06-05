package com.example.home.authentic_art_works;

import java.util.Date;

/**
 * Created by home on 06-Apr-18.
 */

public class Updates {
    String title;
    String url;
    String desc;
    int image,likescount;
    String date;
    int imageid,sharecount;

    public Updates(String title,int image,int likescount,int sharecount,String date,String desc,int imageid){
        this.title=title;
        this.image=image;
        this.likescount=likescount;
        this.sharecount=sharecount;
        this.date=date;
        this.desc=desc;
        this.imageid=imageid;
    }
    public Updates(String title,String url,int likescount,int sharecount,String date,String desc,int imageid){
        this.title=title;
        this.url=url;
        this.likescount=likescount;
        this.sharecount=sharecount;
        this.date=date;
        this.desc=desc;
        this.imageid=imageid;
    }

    public int getSharecount() {
        return sharecount;
    }

    public void setSharecount(int sharecount) {
        this.sharecount = sharecount;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
