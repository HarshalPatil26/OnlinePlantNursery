package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Seed;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Integer>{

	Seed findBySeedName(String seedName);

}
