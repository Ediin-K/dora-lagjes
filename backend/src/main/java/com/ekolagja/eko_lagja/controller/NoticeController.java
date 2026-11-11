package com.ekolagja.eko_lagja.controller;

import com.ekolagja.eko_lagja.dto.NoticeRequest;
import com.ekolagja.eko_lagja.model.Notice;
import com.ekolagja.eko_lagja.service.NoticeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

	private final NoticeService service;

	public NoticeController(NoticeService service) {
		this.service = service;
	}

	@GetMapping
	public List<Notice> list() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Notice get(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Notice create(@Valid @RequestBody NoticeRequest request) {
		return service.create(request);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
