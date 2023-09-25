package tn.esprit.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
    List<Job> findAll();
    Optional<Job> findById(Integer id);
    Optional<Job> findByService(String service);
}
