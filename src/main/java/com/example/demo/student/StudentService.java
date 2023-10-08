package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private  final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Autowired
    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Students students) {
       Optional<Students> studentOptional = studentRepository.findStudentByEmail(students.getEmail());
        if(studentOptional.isPresent()) {
            throw  new IllegalStateException("Email is already taken");
        }
        studentRepository.save(students);
    }

    public void deleteStudent(Long studentId) {
         boolean exists = studentRepository.existsById(studentId);
         if (!exists) {
             throw new IllegalStateException("student with id " + studentId + " does not exists");
         }
         studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Students students = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));
        if(name != null && !name.isEmpty() && !Objects.equals(students.getName(), name)) {
            students.setName(name);
        }
        if(email != null && !email.isEmpty()  && !Objects.equals(students.getEmail(), email)) {
            Optional<Students> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            students.setEmail(email);
        }
    }
}
