package org.example.filter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String students(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(defaultValue = "") String search,
                           Model model) {
        PageRequest pageable = PageRequest.of(page, size);

        Page<Student> studentsPage;
        if (search.isEmpty()) {
            studentsPage = studentService.getPaginatedStudents(pageable);
        } else {
            studentsPage = studentService.searchStudentsByName(search, pageable);
        }

        model.addAttribute("students", studentsPage.getContent());
        model.addAttribute("totalPages", studentsPage.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("search", search);

        return "index";
    }
}
