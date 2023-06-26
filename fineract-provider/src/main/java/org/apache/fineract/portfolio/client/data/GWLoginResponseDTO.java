package org.apache.fineract.portfolio.client.data;

public record GWLoginResponseDTO(String jwtToken, String expirationStr, Long expiration) {
}
