package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entity.TicketDetail;

@Repository
public interface TicketDetailRepository extends JpaRepository<TicketDetail, Integer> {

}
