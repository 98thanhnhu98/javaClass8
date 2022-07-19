package com.example.Example2.mode;

import javax.persistence.*;

@Entity
@Table(name = "subjectt")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "names")
    private String name;
    @Column(name = "descs")
    private String description;
    @Column(name = "sem")
    private long sem;
    @Column(name = "time")
    private long time;

    public Subject(String name, String description, long sem, long time) {
        this.name = name;
        this.description = description;
        this.sem = sem;
        this.time = time;
    }

    public Subject() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public long getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sem=" + sem +
                ", time=" + time +
                '}';
    }
}
