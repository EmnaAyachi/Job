package tn.esprit.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/jobs")
public class RestController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/service/{service}")
    public ResponseEntity<Job> getJobByService(@PathVariable String service) {
        Optional<Job> job = jobService.getJobByService(service);
        return job.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/state")
    public ResponseEntity<Void> updateJobState(@PathVariable Integer id, @RequestParam boolean available) {
        jobService.updateJobState(id, available);
        return ResponseEntity.noContent().build();
    }
}