package com.bhagya.research.dashboard.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhagya.research.entity.EnrolledUser;

public interface EnrolledUserRepository extends JpaRepository<EnrolledUser, Integer>{
	Optional<EnrolledUser> findByEmail(String email);
}
