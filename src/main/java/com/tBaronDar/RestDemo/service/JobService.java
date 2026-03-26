package com.tBaronDar.RestDemo.service;

import com.tBaronDar.RestDemo.model.JobPost;
import com.tBaronDar.RestDemo.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    private List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Gaming Dev for java engine development", 2, List.of(new String[]{"Java", "libJDX"})),
            new JobPost(2, "React Developer", "For frontend development", 2, List.of(new String[]{"React", "Javascript"})),
            new JobPost(3, "Python Developer", "Gaming Dev for java engine development", 2, List.of(new String[]{"Python", "Jupyter"})),
            new JobPost(4, "C++ Developer", "Gaming Dev for java engine development", 2, List.of(new String[]{"Qt5"})),
            new JobPost(5, "DevOps Engineer", "Gaming Dev for java engine development", 2, List.of(new String[]{"Kubernetes", "Docker","Docker Compose"}))
    ));

    @Autowired
    private JobRepo jobrepo;

    public void addJob(JobPost jobPost){jobrepo.save(jobPost);}

    public List<JobPost> getAllJobs(){
        return jobrepo.findAll();
    }

    public JobPost getPost(int id) {
        return jobrepo.findById(id).orElse(new JobPost());
    }

    public void updatePost(JobPost jp) {
        jobrepo.save(jp);
    }

    public void deletePost(int id) {
        jobrepo.deleteById(id);
    }

    public void load() {
        jobrepo.saveAll(jobs);
    }
}
