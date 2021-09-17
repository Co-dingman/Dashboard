package com.study.dashboard.domain.dashboard;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Dashboard {
    @Id
    private Long id;

    private String user;

    private String password;

    private String title;

    private String contents;

    private LocalDateTime writtenTime;
}
