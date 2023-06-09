package com.example.kevinochoa.CIS4301.NashvillePolicing.Subject;

import org.springframework.jdbc.core.RowMapper;

public class Subject {

    private Long stopId;
    private String race;
    private Integer age;
    private String sex;

    public Subject() {
    }

    public Subject(Long stopId, String race, Integer age, String sex) {
        this.stopId = stopId;
        this.race = race;
        this.age = age;
        this.sex = sex;
    }

    public Subject(String race, Integer age, String sex) {
        this.race = race;
        this.age = age;
        this.sex = sex;
    }

    public Long getStopId() {
        return stopId;
    }

    public void setStopId(Long stopId) {
        this.stopId = stopId;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return  ", age=" + age +
                ", race='" + race + '\'' +
                ", sex='" + sex + '\'';
    }
}
