/*
 * @ (#) TestCourse.java     1.0     8/28/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package edu.iuh.fit;

/**
 * @author Nguyen Thanh Tuan
 * @version 1.0
 * @description This class represents a bank with many bank accounts
 * @created 8/28/2024 11:12 AM
 */
import java.util.List;

public class TestCourse {
    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        initData(courseList);


        System.out.println("Danh sách các khóa học:");
        for (Course course : courseList.getCourses()) {
            System.out.println(course.getId() + " - " + course.getTitle() + " - " + course.getCredit() + " tín chỉ - " + course.getDepartment());
        }


    }

    private static void initData(CourseList courseList) {
        Course course1 = new Course("CSE101", "Introduction to Computer Science", 3, "Computer Science");
        Course course2 = new Course("MATH101", "Calculus I", 4, "Mathematics");
        Course course3 = new Course("PHY101", "Physics I", 3, "Physics");

        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
    }
}