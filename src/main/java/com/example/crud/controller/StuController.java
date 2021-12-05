package com.example.crud.controller;

import com.example.crud.entity.Student;
import com.example.crud.service.StuInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wjr
 * @create 2021-12-01 13:36
 */
@Controller
public class StuController {
    @Autowired
    private StuInterface stuInterface;

    //查询
    @RequestMapping("/display")
    public ModelAndView Display() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = stuInterface.QueryAll();
        modelAndView.addObject("students", studentList);
        modelAndView.setViewName("Display");
        return modelAndView;
    }

    //删除
    @RequestMapping("/del")
    public ModelAndView del(HttpServletRequest request) {
        int sno = Integer.parseInt(request.getParameter("sno"));
        stuInterface.Del(sno);
        return new ModelAndView("redirect:/display");
    }

    //新增
    @GetMapping("/addPage")
    public ModelAndView addPage(Model model) {
        model.addAttribute("student", new Student());
        return new ModelAndView("add", "stumodel", model);
    }

    @PostMapping("/add")
    public ModelAndView add(Student student) {
        stuInterface.Add(student);
        return new ModelAndView("redirect:/display");
    }

    @GetMapping("/sendsno")
    public ModelAndView sendsno(HttpServletRequest request, Model model) {
        int sno = Integer.parseInt(request.getParameter("sno"));
        Student student = stuInterface.selectByPrimaryKey(sno);
        model.addAttribute("student", student);
        return new ModelAndView("Edit", "stumodel", model);

    }

    @PostMapping("/update")
    public ModelAndView update(Student student) {
        stuInterface.Update(student);
        return new ModelAndView("redirect:/display");
    }
}
