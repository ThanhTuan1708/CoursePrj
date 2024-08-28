/*
 * @ (#) CourseList.java     1.0     8/28/2024
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
import java.util.ArrayList;
import java.util.List;

public class CourseList {
    private List<Course> courses;

    public CourseList() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        if (exists(course)) {
            System.out.println("Course with ID already exists: " + course.getId());
        } else {
            courses.add(course);
        }
    }

    public boolean exists(Course course) {
        return courses.stream().anyMatch(c -> c.getId().equals(course.getId()));
    }

    public Course[] getCourses() {
        return courses.toArray(new Course[0]);
    }

    public void removeCourse(String courseId) {
        Course course = searchCourseById(courseId);
        if (course != null) {
            courses.remove(course);
        } else {
            System.out.println("Course with ID does not exist: " + courseId);
        }
    }

    public Course searchCourseById(String id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Course> searchCourseByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTitle().contains(title)) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public List<Course> searchCourseByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDepartment().equals(department)) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public List<Course> sortCourses() {
        List<Course> sortedList = new ArrayList<>(courses);
        sortedList.sort((c1, c2) -> c1.getTitle().compareTo(c2.getTitle()));
        return sortedList;
    }

    public List<Course> findMaxCreditCourses() {
        int maxCredit = courses.stream().mapToInt(Course::getCredit).max().orElse(0);
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCredit() == maxCredit) {
                result.add(course);
            }
        }
        return result;
    }

    public String findDepartmentWithMostCourses() {
        return courses.stream()
                .map(Course::getDepartment)
                .distinct()
                .max((d1, d2) -> Integer.compare(
                        (int) courses.stream().filter(c -> c.getDepartment().equals(d1)).count(),
                        (int) courses.stream().filter(c -> c.getDepartment().equals(d2)).count()
                ))
                .orElse(null);
    }
}
