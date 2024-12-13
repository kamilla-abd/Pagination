package org.example.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getPaginatedStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    // Search students by name
    public Page<Student> searchStudentsByName(String name, Pageable pageable) {
        return studentRepository.findByFirstName(name, pageable);
    }
}
