package tn.esprit.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Integer id) {
        return jobRepository.findById(id);
    }

    public Optional<Job> getJobByService(String service) {
        return jobRepository.findByService(service);
    }

    public void updateJobState(Integer id, boolean available) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        jobOptional.ifPresent(job -> {
            job.setEtat(available);
            jobRepository.save(job);
        });
    }
}