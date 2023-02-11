package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional =
                studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student does not exists");
        }
        studentRepository.deleteById(studentId);
    }

@Transactional
    public void updateStudent(Long studentId, String studentName, String studentEmail) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student does not exists"));
        if(studentName!=null && studentName.length()>0 && !Objects.equals(studentName, student.getName())){
            student.setName(studentName);
        }
        if(studentEmail!=null && studentEmail.length()>0 && !Objects.equals(studentEmail, student.getEmail())){
            Optional<Student> studentOptional =
                    studentRepository.findStudentByEmail(student.getEmail());
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email already exists");
            }
            student.setName(studentEmail);
        }

    }
}
