package com.ibcs.demo.repository;

import com.ibcs.demo.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    Grade findByGradeNo(String gradeNo);

}
