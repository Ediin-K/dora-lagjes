package com.ekolagja.eko_lagja.repository;

import com.ekolagja.eko_lagja.model.Complaint;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	List<Complaint> findAllByOrderByCreatedAtDesc();
}
