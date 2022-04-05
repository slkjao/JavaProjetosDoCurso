package com.springProject.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springProject.userdept.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{
	
}
