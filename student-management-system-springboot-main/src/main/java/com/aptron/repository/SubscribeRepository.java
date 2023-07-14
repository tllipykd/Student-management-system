package com.aptron.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aptron.entity.Subscribe;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {

	Optional<Subscribe> findByEmail(String email);

}
