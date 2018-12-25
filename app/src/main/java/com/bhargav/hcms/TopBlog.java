package com.bhargav.hcms;

/**
 * Created by Gurramkonda Bhargav on 21-06-2018.
 */

public class TopBlog {

    private String title;
    private String desc;
    private String image;
    private String phone;

    public TopBlog(String title, String desc, String image, String phone) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }
    public TopBlog() {

    }
}
