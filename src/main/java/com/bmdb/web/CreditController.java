package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Credit;
import com.bmdb.db.CreditRepo;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class CreditController {
	/*
	 *  a controller will implement five CRUD methods:
	 *  1. GET ALL
	 *  2. GET BY ID
	 *  3. POST - Insert
	 *  4. PUT - Update
	 *  5. Delete - Delete
	 */
	@Autowired
	private CreditRepo creditRepo;
	 @GetMapping("/")
	public List<Credit> getAll() {
		return creditRepo.findAll();
	}
	 
	 @GetMapping("/{id}")
 public Credit getById(@PathVariable int id) {
		 return creditRepo.getOne(id);
	 }
	 
	 @PostMapping("/")
	 public Credit addCredit(@RequestBody Credit c) {
		 creditRepo.save(c);
		 return c;
	 }
	 
	 @PutMapping("/")
	 public Credit updateCredit(@RequestBody Credit c) {
		 m = creditRepo.save(c);
		 return c;
	 }
	
	 @DeleteMapping("/{id}")
	 public Credit deleteMovie(@RequestBody Credit c) {
		 Optional<Credit> c = creditRepo.findById(id);
		 if (c.isPresent()) {
			 creditRepo.deleteById(id);
		 }
		 return c;
	 }
	
}

