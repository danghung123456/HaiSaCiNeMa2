package com.Services;

import org.springframework.stereotype.Service;
import com.Entity.FoodBillDetail;

@Service
public interface FoodBillDetailService {

	public FoodBillDetail add(FoodBillDetail foodBillDetail);

	public FoodBillDetail save(FoodBillDetail foodBillDetail);
}
