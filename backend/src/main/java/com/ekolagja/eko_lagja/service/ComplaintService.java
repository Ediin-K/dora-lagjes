package com.ekolagja.eko_lagja.service;

import com.ekolagja.eko_lagja.dto.ComplaintRequest;
import com.ekolagja.eko_lagja.exception.NotFoundException;
import com.ekolagja.eko_lagja.model.Complaint;
import com.ekolagja.eko_lagja.model.ComplaintStatus;
import com.ekolagja.eko_lagja.repository.ComplaintRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {

	private final ComplaintRepository repository;

	public ComplaintService(ComplaintRepository repository) {
		this.repository = repository;
	}

	public List<Complaint> findAll() {
		return repository.findAllByOrderByCreatedAtDesc();
	}

	public Complaint findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Complaint " + id + " not found"));
	}

	public Complaint create(ComplaintRequest request) {
		Complaint complaint = new Complaint();
		complaint.setTitle(request.title());
		complaint.setDescription(request.description());
		complaint.setLocation(request.location());
		return repository.save(complaint);
	}

	public Complaint updateStatus(Long id, ComplaintStatus status) {
		Complaint complaint = findById(id);
		complaint.setStatus(status);
		return repository.save(complaint);
	}
}
