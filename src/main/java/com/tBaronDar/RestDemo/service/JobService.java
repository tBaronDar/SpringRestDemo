package com.tBaronDar.RestDemo.service;

import com.tBaronDar.RestDemo.model.JobPost;
import com.tBaronDar.RestDemo.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobrepo;

    public void addJob(JobPost jobPost){jobrepo.addPost(jobPost);}

    public List<JobPost> getAllJobs(){
        return jobrepo.getAllPosts();
    }

    public JobPost getPost(int id) {
        return jobrepo.getPost(id);
    }

    public void updatePost(JobPost jp) {
        jobrepo.updateJob(jp);
    }

    public void deletePost(int id) {
        jobrepo.deleteJob(id);
    }
}
