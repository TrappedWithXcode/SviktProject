package edu.fei.piecing.Model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;

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

    public Integer getUid() {
        return uid;
    }



    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", clss='" + clss + '\'' +
                ", queue=" + queue +
                '}';
    }

    @Id
    @Column(name="uid")
    @GeneratedValue
    private Integer uid;
    private String name;
    @Column(name = "class")
    private String clss;
    @Column(name = "queue")
    private Integer queue;
    @Column(name = "PwD")
    private String pwd;





}
