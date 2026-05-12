package com.example.jobseekingsystem.Controller;

import com.example.jobseekingsystem.Api.ApiResponse;
import com.example.jobseekingsystem.Model.JobPost;
import com.example.jobseekingsystem.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Job-Post")
@RequiredArgsConstructor

public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllJobPost() {
        return ResponseEntity.status(200).body(jobPostService.getAllJobPost());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addJobPost(@RequestBody @Valid JobPost jobPost) {
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job Post added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJobPost(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost) {
        jobPostService.updateJobPost(id, jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job Post updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJobPost(@PathVariable Integer id){
        jobPostService.deleteJobPost(id);
        return ResponseEntity.status(200).body(new ApiResponse("Job Post deleted successfully"));
    }
    //--------------------------------------------------------------END CRUD---------------------------------------------------------------------

}
