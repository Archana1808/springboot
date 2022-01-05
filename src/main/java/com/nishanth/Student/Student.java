package com.nishanth.Student;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    private long id;
    private String Name;
    private Integer age;
    private String email;

    public Student() {
    }

    public Student(long id, String name, int age, String email) {
        this.id = id;
        Name = name;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
