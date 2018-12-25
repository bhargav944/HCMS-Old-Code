package com.bhargav.hcms.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gurramkonda Bhargav on 05-05-2018.
 */

public class Room {

    public ArrayList<String> member;
    public Map<String, String> groupInfo;

    public Room(){
        member = new ArrayList<>();
        groupInfo = new HashMap<String, String>();
    }
}
