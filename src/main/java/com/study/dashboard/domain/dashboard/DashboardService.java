package com.study.dashboard.domain.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DashboardService {
    @Autowired
    private DashboardRepository dashboardRepository;

    public boolean addDashboard(Dashboard dashboard){
        Dashboard result = dashboardRepository.save(dashboard);

        if(result.equals(dashboard)){
            return true;
        }else{
            return false;
        }
    }

    public List<Dashboard> getDashboardList(){
        List<Dashboard> dashboardList = dashboardRepository.findAll();

        return dashboardList;
    }

    public Dashboard getDashboardDetail(Long id){
        Dashboard dashboard = dashboardRepository.getById(id);

        return dashboard;
    }

//    public Dashboard updateDashboard(Dashboard newDashbaord){
//
//    }

    public boolean deleteDashboard(Long id){
        dashboardRepository.deleteById(id);
        Dashboard result = dashboardRepository.getById(id);
        if(result.getId() == null){
            return true;
        }else{
            return false;
        }
    }


}
