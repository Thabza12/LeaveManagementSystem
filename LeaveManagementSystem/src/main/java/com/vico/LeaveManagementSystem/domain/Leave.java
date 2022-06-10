package com.vico.LeaveManagementSystem.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "Leave_request")
public class Leave implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String endDate;
    private LeaveType leaveType;
    private String reason;
    private String daysTaken;
    private String daysLeft;

}
