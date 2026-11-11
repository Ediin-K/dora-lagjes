package com.ekolagja.eko_lagja.service;

import com.ekolagja.eko_lagja.dto.NoticeRequest;
import com.ekolagja.eko_lagja.exception.NotFoundException;
import com.ekolagja.eko_lagja.model.Notice;
import com.ekolagja.eko_lagja.repository.NoticeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	private final NoticeRepository repository;

	public NoticeService(NoticeRepository repository) {
		this.repository = repository;
	}

	public List<Notice> findAll() {
		return repository.findAllByOrderByCreatedAtDesc();
	}

	public Notice findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Notice " + id + " not found"));
	}

	public Notice create(NoticeRequest request) {
		Notice notice = new Notice();
		notice.setTitle(request.title());
		notice.setContent(request.content());
		return repository.save(notice);
	}

	public void delete(Long id) {
		repository.delete(findById(id));
	}
}
