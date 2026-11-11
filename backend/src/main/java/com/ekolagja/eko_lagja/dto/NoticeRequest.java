package com.ekolagja.eko_lagja.dto;

import jakarta.validation.constraints.NotBlank;

public record NoticeRequest(@NotBlank String title, @NotBlank String content) {
}
