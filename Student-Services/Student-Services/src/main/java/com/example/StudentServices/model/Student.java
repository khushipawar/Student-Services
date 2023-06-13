package com.example.StudentServices.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private Long id;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    private String name;
    private String description;
    private List<Course> courses;

    public Student(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }



    // Getters and setters
}
