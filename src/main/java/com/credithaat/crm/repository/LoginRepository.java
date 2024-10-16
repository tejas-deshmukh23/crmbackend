package com.credithaat.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.credithaat.crm.entity.User;
import com.credithaat.crm.entity.anno.User;

public interface LoginRepository extends JpaRepository<User, String> {    
	
//	User findByUsernameAndPassword(String username, String password);
	
	
	User findFirstByUsernameAndPassword(String username, String password);

}
                                                