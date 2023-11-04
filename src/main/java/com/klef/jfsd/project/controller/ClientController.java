package com.klef.jfsd.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.project.model.Admin;
import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.model.Task;
import com.klef.jfsd.project.service.AdminService;
import com.klef.jfsd.project.service.CustomerService;
import com.klef.jfsd.project.service.EmailService;
import com.klef.jfsd.project.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ClientController
{
	@Autowired
    private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/")
	public String main()
	{
		return "index";
	}
	
	@GetMapping("index")
	public ModelAndView homebutton()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("about")
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView customerlogin()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@GetMapping("contact")
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("contact");
		return mv;
	}
	
	@GetMapping("register")
	public ModelAndView customerregistration()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
	
	@GetMapping("adminlogin")
	public ModelAndView adminlogin()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}
	
	@GetMapping("adminhome")
	public ModelAndView adminhome()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminhome");
		return mv;
	}
	
//	*//@GetMapping("adminviewall")
//	public ModelAndView adminviewallcustomers()
//	{
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("adminviewall");
//		return mv;
//	}
	
//	@GetMapping("adminmanagecus")
//	public ModelAndView adminmanagecustomer()
//	{
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("adminmanagecus");
//		return mv;
//	}

	
	  @GetMapping("createtasks") 
	  public ModelAndView createtasks() 
	  { 
		  ModelAndView mv=new ModelAndView();
	      mv.setViewName("createtasks"); 
	      return mv; 
	  }
	 





	@GetMapping("customerhome")
	public ModelAndView customerhome()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerhome");
		return mv;
	}
	
	@PostMapping("addcustomer")
	public ModelAndView registercustomer(HttpServletRequest request)
	{
		String msg=null;
		
		ModelAndView mv=new ModelAndView();
		
		try
		{
			String name = request.getParameter("name");
		    String gender = request.getParameter("gender");
		    String dob = request.getParameter("dob");
		    String email = request.getParameter("email");
		    String pwd = request.getParameter("pwd");
		    String location = request.getParameter("location");
		    String contact = request.getParameter("contact");
		    
		     Customer c=new Customer();
		     c.setName(name);
		      c.setGender(gender);
		      c.setDateofbirth(dob);
		      c.setEmail(email);
		      c.setPassword(pwd);
		      c.setLocation(location);
		      c.setContactno(contact);
		    
		      String mailu=c.getEmail();		      
		       msg=customerService.addcustomer(c);
		     
		       emailService.sendEmail(mailu,"Registration Successful","Welcome to task management system application");
		       
		       mv.setViewName("register");
			    mv.addObject("message",msg);
			    
			  
		      
		}
		catch(Exception e)
		{
			
		    mv.setViewName("register");
		    mv.addObject("message","Registration Failed");
		}
	
	    
	    return mv;
	    
	}
	
	@PostMapping("checkcustomerlogin")
	public ModelAndView checkcustomerlogin(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		
		Customer c=customerService.checkcustomerlogin(email, pwd);
		if(c!=null)
		{
			mv.setViewName("customerhome");
			
		}
		else
		{
			mv.setViewName("login");
			mv.addObject("message","Login Failed");
		}
		
		return mv;
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView checkadminlogin(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		Admin a=adminService.checkadminlogin(uname, pwd);
		
		if(a!=null)
		{
			mv.setViewName("adminhome");
		}
		else
		{
			mv.setViewName("adminlogin");
			mv.addObject("message","Login Failed");
		}
		
		
		return mv;
	
	}
	
	@GetMapping("adminviewall")
    public ModelAndView viewallcustomers()
    {
      List<Customer> customerlist=adminService.viewallcustomers();
      
      ModelAndView mv=new ModelAndView("adminviewall");
      mv.addObject("customerdata",customerlist);
      System.out.print(customerlist);
      return mv;
    }
	
	   @GetMapping("adminmanage/{id}")
	   public String deleteaction(@PathVariable("id") int cid)
	   {
	     adminService.deletecus(cid);
	     return "redirect:/adminmanagecus";
	   }
	   
	   @GetMapping("adminmanagecus")
	   public ModelAndView deletecustomerdemo()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("adminmanagecus"); 
	     List<Customer> clist =  adminService.viewallcustomers();
	     mv.addObject("customerdata", clist);
	     return mv;
	   }
	 
	   @GetMapping("deletetask/{id}")
	   public String deletetasks(@PathVariable("id") int tid)
	   {
	     taskService.managetasks(tid);
	     return "redirect:/managetasks";
	   }
	      @GetMapping("managetasks")
			        public ModelAndView deletetaskdemo()
			        {
			          ModelAndView mv = new ModelAndView();
			          mv.setViewName("managetasks"); 
			          List<Task> tasklist =  taskService.viewtasks();
			          mv.addObject("taskdata", tasklist);
			          return mv;
			        }
			   
			   @GetMapping("viewtasks")
			    public ModelAndView viewalltasks()
			    {
			      List<Task> tasklist=taskService.viewtasks();
			      
			      ModelAndView mv=new ModelAndView("viewtasks");
			      mv.addObject("taskdata",tasklist);
			      System.out.print(tasklist);
			      return mv;

		
}
			   @PostMapping("addtasks")
				public ModelAndView createtasks(HttpServletRequest request)
				{
					String msg=null;
					
					ModelAndView mv=new ModelAndView();
					
					try
					{
						String title = request.getParameter("title");
					    String ddate = request.getParameter("duedate");
					    String description = request.getParameter("description");
					    
					    
					     Task t=new Task();
					      t.setTitle(title);
					      t.setDdate(ddate);
					      t.setDescription(description);
					     
					      
					       msg=taskService.createtasks(t);
					       
					       mv.setViewName("createtasks");
						    mv.addObject("message",msg);
					      
					}
					catch(Exception e)
					{
						
					    mv.setViewName("createtasks");
					    mv.addObject("message","Creation Failed");
					}
				
				    
				    return mv;
				    
				}
			   
			   
			 
}
