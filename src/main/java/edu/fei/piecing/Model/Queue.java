package edu.fei.piecing.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "queue")
public class Queue {
    @Id
    @Column(name = "id")
    private Integer queueNum;
    @Column(name = "uid")
    private Integer uid;
    @Column(name = "inProgress")
    private Boolean inProgress;

    public Integer getQueueNum() {
        return queueNum;
    }

    public void setQueueNum(Integer queueNum) {
        this.queueNum = queueNum;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queueNum=" + queueNum +
                ", uid=" + uid +
                ", inProgress=" + inProgress +
                '}';
    }
}
