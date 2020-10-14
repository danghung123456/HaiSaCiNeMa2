package com.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	@Query("FROM  Member m WHERE m.memberId = :id")
	Optional<Member> findById(Integer id);

	@Query(value = "SELECT * FROM Member m WHERE m.memberName LIKE %?%", nativeQuery = true)
	List<Member> findByName(String name);
}
