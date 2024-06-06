package com.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.scm.entity.SCMEntity;
public interface SCMRepository extends JpaRepository<SCMEntity,Integer>{

}
