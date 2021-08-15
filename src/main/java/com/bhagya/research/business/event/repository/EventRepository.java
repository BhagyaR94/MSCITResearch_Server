package com.bhagya.research.business.event.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bhagya.research.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	@Query(value = "SELECT evt FROM Events evt WHERE evt.start >= ?0", nativeQuery = true)
	public Optional<Event> findByStart(Date startDate);

}
