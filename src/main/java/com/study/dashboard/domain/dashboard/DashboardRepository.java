package com.study.dashboard.domain.dashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
}
