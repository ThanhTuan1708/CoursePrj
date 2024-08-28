/*
 * @ (#) Course.java     1.0     8/28/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package edu.iuh.fit;

/**
 * @author Nguyen Thanh Tuan
 * @version 1.0
 * @description This class represents a bank with many bank accounts
 * @created 8/28/2024 11:11 AM
 */
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course() {
    }

    public Course(String id, String title, int credit, String department) {
        setId(id);
        setTitle(title);
        setCredit(credit);
        setDepartment(department);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() >= 3 && id.matches("[a-zA-Z0-9]+")) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID must have at least 3 characters and contain only letters or digits");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title must not be empty");
        }
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit > 0) {
            this.credit = credit;
        } else {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}