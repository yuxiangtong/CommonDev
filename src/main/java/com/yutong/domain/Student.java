package com.yutong.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 学生
 * 
 * @author yuxiangtong
 *
 */
public class Student
    implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2695592833661564607L;

    private int id;

    private String name;

    private Map<String, Object> otherMap = new HashMap<String, Object>();

    private Teacher teacher = new Teacher();


    public Map<String, Object> getOtherMap() {
        return otherMap;
    }


    public void setOtherMap(Map<String, Object> otherMap) {
        this.otherMap = otherMap;
    }


    public Teacher getTeacher() {
        return teacher;
    }


    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


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
