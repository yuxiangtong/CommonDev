package com.yutong.domain;

import java.io.Serializable;


/**
 * 老师
 * 
 * @author yuxiangtong
 *
 */
public class Teacher
    implements Serializable {

    private static final long serialVersionUID = 7488441254318824840L;

    private int id;

    private String name;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}
