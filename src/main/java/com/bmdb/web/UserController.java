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

import com.bmdb.business.User;
import com.bmdb.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	/*
	 *  a controller will implement five CRUD methods:
	 *  1. GET ALL
	 *  2. GET BY ID
	 *  3. POST - Insert
	 *  4. PUT - Update
	 *  5. Delete - Delete
	 */
	@Autowired
	private UserRepo userRepo;
	 @GetMapping("/")
	public List<User> getAll() {
		return userRepo.findAll();
	}
	 //get a movie by id
	 @GetMapping("/{id}")
 public User getById(@PathVariable int id) {
		 return userRepo.getOne(id);
	 }
	 //add a movie
	 @PostMapping("/")
	 public User addMovie(@RequestBody User u) {
		 UserRepo.save(u);
		 return u;
	 }
	 //update a movie
	 @PutMapping("/")
	 public User updateMovie(@RequestBody User u) {
		 u = userRepo.save(u);
		 return u;
	 }
	 //delete a movie
	 @DeleteMapping("/{id}")
	 public User deleteMovie(@RequestBody User u) {
		 Optional<User> u = userRepo.findById(id);
		 if (u.isPresent()) {
			 userRepo.deleteById(id);
		 }
		 return u;
	 }
	
}

