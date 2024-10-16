package com.credithaat.crm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.credithaat.crm.entity.hicredit.Apply;

public interface LeadRepository extends JpaRepository<Apply, Long>, QuerydslPredicateExecutor<Apply>{

}
