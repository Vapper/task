package com.helmes.task.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer value;
    private Long parentId;
    private String level;

    public Sector(){}

    public Sector(String name, Integer value, Long parentId, String level) {
        this.name = name;
        this.value = value;
        this.parentId = parentId;
        this.level = level;
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", parentId=" + parentId +
                ", level='" + level + '\'' +
                '}';
    }
}
