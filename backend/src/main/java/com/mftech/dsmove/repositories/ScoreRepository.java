package com.mftech.dsmove.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mftech.dsmove.entities.Score;
import com.mftech.dsmove.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
	
	

}
