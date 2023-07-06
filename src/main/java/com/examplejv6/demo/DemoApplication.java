package com.examplejv6.demo;

import entity.Student;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/hello.th")
    public String hello(Model model) {
        model.addAttribute("message", "Hello mina");
        return "hello";
    }

    @RequestMapping("/scope")
    public String scope(Model model) {
        model.addAttribute("a", "aaaaaaa");
        request.setAttribute("b", "bbbbbbbb");
        session.setAttribute("c", "ccccccc");
        servletContext.setAttribute("d", "dddd");
        return "scope";
    }

    @RequestMapping("/operator")
    public String operator(Model model) {
        model.addAttribute("x", 5);
        model.addAttribute("y", 7);
        return "operator";
    }

    @GetMapping("/student/form")
    public String student(Model model) {
        Student student = new Student();
        student.setFullname("Nguyên Van Tèo");
        student.setCountry("VN");
        student.setGender(true);
        model.addAttribute("sv", student);
        return "form";
    }

    @PostMapping("/student/save")
    public String save(@ModelAttribute("sv") Student form) {
        return "success";
    }


}
