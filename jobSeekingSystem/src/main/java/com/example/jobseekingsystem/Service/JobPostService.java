package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Api.ApiException;
import com.example.jobseekingsystem.Model.JobPost;
import com.example.jobseekingsystem.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;

    //get all job posts
    public List<JobPost> getAllJobPost(){
        return jobPostRepository.findAll();
    }

    // add a job posts
    public void addJobPost(JobPost jobPost){
        if(jobPost == null){
            throw new ApiException("sorry, job post not found");
        }
        jobPostRepository.save(jobPost);
    }

    //update a job posts
    public void updateJobPost(Integer id, JobPost jobPost) {
        JobPost p=jobPostRepository.findJobPostById(id);
        if(p==null){
            throw new ApiException("Sorry, job post not found");
        }
        p.setTitle(jobPost.getTitle());
        p.setDescription(jobPost.getDescription());
        p.setLocation(jobPost.getLocation());
        p.setSalary(jobPost.getSalary());
        p.setPostingDate(jobPost.getPostingDate());

        jobPostRepository.save(p);
    }

    //delete a job posts
    public void deleteJobPost(Integer id){
        // نشيك اذا الjob post  موجود
        JobPost p = jobPostRepository.findJobPostById(id);
        if(p == null){
            throw new ApiException("Sorry, job post not found");
        }
        jobPostRepository.delete(p);
    }
}
