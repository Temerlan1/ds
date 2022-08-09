package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model){
        model.addAttribute("users",userService.findAll());
        return "users/all";
    }

    @GetMapping("/new")//form for create record /users/new
    public String createUsersForm(User user){
        return "/users/new";
    }

    @PostMapping()
    public String createUsers(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/${id}")
    public String userDelete(@PathVariable("id") int id){
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/${id}")
    public String updateUserForm(@PathVariable("id") int id,Model model){
        model.addAttribute("user",userService.findById(id));
        return "update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
