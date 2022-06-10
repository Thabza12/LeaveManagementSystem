package com.vico.LeaveManagementSystem.controller;

import com.vico.LeaveManagementSystem.domain.Leave;
import com.vico.LeaveManagementSystem.exception.ResourceNotFoundException;
import com.vico.LeaveManagementSystem.repository.LeaveRepository;
import com.vico.LeaveManagementSystem.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LeaveController {
    @Autowired
    private LeaveRepository repository;
    @Autowired
    private EmailSenderService service;



    //Get all Leave requests
    @GetMapping("/requests")
    public List<Leave> getAllRequests(){
        return repository.findAll();
    }

    //Create Leave request
    @PostMapping("/create")
    public Leave createRequest(@RequestBody Leave leave){
        String startDate = leave.getStartDate();
        String endDate = leave.getEndDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sdf.parse(startDate);
            Date d2 = sdf.parse(endDate);

            long difference_In_Time = d2.getTime() - d1.getTime();

            long difference_In_Days
                    = (difference_In_Time
                    / (1000 * 60 * 60 * 24))
                    % 365;

            leave.setDaysTaken(difference_In_Days+ " day(s)");
            int totalDays = 30;
            leave.setDaysLeft(totalDays - difference_In_Days+ " day(s) left");


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        sendMail();

        return repository.save(leave);
    }


    String sendMail(){
        this.service.sendMessage(
                "thabisocele.sanele@gmail.com",
                "Leave Application Request",
                "Leave application"
        );
        return "email sent successfully";
    }



    //Delete request
    @DeleteMapping("/request/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Integer id){
        Leave leave = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request "+ id +" not found ::"));

        repository.delete(leave);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }






}
