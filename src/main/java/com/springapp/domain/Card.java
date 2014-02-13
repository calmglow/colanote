package com.springapp.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;


/**
 * Created by 1109294 on 14. 2. 5.
 */
@Data
public class Card implements Serializable{
    private String id;
    private String name;
    private String content;
    private Date createdDate = Calendar.getInstance().getTime();
    private Date modifiedDate = Calendar.getInstance().getTime();
}
