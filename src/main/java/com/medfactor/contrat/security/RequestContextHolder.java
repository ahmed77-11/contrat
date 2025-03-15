package com.medfactor.contrat.security;

import org.springframework.web.context.request.RequestAttributes;

public class RequestContextHolder {
    private static final String JWT_ATTRIBUTE = "JWT_TOKEN";

    public static void setJwtToken(String token) {
        RequestAttributes attributes = org.springframework.web.context.request.RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            // Web context
            attributes.setAttribute(JWT_ATTRIBUTE, token, RequestAttributes.SCOPE_REQUEST);
        } else {
            // Non-web context (Kafka)
            ThreadLocalContext.setToken(token);
        }
    }

    public static String getJwtToken() {
        RequestAttributes attributes = org.springframework.web.context.request.RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            // Web context
            return (String) attributes.getAttribute(JWT_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
        }
        // Non-web context
        return ThreadLocalContext.getToken();
    }

    public static void clear() {
        RequestAttributes attributes = org.springframework.web.context.request.RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            attributes.removeAttribute(JWT_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
        } else {
            ThreadLocalContext.clear();
        }
    }

    private static class ThreadLocalContext {
        private static final ThreadLocal<String> context = new ThreadLocal<>();

        static void setToken(String token) {
            context.set(token);
        }

        static String getToken() {
            return context.get();
        }

        static void clear() {
            context.remove();
        }
    }
}