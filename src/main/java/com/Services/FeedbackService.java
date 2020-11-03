package com.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.Entity.Feedback;




@Service
public interface FeedbackService {
	
	public List<Feedback> getAll();

    public Feedback add(Feedback feedback);
    
    public Feedback save(Feedback feedback);
    
    public void deleteAll();

    public List<Feedback> addAll(List<Feedback> list);
    
    
	
	
}
