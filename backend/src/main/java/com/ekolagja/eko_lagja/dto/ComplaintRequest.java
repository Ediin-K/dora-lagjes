package com.ekolagja.eko_lagja.dto;

import jakarta.validation.constraints.NotBlank;

public record ComplaintRequest(@NotBlank String title, @NotBlank String description, String location) {
}
