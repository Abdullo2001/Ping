package com.example.TestApi.repository;

import com.example.TestApi.entity.PingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PingRepository extends JpaRepository<PingEntity,Long> {

}
