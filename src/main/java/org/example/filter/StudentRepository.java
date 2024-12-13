package org.example.filter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findAll(Pageable pageable);
    Page<Student> findByFirstName(String firstName, Pageable pageable);
}
