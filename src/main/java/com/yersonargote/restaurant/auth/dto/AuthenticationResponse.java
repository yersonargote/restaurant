package com.yersonargote.restaurant.auth.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse(String token) {
}
