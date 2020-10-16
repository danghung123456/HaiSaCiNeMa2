package com.Services;

import com.Entity.Period;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface PeriodService {
public List<Period> findAll();
	
    public void deleteAll();

    public Period add(Period period);

    public List<Period> addAll(List<Period> list);
    
    public Optional<Period> findById(Integer id);
    
    public List<Period> findByName(String name);

    public Period save(Period period);
    
    public List<Period> findPeriodByStatus(Integer status);
    
    
   
}
