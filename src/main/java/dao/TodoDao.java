package dao;

import java.util.List;

import javax.persistence.TypedQuery;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import entity.Todo;

@Repository
public class TodoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Todo> findAll()
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		String hql="from Todo";
		TypedQuery<Todo> query=session.createQuery(hql);
		session.getTransaction().commit();
		List<Todo> result=query.getResultList();
		return result;
	}
	
	public Todo findById(int id)
	{
		return sessionFactory.openSession().find(Todo.class,id);
	}
	public List<Todo> findByName(String name)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String hql="from Todo e where e.name=:name";
		Query query=session.createQuery(hql);
		query.setParameter("name", name);
		session.getTransaction().commit();
		List result=query.getResultList();
		return result;		
	}
	
	public Todo createTodo(Todo todo)
	{
		int id=(int) sessionFactory.openSession().save(todo);
		todo.setId(id);
		return todo;
	}
	
	public Todo UpdateTodo(Todo todo)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.update(todo);
		session.getTransaction().commit();
		session.close();
		return todo;
//		String hql="update Todo set name=:name, status=:status, start_date=:startdate, start_at=:startat,end_at=:endat,actions=:action " + " where id=:id";
//		Query query=session.createQuery(hql);
//		query.setParameter("id", todo.getId());
//		query.setParameter("name", todo.getName());
//		query.setParameter("startdate", todo.getStartDate());
//		query.setParameter("startat", todo.getStartAt());
//		query.setParameter("endat", todo.getEndAt());
//		int result=query.executeUpdate();
//		if(result==0)
//		{
//			System.out.println("Update that bai");
//			return null;
//		}
//		else
//		{
//			System.out.println("Update thanh cong");
//		}
//		return todo;
	}
	
	public void deleteTodo(int id)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Todo todo=session.find(Todo.class, id);
		session.delete(todo);
		session.getTransaction().commit();
		session.close();
	}
}
