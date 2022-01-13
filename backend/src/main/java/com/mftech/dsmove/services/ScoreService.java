package com.mftech.dsmove.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mftech.dsmove.dto.MovieDTO;
import com.mftech.dsmove.dto.ScoreDTO;
import com.mftech.dsmove.entities.Movie;
import com.mftech.dsmove.entities.Score;
import com.mftech.dsmove.entities.User;
import com.mftech.dsmove.repositories.MovieRepository;
import com.mftech.dsmove.repositories.ScoreRepository;
import com.mftech.dsmove.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
			
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieID()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) { //Para contar a pontuação.
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size(); //calcular a média do filme.
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}