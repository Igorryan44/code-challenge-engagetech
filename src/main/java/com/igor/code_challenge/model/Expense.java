package com.igor.code_challenge.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    private Long id;
    private LocalDateTime date;
    private String reason;
    private double value;
    private double vat;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense(Long id, LocalDateTime date, String reason, double value, double vat, User user) {
        this.id = id;
        this.date = date;
        this.reason = reason;
        this.value = value;
        this.vat = vat;
        this.user = user;
    }

    public Expense() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
