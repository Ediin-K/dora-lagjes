package com.doralagjes.dora_lagjes.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, length = 4000)
	private String description;

	private String location;

	@Enumerated(EnumType.STRING)
	private ComplaintStatus status = ComplaintStatus.OPEN;

	private LocalDateTime createdAt = LocalDateTime.now();

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }
	public ComplaintStatus getStatus() { return status; }
	public void setStatus(ComplaintStatus status) { this.status = status; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
