package com.example.home.authentic_art_works;

/**
 * Created by home on 18-Mar-18.
 */

public class card {
    private int numberNotification;
    private int numberUpdate;
    private String title;
    private String description;
    private int image;String logo;

    public card() {
    }

    public card(String logo,int numberNotification, int numberUpdate, String title, String description, int image) {
        this.numberNotification = numberNotification;
        this.numberUpdate = numberUpdate;
        this.title = title;
        this.description = description;
        this.image = image;
        this.logo=logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getNumberNotification() {
        return numberNotification;
    }

    public void setNumberNotification(int numberNotification) {
        this.numberNotification = numberNotification;
    }

    public int getNumberUpdate() {
        return numberUpdate;
    }

    public void setNumberUpdate(int numberUpdate) {
        this.numberUpdate = numberUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}