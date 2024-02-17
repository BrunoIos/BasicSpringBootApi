package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student saveNewStudent(Student student) {

        Optional<Student> existingStudent = studentRepository.findByEmail(student.getEmail());


        if (existingStudent.isPresent()) {
            throw new IllegalStateException("Este email já está registrado na base de dados");
        }

        return studentRepository.save(student);
    }


    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Student with id" + id + "does not exist");
        }
        studentRepository.deleteById(id);
    }
}