package com.example.Expenses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
@Repository
	public interface UserDetailsRepo extends JpaRepository<Users,String>
{
		Users getByUsername(String username);
		@Query(nativeQuery=true,
				value="SELECT * FROM users where username=:username")
		List<Users> filter(@Param("username")String username);
		@Modifying(flushAutomatically=true)
		@Transactional
		@Query(value="UPDATE users SET number=:newnumber where number=:oldnumber",nativeQuery=true)
		void update(@Param("oldnumber")String oldnumber,@Param("newnumber")String newnumber);
		@Modifying(flushAutomatically=true)
		@Transactional
		@Query(value="UPDATE users SET mail=:newmail where mail=:oldmail",nativeQuery=true)
		void update1(@Param("oldmail")String oldmail,@Param("newmail")String newmail);
		@Modifying(flushAutomatically=true)
		@Transactional
		@Query(value="UPDATE users SET password=:newpassword1 where username=:username",nativeQuery=true)
		void update2(String username,String newpassword1);
	}



