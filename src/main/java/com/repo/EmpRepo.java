package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.EmpDto;

public interface EmpRepo extends JpaRepository<EmpDto, Integer>{

	@Query("select empname from EmpDto where id=:id")
	
	public String getNameById(@Param("id") Integer id);
	
	@Query("select empname from EmpDto")
	public List<String> getNames();
	
	@Query("select mail from EmpDto where id=:id")
	public String getMailById(@Param("id") Integer id);
	
	@Query("select mail from EmpDto")
	public List<String> getMails();
}
