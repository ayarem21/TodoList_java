package com.foo.sa_ad.dao;

import com.foo.sa_ad.entity.Todo;
import com.foo.sa_ad.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class TodoDaoImpl implements TodoDao {
    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = (List<Todo>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From Todo")
                .list();
        return todos;
    }

    @Override
    public Todo getTodoById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Todo.class, id);
    }

    @Override
    public Todo addNewTodo(Todo todo) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Serializable id = session.save(todo);
        tx1.commit();
        session.close();
        return getTodoById((Long) id);
    }

    @Override
    public void deleteTodoById(Todo todo) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(todo);
        tx1.commit();
        session.close();
    }

    @Override
    public Todo changeTodoStatus(Todo todo) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(todo);
        tx1.commit();
        session.close();
        return getTodoById(todo.getId());
    }
}
