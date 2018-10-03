package service;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.TodoDao;
import entity.Todo;


@Service
public class TodoService {

	
	@Autowired
	TodoDao todoDao;
	
	public List<Todo> search(String name)
	{
		if(name==null || name.length()==0)
		{
			return todoDao.findAll();
		}
		return todoDao.findByName(name);
	}
	
	public List<Todo> findAll()
	{
		return todoDao.findAll();
	}
	@Transactional
	public Todo createTodo(Todo todo)
	{
		Todo result=todoDao.createTodo(todo);
		return result;
	}
	
	@Transactional
	public Todo findTodo(String username)
	{
		return todoDao.findByUserName(username);
	}
	
	@Transactional
	public Todo updateTodo(Todo todo)
	{
		return todoDao.UpdateTodo(todo);
		
	}
	
	@Transactional
	public void deleteTodo(String username)
	{
		todoDao.deleteTodo(username);
	}
}
