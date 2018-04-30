package com.helmes.task.entities;


import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ElementCollection
    private List<Integer> sectors;
    private boolean agreed;

    public User(String name, List<Integer> sectors, boolean agreed) {
        this.name = name;
        this.sectors = sectors;
        this.agreed = agreed;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSectors() {
        return sectors;
    }

    public void setSectors(List<Integer> sectors) {
        this.sectors = sectors;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sectors=" + sectors +
                ", agreed=" + agreed +
                '}';
    }
}