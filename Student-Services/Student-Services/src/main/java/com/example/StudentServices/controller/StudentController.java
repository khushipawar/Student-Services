package com.example.StudentServices.controller;

import com.example.StudentServices.model.Course;
import com.example.StudentServices.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@RestController
//@RequestMapping("/api/students")
//public class StudentController {
//
//    private final List<Student> students = new ArrayList<>();
//
//    public StudentController() {
//        // Create dummy data
//        Student student1 = new Student(1L, "Khushi Pawar", "Description 1");
//        Course course1 = new Course(1L, "Course 1", "Course 1 Description", Arrays.asList("Step 1", "Step 2"));
//        Course course2 = new Course(2L, "Course 2", "Course 2 Description", Arrays.asList("Step 1", "Step 2", "Step 3"));
//        student1.addCourse(course1);
//        student1.addCourse(course2);
//        students.add(student1);
//
//        Student student2 = new Student(2L, "Akriti Singh", "Description 2");
//        Course course3 = new Course(3L, "Course 3", "Course 3 Description", Arrays.asList("Step 1", "Step 2"));
//        student2.addCourse(course3);
//        students.add(student2);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<List<Student>> getAllStudents() {
//        return new ResponseEntity<>(students, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
//        Student student = findStudentById(id);
//        if (student != null) {
//            return new ResponseEntity<>(student, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/{id}/courses")
//    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable Long id) {
//        Student student = findStudentById(id);
//        if (student != null) {
//            List<Course> courses = student.getCourses();
//            return new ResponseEntity<>(courses, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @GetMapping("/{studentId}/courses/{courseId}")
//    public ResponseEntity<Course> getCourseDetails(@PathVariable Long studentId, @PathVariable Long courseId) {
//        Student student = findStudentById(studentId);
//        if (student != null) {
//            Course course = student.getCourses().stream()
//                    .filter(c -> c.getId().equals(courseId))
//                    .findFirst()
//                    .orElse(null);
//            if (course != null) {
//                return new ResponseEntity<>(course, HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    @PostMapping("/{studentId}/courses/{courseId}/register")
//    public ResponseEntity<String> registerForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
//        Student student = findStudentById(studentId);
//        Course course = findCourseById(courseId);
//
//        if (student != null && course != null) {
//            if (student.getCourses().contains(course)) {
//                return new ResponseEntity<>("Student is already registered for the course.", HttpStatus.BAD_REQUEST);
//            }
//
//            student.getCourses().add(course);
//            return new ResponseEntity<>("Student successfully registered for the course.", HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>("Student or course not found.", HttpStatus.NOT_FOUND);
//    }
//
//
//    private Student findStudentById(Long id) {
//        for (Student student : students) {
//            if (student.getId().equals(id)) {
//                return student;
//            }
//        }
//        return null;
//    }
//    // Rest of the code
//
//    private Course findCourseById(Long courseId) {
//        // You can implement the logic to retrieve the course by ID from a data source (e.g., database or in-memory list)
//        // For demonstration purposes, let's assume we have a list of courses
//
//        List<Course> courses = Arrays.asList(
//                new Course(1L, "Course 1", "Description 1", Arrays.asList("Step 1", "Step 2")),
//                new Course(2L, "Course 2", "Description 2", Arrays.asList("Step 1", "Step 2", "Step 3"))
//        );
//
//        return courses.stream()
//                .filter(course -> course.getId().equals(courseId))
//                .findFirst()
//                .orElse(null);
//    }
//
//// Rest of the code
//
//}
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final List<Student> students = new ArrayList<>();

    public StudentController() {
        // Create dummy data
        Student student1 = new Student(1L, "Khushi Pawar", "Description 1");
        Course course1 = new Course(1L, "Course 1", "Course 1 Description", Arrays.asList("Step 1", "Step 2"));
        Course course2 = new Course(2L, "Course 2", "Course 2 Description", Arrays.asList("Step 1", "Step 2", "Step 3"));
        student1.addCourse(course1);
        student1.addCourse(course2);
        students.add(student1);

        Student student2 = new Student(2L, "Akriti Singh", "Description 2");
        Course course3 = new Course(3L, "Course 3", "Course 3 Description", Arrays.asList("Step 1", "Step 2"));
        student2.addCourse(course3);
        students.add(student2);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = findStudentById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable Long id) {
        Student student = findStudentById(id);
        if (student != null) {
            List<Course> courses = student.getCourses();
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Course> getCourseDetails(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = findStudentById(studentId);
        if (student != null) {
            Course course = student.getCourses().stream()
                    .filter(c -> c.getId().equals(courseId))
                    .findFirst()
                    .orElse(null);
            if (course != null) {
                return new ResponseEntity<>(course, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{studentId}/courses/{courseId}/register")
    public ResponseEntity<String> registerForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            if (student.getCourses().contains(course)) {
                return new ResponseEntity<>("Student is already registered for the course.", HttpStatus.BAD_REQUEST);
            }

            student.getCourses().add(course);
            return new ResponseEntity<>("Student successfully registered for the course.", HttpStatus.OK);
        }

        return new ResponseEntity<>("Student or course not found.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        for (Student student : students) {
            courses.addAll(student.getCourses());
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    private Student findStudentById(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private Course findCourseById(Long courseId) {
        List<Course> courses = new ArrayList<>();
        for (Student student : students) {
            courses.addAll(student.getCourses());
        }
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}

