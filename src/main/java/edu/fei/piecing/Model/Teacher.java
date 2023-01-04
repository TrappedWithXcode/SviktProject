package edu.fei.piecing.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue
    @Column(name = "uid")
    private Integer uid;
    @Column(name = "name")
    private String name;

    @Column(name = "Hash")
    private String pwd;

    @Column(name = "queueNum",unique = true)
    private Integer queueNum;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getQueueNum() {
        return queueNum;
    }

    public void setQueueNum(Integer queueNum) {
        this.queueNum = queueNum;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", queueNum=" + queueNum +
                '}';
    }

}
