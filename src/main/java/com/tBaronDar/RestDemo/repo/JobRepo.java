package com.tBaronDar.RestDemo.repo;

import com.tBaronDar.RestDemo.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
    private List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Gaming Dev for java engine development", 2, List.of(new String[]{"Java", "libJDX"})),
            new JobPost(2, "React Developer", "For frontend development", 2, List.of(new String[]{"React", "Javascript"})),
            new JobPost(3, "Python Developer", "Gaming Dev for java engine development", 2, List.of(new String[]{"Python", "Jupyter"})),
            new JobPost(4, "C++ Developer", "Gaming Dev for java engine development", 2, List.of(new String[]{"Qt5"})),
            new JobPost(5, "DevOps Engineer", "Gaming Dev for java engine development", 2, List.of(new String[]{"Kubernetes", "Docker","Docker Compose"}))
    ));

    public void addPost(JobPost jobPost) {
        jobs.add(jobPost);
    }

    public List<JobPost> getAllPosts() {
        return this.jobs;
    }

    public JobPost getPost(int id) {
        for(JobPost jobPost :jobs){
            if (jobPost.getId()==id){
                return jobPost;
            }
        }
        return null;
    }

    public void updateJob(JobPost jp) {
        for (JobPost jobPost : jobs){
            if (jobPost.getId()==jp.getId()){
                jobPost.setTitle(jp.getTitle());
                jobPost.setDescription(jp.getDescription());
                jobPost.setReqExperience(jp.getReqExperience());
                jobPost.setTechStack(jp.getTechStack());
            }
        }
    }

    public void deleteJob(int id) {
        for (JobPost jobPost : jobs){
            if(id==jobPost.getId()){
                jobs.remove(jobPost);
            }
        }
    }
}
