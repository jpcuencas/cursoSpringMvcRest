package com.cursosring.jpa.springdata.cursospring.repositories;

import com.cursosring.jpa.springdata.cursospring.entities.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ILineRepository extends JpaRepository<Line, Long>, JpaSpecificationExecutor<Line> {

}
