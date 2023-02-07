package com.example.EmployeeManagement.Controller;

import com.example.EmployeeManagement.Service.EmployeeService;
import com.example.EmployeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String home(Model model){

        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employee");
        return "index";
    }

    @GetMapping("/addEmployee")
    public String addEmployeeFrom(){
        return "addEmployee";
    }

    @PostMapping("/employeeRegister")
    public String employeeRegister(@ModelAttribute Employee employee, HttpSession session){

        System.out.println(employee);
        employeeService.addEmplooyee(employee);

        session.setAttribute("msg", "Employee Added Successfullly....");
        return "redirect:/";
    }
}
