package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Api.ApiException;
import com.example.jobseekingsystem.Model.JobApplication;

import com.example.jobseekingsystem.Model.JobPost;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Repository.JobApplicationRepository;
import com.example.jobseekingsystem.Repository.JobPostRepository;
import com.example.jobseekingsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private  final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;

    //get all Job application
    public List<JobApplication> getAllJobApplication(){
        return jobApplicationRepository.findAll();
    }

    // apply  for a Job application
    public void ApplyJobApplication(JobApplication jobApplication){
            // اتاكد من اليوزر
            User user = userRepository.findUserById(jobApplication.getUserId());
            if(user == null){
                throw new ApiException("User not found");
            }
            // اتاكد من الجوب بوست موجود
            JobPost jobPost = jobPostRepository.findJobPostById(jobApplication.getJobPostId());
            if(jobPost == null){
                throw new ApiException("Job Post not found");
            }
            jobApplicationRepository.save(jobApplication);
        }


    //delete a user
    public void withdrawJobApplication(Integer id){
        // اتاكد ان الجوب ابلكيشن موجود
        JobApplication app = jobApplicationRepository.findJobApplicationById(id);
        if(app == null){
            throw new ApiException("Job Application not found");
        }

        // تأكد أن اليوزر موجود
        User user = userRepository.findUserById(app.getUserId());
        if(user == null){
            throw new ApiException("User not found");
        }

        // تأكد أن الجوب بوست موجود
        JobPost jobPost = jobPostRepository.findJobPostById(app.getJobPostId());
        if(jobPost == null){
            throw new ApiException("Job Post not found");
        }
        // حذف الطلب
        jobApplicationRepository.delete(app);
    }
   }
