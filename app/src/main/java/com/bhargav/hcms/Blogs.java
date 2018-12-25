package com.bhargav.hcms;

/**
 * Created by Gurramkonda Bhargav on 18-06-2018.
 */

public class Blogs {

    private String doctor;
    private String hosp;
    private String desi;
    private String gender;
    private String image;

    public Blogs(String doctor, String hosp, String desi, String gender, String image) {
        this.doctor = doctor;
        this.hosp = hosp;
        this.desi = desi;
        this.gender = gender;
        this.image = image;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getHosp() {
        return hosp;
    }

    public void setHosp(String hosp) {
        this.hosp = hosp;
    }

    public String getDesi() {
        return desi;
    }

    public void setDesi(String desi) {
        this.desi = desi;
    }

    public String getGen() {
        return gender;
    }

    public void setGen(String gender) { this.gender = gender; }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Blogs() {

    }
}
