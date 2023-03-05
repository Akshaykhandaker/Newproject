package com.infosys.campamy.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.campamy.Dao.Dao;
import com.infosys.campamy.model.Staff;
@Service
public class Services {
		@Autowired
		Dao DD;
	public String insertdata(Staff staff) {
		
		return DD.insertdata(staff);
	}
	public List<Staff> getdatas()
	{
		return DD.getdatas();
	}
	public Staff get(int id) {
		return DD.get(id);
	}
	public List sal(int sal)
	{
		return DD.sal(sal);
	}
	public List between(int ex1,int ex2)
	{
		return DD.between(ex1,ex2);
	}
	public List max()
	{
		return DD.max();
		
	}
	public List min()
	{
		return DD.min();
	}
	public List trainer(String name)
	{
		return DD.trainer(name);
	}
	public List nottrainer(String name)
	{
		return DD.nottrainer(name);
	}
	public String update(int sal,int id)
	{
		return DD.update(sal,id);
	}
}
