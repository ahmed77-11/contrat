package com.medfactor.contrat.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String token = getJwtToken();
        if (token != null) {
            template.header("Cookie", "JWT_TOKEN=" + token);
        }
    }

    private String getJwtToken() {
        // Try thread-local storage first (for Kafka)
        String token = RequestContextHolder.getJwtToken();

        // Fall back to request cookies (for web)
        if (token == null) {
            ServletRequestAttributes attributes =
                    (ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                token = extractTokenFromCookies(request);
            }
        }

        return token;
    }

    private String extractTokenFromCookies(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("JWT_TOKEN".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}