package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.Todo;

public class TodoModel {
	private String username;
	private String name;
	private String status;
	private String startDate;
	private String startAt;
	private String endAt;
	private String action;
	
	public Todo toTodo()
	{
		Todo todo=new Todo();
		todo.setUsername(this.getUsername());
		todo.setName(this.getName());
		todo.setStatus(this.getStatus());
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			todo.setStartDate(date.parse(this.getStartDate()));
		}catch(ParseException p)
		{
			todo.setStartDate(null);
		}
		todo.setStartAt(this.getStartAt());
		todo.setEndAt(todo.getEndAt());
		
		return todo;
	}
	
	public void fromTodo(Todo todo) throws ParseException
	{
		this.setUsername(todo.getUsername());
		this.setName(todo.getName());
		this.setStatus(todo.getStatus());
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
	    this.setStartDate(date.format(todo.getStartDate()));
	    this.setStartAt(todo.getStartAt());
	    this.setEndAt(todo.getEndAt());
	    this.setAction(todo.getAction());		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartAt() {
		return startAt;
	}
	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}
	public String getEndAt() {
		return endAt;
	}
	public void setEndAt(String endAt) {
		this.endAt = endAt;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
}
