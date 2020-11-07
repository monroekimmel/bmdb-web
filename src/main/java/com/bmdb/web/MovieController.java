package com.bmdb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {
	/*
	 *  a controller will implement five CRUD methods:
	 *  1. GET ALL
	 *  2. GET BY ID
	 *  3. POST - Insert
	 *  4. PUT - Update
	 *  5. Delete - Delete
	 */
	@Autowired
	private MovieRepo movieRepo;
	 @GetMapping("/")
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}
	 //get a movie by id
	 @GetMapping("/{id}")
 public Movie getById(@PathVariable int id) {
		 return movieRepo.getOne(id);
	 }
	 //add a movie
	 public Movie addMovie(@RequestBody Movie m) {
		 movieRepo.save(m);
		 return m;
	 }
	 //update a movie
	 public Movie updateMovie(@RequestBody Movie m) {
		 m = movieRepo.save(m);
		 return m;
	 }
	
}