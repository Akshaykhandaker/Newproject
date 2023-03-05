package com.infosys.campamy.Dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.infosys.campamy.model.Staff;
@Repository
public class Dao<E> {
	@Autowired
	SessionFactory sf;
	
	public String insertdata(Staff staff) 
	{
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(staff);
		transaction.commit();
		session.close();
		return "Done";
		
	}
	
	public List<Staff> getdatas() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		List <Staff>  data=criteria.list();
		session.close();
		return data;
		
	}
	
	public Staff get(int Id) {
		Session session = sf.openSession();
		Staff employee = session.get(Staff.class, Id);
		session.close();
    	return employee;
	}
	
	public List sal(int sal) {
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.add(Restrictions.gt("salary", sal));
		List data=criteria.list();
		session.close();
    	return data;
	}
	public List between(int ex1,int ex2)
	{
		Session session=sf.openSession();
		Criteria criter=session.createCriteria(Staff.class);
		criter.add(Restrictions.between("experience", ex1, ex2));
		List data=criter.list();
		session.close();
		return data ;
	}
	public List max() {
		Session session=sf.openSession();
		Query Q=session.createQuery("from Staff where salary=(select max(salary) from Staff)");
		List data=Q.getResultList();
		session.close();
		return data;
	}
	public List min()
	{
		Session session=sf.openSession();
		Query Q=session.createQuery("select name from Staff where salary=(select min(salary) from Staff)");
		List data=Q.getResultList();
		session.close();
		return data;
	}
	public List trainer(String name)
	{
		Session session=sf.openSession();
		Criteria criter=session.createCriteria(Staff.class); 
		criter.add(Restrictions.eq("profile", name));
		List data=criter.list();
		session.close();
		return data;
	}
	public List nottrainer(String name)
	{
		Session session=sf.openSession();
		Criteria criter=session.createCriteria(Staff.class); 
		criter.add(Restrictions.ne("profile", name));
		
		List data=criter.list();
		session.close();
		return data;
	}
	public String update(int sal,int id)
	{
		Session session =sf.openSession();
		Transaction transaction=session.beginTransaction();
		Query Q=session.createQuery("update Staff set salary =:s where id=:d");
		Q.setParameter("s", sal);
		Q.setParameter("d", id);
		Q.executeUpdate();
		transaction.commit();
		session.close();
		return "done";
	}
}
