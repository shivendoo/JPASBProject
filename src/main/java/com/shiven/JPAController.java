package com.shiven;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shiven.dao.IStudentDao;

@RestController
public class JPAController {
	
	@Autowired
	IStudentDao stdao;

	@RequestMapping("/")
public String home()	{
	System.out.println("** Hi This is home method ***");
	return "home.jsp" ;
}
	
	//
	
	 
	@GetMapping(path="/student")
	
	     public List<Student> Student()	{
		System.out.println("** Hi This is Student method ***");
	return stdao.findAll() ;
}
	
	@PostMapping(path="/student")
	public Student addstudent1(Student stud)	{
		stdao.save(stud);
		return stud ;
}
	
	@PutMapping(path="/student")
	public Student Pushstudent(@RequestBody Student student)	{
		stdao.save(student);	
		return student;
		
}
	@DeleteMapping(path="/student/{sid}")
public Student RemoveStud1(@PathVariable int sid)	{
	
	Student student = stdao.findById(sid).orElse(new Student());
	stdao.deleteById(sid);	
	return student;	
}
	
	@RequestMapping("/student/{id}")
	@ResponseBody
public Optional<Student> Student(@PathVariable int id )	{
		System.out.println("** Hi This is Student 1222 method ***");
	return stdao.findById(id) ;
}

@PostMapping("/addstud")
public Student AddStud(Student stud)	{
	stdao.save(stud);
	return stud;
}
	
	@RequestMapping("/findstud")
public ModelAndView AddStud(@RequestParam int sid)	{
	System.out.println("Id of student id --"+sid);
	ModelAndView mv = new ModelAndView();
	mv.setViewName("findstudent.jsp");
	Student student = stdao.findById(sid).orElse(new Student());	
	System.out.println("fetched student is --"+student);
	mv.addObject(student);
	return mv;
	
}
	
	@RequestMapping("/removestudent")
public ModelAndView RemoveStud(@RequestParam int sid)	{
	System.out.println("Id of student id --"+sid);
	ModelAndView mv = new ModelAndView("deletestudent.jsp");
	Student student = stdao.findById(sid).orElse(new Student());
	stdao.deleteById(sid);
	System.out.println("deleted student is --"+student);
	mv.addObject(student);
	return mv;	
}
	
	@RequestMapping("/getstudentbyage")
public ModelAndView  GetstudentByAge(@RequestParam int age)	{
	System.out.println("Id of student id --"+age);
	ModelAndView mv = new ModelAndView("getstudentbyage.jsp");
	List<Student> stdlist  = stdao.findByAge(age);
	System.out.println("Student whose age"+age+" is --"+stdlist);
System.out.println("student greater than"+age+"is -"+stdao.findByAgeGreaterThan(age));
System.out.println("student less than"+age+"is -"+stdao.findByAgeLessThan(age));
mv.addObject(stdlist);
return mv;
}
	
	@RequestMapping("/getstudentbyname")
public ModelAndView GetstudentByName(@RequestParam String name)	{
	System.out.println("Id of student id --"+name);
	ModelAndView mv = new ModelAndView("getstudentbyname.jsp");
	List<Student> stdlist  = stdao.findByName(name);
	System.out.println("Student whose age"+name+" is --"+stdlist);
mv.addObject(stdlist);
	return mv;	
}

}
