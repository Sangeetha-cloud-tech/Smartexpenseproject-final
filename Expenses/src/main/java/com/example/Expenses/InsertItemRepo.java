package com.example.Expenses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InsertItemRepo extends JpaRepository<InsertItem,Integer>
{
	//List<InsertItem> findAllByDate(String date);
	@Query(
			value="SELECT * FROM insert_item where date=:date",nativeQuery=true)
			        
	List<InsertItem> filter(@Param("date")String date);
//List<InsertItem> findAll(String date);


}
