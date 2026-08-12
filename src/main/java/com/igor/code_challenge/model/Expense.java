package com.igor.code_challenge.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String reason;
    private double value;
    @Column(updatable = false)
    private double vat;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense(Long id, LocalDate date, String reason, double value, double vat, User user) {
        this.id = id;
        this.date = date;
        this.reason = reason;
        this.value = value;
        this.vat = 20d;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
