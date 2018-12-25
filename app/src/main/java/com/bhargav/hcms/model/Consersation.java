package com.bhargav.hcms.model;

import java.util.ArrayList;

/**
 * Created by Gurramkonda Bhargav on 05-05-2018.
 */

public class Consersation {

    private ArrayList<Message> listMessageData;
    public Consersation(){
        listMessageData = new ArrayList<>();
    }

    public ArrayList<Message> getListMessageData() {
        return listMessageData;
    }
}
