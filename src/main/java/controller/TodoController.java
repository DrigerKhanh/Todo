package controller;


import java.lang.reflect.Method;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Todo;
import model.TodoModel;
import service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping(method=RequestMethod.GET	)
	public String list(Model model)
	{
		List<Todo> todo=todoService.findAll();
		model.addAttribute("list", todo);
		return "m-todo";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String create(Model model)
	{
		TodoModel todoModel=new TodoModel();
		model.addAttribute("create",todoModel);
		return "create";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String createPost(@ModelAttribute("create") TodoModel todoModel,
			BindingResult result, Model model) throws ParseException
	{
		if(result.hasErrors())
		{
			return "create";
		}
		
		Todo todo=todoModel.toTodo();
		todoService.createTodo(todo);
		
		return "redirect:/todo";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateGet(@RequestParam(name="id") int id,@ModelAttribute("todo") TodoModel todoM, 
			BindingResult result,  Model model) throws ParseException
	{
		Todo a=todoService.findTodo(id);
		if(a==null)
		{
			System.out.println("Khong tim thay todo");
			return "redirect:/todo";
		}
		TodoModel todoModel=new TodoModel();
		todoModel.fromTodo(a);
		
		model.addAttribute("todo",todoModel);
		model.addAttribute("a",a);
//		if(action.equals("edit"))
//		{
//			return "update";
//		}
//		else if(action.equals("delete"))
//		{
//			todoService.deleteTodo(id);
//			return "redirect:/todo";
//		}
		
		if(result.hasErrors())
		{
			return "redirect:/todo";
		}
		
		return "update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePost(@ModelAttribute("todo") TodoModel todo, 
			BindingResult result, Model model) throws ParseException
	{
		Todo b=todo.toTodo();
		todoService.updateTodo(b);
		return "redirect:/todo";
	}
	
	@RequestMapping(value="/start",method=RequestMethod.POST)
	public String startPost(@RequestParam(name="id") int id, Model model)
	{
		DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
		LocalDateTime local=LocalDateTime.now();
		String time=date.format(local);
		
		Todo a=todoService.findTodo(id);
		a.setStatus("In-progress");
		a.setStartAt(time);
		todoService.updateTodo(a);
		
		
		return "redirect:/todo";
	}
	
	@RequestMapping(value="/end",method=RequestMethod.POST)
	public String endPost(@RequestParam(name="id") int id, @ModelAttribute("todo") Todo todo,
		BindingResult result, Model model) throws ParseException
	{
		DateTimeFormatter date= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime local=LocalDateTime.now();
		String time=date.format(local);
		Todo b=todoService.findTodo(id);
		
		b.setStatus("Done");
		b.setEndAt(time);
		todoService.updateTodo(b);
		
		if(result.hasErrors())
		{
			return "redirect:/todo";
		}
		return "redirect:/todo";
	}
	
	@RequestMapping(value="/cancel",method=RequestMethod.POST)
	public String cancelPost(@RequestParam(name="id") int id,
			Model model) throws ParseException
	{
		DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime local=LocalDateTime.now();
		String time=date.format(local);
		
		Todo c=todoService.findTodo(id);
		c.setStatus("Canceled");
		c.setEndAt(time);
		todoService.updateTodo(c);
		
		return "redirect:/todo";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.POST)
	public String viewPost(@RequestParam(name="id") int id, 
			Model model) throws ParseException
	{
		Todo todo=todoService.findTodo(id);
		if(todo==null)
			return "redirect:/todo";
		
		TodoModel todoModel=new TodoModel();
		todoModel.fromTodo(todo);
		
		model.addAttribute("todo", todoModel);
		model.addAttribute("a", todo);
		
		
		return "view";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewGet(@RequestParam(name="id") int id,@RequestParam(name="action") String action,
		Model model) throws ParseException
	{
		Todo todo=todoService.findTodo(id);
		if(todo==null)
		{
			System.out.println("Khong tim thay todo de view");
			return "redirect:/todo";
		}
		
		TodoModel todoModel= new TodoModel();
		todoModel.fromTodo(todo);
		
		model.addAttribute("todo", todoModel);
		
		if (action.equals("delete")) {
			todoService.deleteTodo(id);
			return "redirect:/todo";
		}
		
		return "redirect:/todo";
	}
	
	
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deletePost(@RequestParam(name="id") int id, Model model) throws ParseException
	{
		todoService.deleteTodo(id);
		return "redirect:/todo";
	}
	
}
