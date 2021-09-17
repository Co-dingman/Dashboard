package com.study.dashboard.domain.dashboard;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class DashboardServiceTest {
    @Autowired
    private DashboardService dashboardService;

    @Test
    @DisplayName("게시글 추가 테스트")
    void addDashboardTest() {
        Dashboard dashboard = new Dashboard();
        dashboard.setId(1L);
        dashboard.setTitle("첫번째 게시글");
        dashboard.setUser("코드보고서");
        dashboard.setPassword("1111");
        dashboard.setWrittenTime(LocalDateTime.now());

        dashboardService.addDashboard(dashboard);

        dashboard.setId(2L);
        dashboard.setTitle("두번째 게시글");
        dashboard.setUser("코드보고서");
        dashboard.setPassword("1111");
        dashboard.setWrittenTime(LocalDateTime.now());

        dashboardService.addDashboard(dashboard);
    }

    @Test
    @DisplayName("전체 게시글 조회 테스트")
    void getDashboardListTest() {
        List<Dashboard> dashboardList = dashboardService.getDashboardList();
        for(Dashboard dashboard : dashboardList){
            log.info("게시글 목록: {}", dashboard.toString());
        }
    }

    @Test
    @DisplayName("게시글 상세 조회 테스트")
    void getDashboardDetailTest() {
        Long id = 1L;
        Dashboard dashboard = dashboardService.getDashboardDetail(id);

        log.info("게시글 목록: {}", dashboard.toString());
    }

    @Test
    @DisplayName("게시글 수정 테스트")
    void updateDashboardTest() {
        //TODO
    }

    @Test
    @DisplayName("게시글 삭제 테스트")
    void deleteDashboardTest() {
        Long id = 1L;
        Long id2 = 2L;


        try{
            dashboardService.deleteDashboard(id);
            dashboardService.deleteDashboard(id2);
            List<Dashboard> dashboardList = dashboardService.getDashboardList();
            log.info("삭제 성공. 조회된 계정 리스트: {}", dashboardList);
        }catch (Exception e){
            log.info("삭제 실패. 사유: {}", e.getMessage());
        }
    }
}