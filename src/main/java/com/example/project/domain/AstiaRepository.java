package com.example.project.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AstiaRepository extends CrudRepository<Astia, Long> {
	List<Astia> findByOrderByKuosiAsc();

}
