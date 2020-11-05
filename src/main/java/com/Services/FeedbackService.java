package com.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.Entity.Feedback;

@Service
public interface FeedbackService {

	List<Feedback> getAll();

	Feedback add(Feedback feedback);

	Feedback save(Feedback feedback);

	void deleteAll();

	List<Feedback> addAll(List<Feedback> list);

}
