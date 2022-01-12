package com.mftech.dsmove.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mftech.dsmove.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
