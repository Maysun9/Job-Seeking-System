package com.example.jobseekingsystem.Controller;

import com.example.jobseekingsystem.Api.ApiResponse;
import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/JobApplication")
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllJobApplication() {
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplication());
    }

    @PostMapping("/add")
    public ResponseEntity<?> ApplyJobApplication(@RequestBody @Valid JobApplication jobApplication) {
        jobApplicationService.ApplyJobApplication(jobApplication);
            return ResponseEntity.status(200).body(new ApiResponse("Job Application submitted successfully"));
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> withdrawJobApplication(@PathVariable Integer id){
        jobApplicationService.withdrawJobApplication(id);
        return ResponseEntity.status(200).body(new ApiResponse("Job Application deleted successfully"));
    }


}
