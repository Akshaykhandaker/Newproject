package com.infosys.campamy.Cantroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.campamy.Service.Services;
import com.infosys.campamy.model.Staff;

@RestController
public class Controller {
	@Autowired
	Services SS;
	 @PostMapping("sinsert")
	 public String insertdata(@RequestBody Staff staff )
	 {
		 return SS.insertdata(staff);
	 }
	 
	 @GetMapping("getdatas")
	 public List<Staff> getdatas()
	 {
		 return SS.getdatas();
	 }
	 
	@GetMapping("/get/{Id}")
	public Staff get(@PathVariable int Id) {
		return SS.get(Id);
	}
	
	@GetMapping("/sal/{sal}")
	public List sal(@PathVariable int sal)
	{
		return SS.sal(sal);
	}
	@GetMapping("/between/{ex1}/{ex2}")
	public List between(@PathVariable int ex1,@PathVariable int ex2)
	{
		return SS.between(ex1,ex2);
		
	}
	@GetMapping("/maxsal")
	public List max()
	{
		return SS.max();
	}
	@GetMapping("/minname")
	public List min()
	{
		return SS.min();
	}
	@GetMapping("/trainer/{name}")
	public List trainer(@PathVariable String name)
	{
		return SS.trainer(name);
	}
	@GetMapping("/nottrainer/{name}")
	public List nottrainer(@PathVariable String name)
	{
		return SS.nottrainer(name);
	}
	@PutMapping("/update/{sal}/{id}")
	public String update(@PathVariable int sal,@PathVariable int id)
	{
		return SS.update(sal, id);
	}
	@PutMapping("/update22222222/{sal}/{id}")
	public String update(@PathVariable int sal,@PathVariable int id)
	{
		return SS.update(sal, id);
	}
}
