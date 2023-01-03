package edu.fei.piecing.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Students")
public class Student {
    public Integer getId() {
        return uid;
    }

    public void setId(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClss() {
        return clss;
    }

    public void setClss(String clss) {
        this.clss = clss;
    }

    @Id
    @Column(name="uid")
    @GeneratedValue
    private Integer uid;
    private String name;
    @Column(name = "class")
    private String clss;

}
