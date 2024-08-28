package ci.digitalacademy.monetab.monetabwebSpring.controller;

import ci.digitalacademy.monetab.monetabwebSpring.models.Student;
import ci.digitalacademy.monetab.monetabwebSpring.models.Teacher;
import ci.digitalacademy.monetab.monetabwebSpring.models.User;
import ci.digitalacademy.monetab.monetabwebSpring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;



        @GetMapping("/add")
        public String UserAddPage(Model model){
            model.addAttribute("user",new User());
            return "users/forms";
        }

    @PostMapping("/user")
    public String saveUser(User user) {
            user.setDateCreation(Instant.now());
        userService.save(user);
        return "redirect:/users";
    }

        @GetMapping("/update/{id}")
        public String UserUpdatePage(@PathVariable Long id, Model model){
            Optional<User> user = userService.findOne(id);
            if (user.isPresent()){
                model.addAttribute("user",user.get());
                return "users/forms";
            } else {
                return "redirect:/users";
            }
                    }
    @GetMapping
    public String UserListPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteSup(@PathVariable Long id, Model model) {
        userService.delete(id);
        return "redirect:/users";
    }
}
