package com.ekolagja.eko_lagja.repository;

import com.ekolagja.eko_lagja.model.Notice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
	List<Notice> findAllByOrderByCreatedAtDesc();
}
