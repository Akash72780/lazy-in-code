package com.dummy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dummy.Model.Apparel;

@Repository
public interface ApparelRepository extends JpaRepository<Apparel, Long>{
	
	List<Apparel> findApparelId(String apparel_cd);

}
