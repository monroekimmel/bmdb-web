package com.bmdb.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Actor;
import com.bmdb.business.Movie;

public interface ActorRepo extends JpaRepository<Actor, Integer> {

}
