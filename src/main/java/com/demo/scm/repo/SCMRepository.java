package com.demo.scm.repo;
import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.scm.entity.User;
public interface SCMRepository extends JpaRepository<User,Integer>{

}
