package com.blcu.annotation.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blcu.annotation.Entity.Corpus;

@Repository
public interface CorpusRepository extends JpaRepository<Corpus, Integer>{

	
	
}
