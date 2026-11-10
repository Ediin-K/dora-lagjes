package com.doralagjes.dora_lagjes.controller;

import com.doralagjes.dora_lagjes.dto.ComplaintRequest;
import com.doralagjes.dora_lagjes.model.Complaint;
import com.doralagjes.dora_lagjes.model.ComplaintStatus;
import com.doralagjes.dora_lagjes.service.ComplaintService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

	private final ComplaintService service;

	public ComplaintController(ComplaintService service) {
		this.service = service;
	}

	@GetMapping
	public List<Complaint> list() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Complaint get(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Complaint create(@Valid @RequestBody ComplaintRequest request) {
		return service.create(request);
	}

	@PatchMapping("/{id}/status")
	public Complaint updateStatus(@PathVariable Long id, @RequestParam ComplaintStatus status) {
		return service.updateStatus(id, status);
	}
}
