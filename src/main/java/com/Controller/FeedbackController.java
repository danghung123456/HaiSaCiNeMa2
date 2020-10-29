package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.FeedbackDTO;
import com.DTO.Base.ResponseEntiy;
import com.Entity.Feedback;
import com.Services.FeedbackService;

@RestController
@RequestMapping(value = "feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping
	public  List<Feedback> index() {
		return feedbackService.getAll();
	}

	@PostMapping(value = "/add")
	public ResponseEntiy<Object> addFeedback(@RequestBody FeedbackDTO feedbackDTO) {
		 if (feedbackDTO.isNull(false)) {
	            return ResponseEntiy.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	            feedbackDTO.setResponseId(null);
	            Feedback feedback = feedbackDTO.convertToFeedback();
	            return ResponseEntiy.body(feedbackService.add(feedback));
	        }
	} 
}
