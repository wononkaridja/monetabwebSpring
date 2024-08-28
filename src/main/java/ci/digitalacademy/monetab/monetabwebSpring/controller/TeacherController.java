package ci.digitalacademy.monetab.monetabwebSpring.controller;

import ci.digitalacademy.monetab.monetabwebSpring.models.Student;
import ci.digitalacademy.monetab.monetabwebSpring.models.Teacher;
import ci.digitalacademy.monetab.monetabwebSpring.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
        private final TeacherService teacherService;


        @GetMapping("add")
        public  String showAddTeacherForms(Model model){
                log.debug("Request to show teacher forms");
                model.addAttribute("teacher",new Teacher());
                return "teacher/forms";
        }
        @PostMapping("/teacher")
        public String saveTeacher(Teacher teacher) {
                teacherService.save(teacher);
                return "redirect:/teachers";
        }

        @GetMapping("/update/{id}")
        public String showUpdateTeacherForms(Model model, @PathVariable Long id){
                log.debug("Request to show update teacher forms");
                Optional<Teacher> teacher = teacherService.findOne(id);
                if (teacher.isPresent()) {
                        model.addAttribute("teacher", teacher.get());
                        return "teacher/forms";
                }
                else {
                        return "redirect:/teachers";
                }
        }


        @GetMapping
        public String TeacherListPage (Model model) {
                List<Teacher> teachers = teacherService.findAll();
                model.addAttribute("teachers", teachers);
                return "teacher/list";
        }

        @GetMapping("/delete/{id}")
        public String deleteSup(@PathVariable Long id, Model model) {
                teacherService.delete(id);
                return "redirect:/teachers";
        }



}

