package com.example.crudd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class studentsController {
    @Autowired
    private StudentService service;

    @GetMapping("")
    public String showHomePage(Model model) {
        List<students> studentsList = service.listAll();
        model.addAttribute("students", studentsList);
        return "index";
    }

    @GetMapping("/students/new")
    public String showNewForm(Model model) {
        model.addAttribute("students", new students());
        model.addAttribute("pageTitle", "Add new User");
        return "students_form";
    }

    @PostMapping("/students/save")
    public String saveStudent(students student, RedirectAttributes redat) {
        service.save(student);
        redat.addFlashAttribute("message", "This user has been saved successfully");
        return "redirect:/";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redat) {
        try {
            students student = service.get(id);
            model.addAttribute("students", student);
            model.addAttribute("pageTitle", "Edit User Id =" + id + " ");
            return "students_form";
        } catch (UserNotFoundException e) {
            redat.addFlashAttribute("message", e.getMessage());
            return "redirect:/";
        }
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudents(@PathVariable("id") Integer id, RedirectAttributes redat) {
       try {
           service.delete(id);
           redat.addFlashAttribute("message", "Hey the user Id =  "+id+" deleted");
       }
       catch (UserNotFoundException e)
       {
           redat.addFlashAttribute("message", e.getMessage());
       }
        return "redirect:/";

    }
}
