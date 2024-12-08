package com.gatis.hw.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {
    @Value("${auth.header.name}")
    private String header;
    @Value("${auth.secret}")
    private String secret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String providedSecret = request.getHeader(header);
        if (secret.equals(providedSecret))
            SecurityContextHolder.getContext().setAuthentication(new PreAuthenticatedAuthenticationToken(providedSecret, null, new ArrayList<>()));
        filterChain.doFilter(request, response);
    }

}
