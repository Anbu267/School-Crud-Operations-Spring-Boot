package com.example.school.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.school.model.Stud;
import com.example.school.service.StudentServices;


@Controller
public class HomeController {
	
	
	String msg =" ";
		
	@Autowired
	StudentServices studentServices;
	
	
	@GetMapping("/index")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/add")
	public String addStudent(Model model) {
		model.addAttribute("studentObj",new Stud());
		return "/add";
	}
	@PostMapping("/add")
	public String addData(@ModelAttribute("studentObj") Stud stu) {
		Optional<Stud>opt=studentServices.searchStudent(stu.getRollNo());
		if(opt.isEmpty()) {
			studentServices.addStudent(stu);
		msg="Add Successfully";
		return "redirect:/delete/";
	}
		else
		msg="Record already exists";
		return "redirect:/delete/";
	}
	@GetMapping("/message/{msg}")
	public String addmessage(@PathVariable("msg")String m,Model model) {
		model.addAttribute("info",m);
		return "message";
	}
	
	@GetMapping("/delete")
	public String deletePag(Model model) {
		model.addAttribute("obj",new Stud());
		return "delete";
	}
	
	
	@PostMapping("/delete")
	public String deleteData(@ModelAttribute("obj") Stud stu) {
		Optional<Stud>opt=studentServices.searchStudent(stu.getRollNo());
		if(opt.isPresent()) {
			studentServices.deleteStudent(stu.getRollNo());
			msg="Delte Successfully";
			return"redirect:/delete/+msg";
		}
		else {
			msg="Record Not exists";
			return "redirect:/delete+msg";	
		}
		
	}
	@GetMapping("/view")
	public String viewPage(Model model){
		model.addAttribute("allstudents",studentServices.showAllRecord());
		return "view";
	}
	@GetMapping("/update")
	public String updatdata(Model model) {
		model.addAttribute("student",new Stud());
		return "update";
	}

//	@PostMapping("search")
//	public String search(@ModelAttribute("student")Stud stu,Model model) {
//		Optional<Stud>record=studentServices.searchStudent(stu.getRollNo());
//		if(record.isPresent()) {
//			stu.setStatus(true);
//			model.addAttribute("studentRecord", record);
//			return "update";
//		}
//		else {
//			msg="Record not exists";
//			return "redirect:/message/"+msg;
//		}
//	
//	}
	@PostMapping("/update")
	public String updatedata(@ModelAttribute("studentRecord") Stud stu) {
		studentServices.addStudent(stu);
		 msg="Add successFull";
			return "redirect:/message/"+msg;
	}
	
	
	
	
	
	//----------------------------&&----------------------------------------
	
	
	
	
	
		
	}
	
	
		
	
	
	

