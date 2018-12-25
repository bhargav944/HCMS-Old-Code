package com.bhargav.hcms;

/**
 * Created by Gurramkonda Bhargav on 18-06-2018.
 */

public class Blog {

    private String admin;
    private String email;
    private String language;
    private String gender;
    private String image;

    public Blog(String admin, String email, String language, String gender, String image) {
        this.admin = admin;
        this.email = email;
        this.language = language;
        this.gender = gender;
        this.image = image;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public Blog() {

    }
}
