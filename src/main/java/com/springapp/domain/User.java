package com.springapp.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 1109294 on 14. 2. 11.
 */
@Data
public class User implements Serializable {
    private String id;
    private String password;


}
