package com.bmdb.business;

import javax.persistence.*;

@Entity
public class MovieCollection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
	@ManyToOne
	@JoinColumn(name="ActorID")
private int userId;
	@ManyToOne
	@JoinColumn(name="MovieID")
private Movie movie;;
private double purchasePrice;

public MovieCollection() {
	super();

}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public Movie getMovie() {
	return movie;
}

public void setMovie(Movie movie) {
	this.movie = movie;
}

public double getPurchasePrice() {
	return purchasePrice;
}

public void setPurchasePrice(double purchasePrice) {
	this.purchasePrice = purchasePrice;
}

	
}
