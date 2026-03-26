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

//  @GetMapping(path = "posts", produces = {"application/json"})
    @GetMapping("posts")
//  @ResponseBody <- if we use @Controller on the class
    public List<JobPost> getAllPosts(){
        return jobService.getAllJobs();
    }

    @GetMapping("post/{postId}")
    public JobPost getPost(@PathVariable int postId){
        return jobService.getPost(postId);
    }

    @GetMapping("post/keyword/{keyword}")
    public List<JobPost> searchJobPostByKeyword(@PathVariable String keyword){
        return jobService.searchByKeyword(keyword);
    }

    @PostMapping(path = "post",consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost jp){
        jobService.addJob(jp);
        return jobService.getPost(jp.getId());
    }

    @PutMapping("post")
    public JobPost updateJob(@RequestBody JobPost jp){
        jobService.updatePost(jp);
        return jobService.getPost(jp.getId());
    }

    @DeleteMapping("post/{id}")
    public String deletePost(@PathVariable int id){
        jobService.deletePost(id);
        return "Post deleted";
    }

    @GetMapping("load")
    public String loadData(){
        jobService.load();
        return "Success";
    }
}
