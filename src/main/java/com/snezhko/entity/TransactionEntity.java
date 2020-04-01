package com.snezhko.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TRANSACTION", schema = "DBEX", catalog = "TEST")
public class TransactionEntity {
    private int id;
    private int userId;
    private int hallId;
    private Date date;
    private int cost;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "HALL_ID")
    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    @Basic
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "COST")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (hallId != that.hallId) return false;
        if (cost != that.cost) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + hallId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + cost;
        return result;
    }
}
