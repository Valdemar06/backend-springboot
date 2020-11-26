package com.valdemar.backendspringboot.repository;

import com.valdemar.backendspringboot.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatRepository extends JpaRepository<Stat,Long> {

    List<Stat> findAllByOrderById();
}
