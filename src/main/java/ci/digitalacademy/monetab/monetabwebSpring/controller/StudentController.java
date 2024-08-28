package ci.digitalacademy.monetab.monetabwebSpring.controller;

import ci.digitalacademy.monetab.monetabwebSpring.models.Student;
import ci.digitalacademy.monetab.monetabwebSpring.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;


    @GetMapping("add")
    public String StudentAddPage(Model model) {
        model.addAttribute("student",new Student());
        return "student/forms";
    }

    @PostMapping("/student")
    public String saveStudent(Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String StudentUpdatePage(@PathVariable Long id,Model model) {
        Optional<Student> student = studentService.findOne(id);
        if (student.isPresent()){
            model.addAttribute("student",student.get());
            return "student/forms";
        }else {
            return  "redirect:/students";

        }
    }


    @GetMapping
    public String StudentListPage(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";

    }

    @GetMapping("/delete/{id}")
    public String deleteSup(@PathVariable Long id, Model model) {
        studentService.delete(id);
        return "redirect:/students";
    }
}