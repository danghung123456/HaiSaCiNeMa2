package com.Services;

import org.springframework.stereotype.Service;
import com.Entity.FoodBillDetail;

@Service
public interface FoodBillDetailService {

	FoodBillDetail add(FoodBillDetail foodBillDetail);

	FoodBillDetail save(FoodBillDetail foodBillDetail);
	
	Double getTotalFood (Integer ticketId);
}
