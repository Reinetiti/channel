package com.example.channel;

public class Chaine {
    private String title;
    private String chaine;
    private String coverImage;
    private String imageURL;

    public Chaine() {}
    public Chaine(String title, String chaine, String coverImage, String imageURL){
        this.title = title;
        this.chaine = chaine;
        this.coverImage = coverImage;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChaine() {
        return chaine;
    }

    public void setChaine(String chaine) {
        this.chaine = chaine;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
