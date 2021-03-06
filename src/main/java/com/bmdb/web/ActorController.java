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

import com.bmdb.business.Actor;
import com.bmdb.business.Movie;
import com.bmdb.db.ActorRepo;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {
	/*
	 *  a controller will implement five CRUD methods:
	 *  1. GET ALL
	 *  2. GET BY ID
	 *  3. POST - Insert
	 *  4. PUT - Update
	 *  5. Delete - Delete
	 */
	@Autowired
	private ActorRepo actorRepo;
	 @GetMapping("/")
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}
	 
	 @GetMapping("/{id}")
 public Actor getById(@PathVariable int id) {
		 return actorRepo.getOne(id);
	 }
	
	 @PostMapping("/")
	 public Actor addActor(@RequestBody Actor a) {
		 actorRepo.save(a);
		 return a;
	 }
	 
	 @PutMapping("/")
	 public Actor updateActor(@RequestBody Actor a) {
		 a = ActorRepo.save(a);
		 return a;
	 }
	
	 @DeleteMapping("/{id}")
	 public Actor deleteActor(@RequestBody Actor a) {
		 Optional<Actor> a = actorRepo.findById(id);
		 if (a.isPresent()) {
			 actorRepo.deleteById(id);
		 }
		 return a;
	 }
	
}
