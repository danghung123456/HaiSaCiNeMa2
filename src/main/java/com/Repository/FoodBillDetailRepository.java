package com.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entity.FoodBillDetail;

@Repository
public interface FoodBillDetailRepository extends JpaRepository<FoodBillDetail, Integer> {

}
