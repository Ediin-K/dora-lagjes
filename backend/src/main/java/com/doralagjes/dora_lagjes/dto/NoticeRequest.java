package com.doralagjes.dora_lagjes.dto;

import jakarta.validation.constraints.NotBlank;

public record NoticeRequest(@NotBlank String title, @NotBlank String content) {
}
