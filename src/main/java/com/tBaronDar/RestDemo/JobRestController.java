package com.tBaronDar.RestDemo;

import com.tBaronDar.RestDemo.model.JobPost;
import com.tBaronDar.RestDemo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController//<- to avoid using @ResponseBody on every method
@CrossOrigin(origins = "http://localhost:3000") //<- to allow a React app to access the app(CORS)
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("posts")
//    @ResponseBody <- if we use @Controller on the class
    public List<JobPost> getAllPosts(){
        return jobService.getAllJobs();
    }

    @GetMapping("post/{postId}")
    public JobPost getPost(@PathVariable int postId){
        return jobService.getPost(postId);
    }

    @PostMapping("post")
    public JobPost addJob(@RequestBody JobPost jp){
        jobService.addJob(jp);
        return jobService.getPost(jp.getId());
    }

    @PutMapping("post")
    public JobPost updateJob(@RequestBody JobPost jp){
        jobService.updatePost(jp);
        return jobService.getPost(jp.getId());
    }

    @DeleteMapping("post")
    public JobPost deletePost(@RequestBody JobPost jp){
        jobService.deletePost(jp);
        return jp;
    }
}
