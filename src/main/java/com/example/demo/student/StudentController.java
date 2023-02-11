package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "api/v1/students")
public class StudentController {
    public final StudentService studentService;
@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping()
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteExistingStudent(@PathVariable("studentId") Long studentId){
    studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudentDetails(@PathVariable("studentId") Long studentId,
                                    @RequestParam(required = false) String studentName,
                                    @RequestParam(required = false) String studentEmail){
        studentService.updateStudent(studentId, studentName, studentEmail);
    }
}

