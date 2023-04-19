package com.example.kevinochoa.CIS4301.NashvillePolicing.Subject;

import jakarta.persistence.*;

@Entity
@Table
public class Subject {
    @Id
    @Column(name = "stopid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        return  "stopId=" + stopId +
                ", race='" + race + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ',';
    }
}
