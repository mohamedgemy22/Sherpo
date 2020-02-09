package com.enggemy22.sherpoproject.splash.model;

public class PersonalModel {

    private String descreption;
    private String Price;
    public String image;


    public PersonalModel() {
        //empty constractor
    }

    public PersonalModel(String descreption, String price, String image) {
        this.descreption = descreption;
        Price = price;
        this.image = image;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
