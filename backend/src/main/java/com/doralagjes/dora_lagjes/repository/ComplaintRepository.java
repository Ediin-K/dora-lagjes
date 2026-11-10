package com.doralagjes.dora_lagjes.repository;

import com.doralagjes.dora_lagjes.model.Complaint;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	List<Complaint> findAllByOrderByCreatedAtDesc();
}
