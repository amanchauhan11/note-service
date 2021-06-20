package com.notes.noteservice.security;

import com.notes.noteservice.dto.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import static com.notes.noteservice.util.Constants.mapper;

@Slf4j
public class AppAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {
    if (!request.getMethod().equals("POST")) {
      throw new AuthenticationServiceException(
          "Authentication method not supported: " + request.getMethod());
    }
    try {
      UsernamePasswordAuthenticationToken authRequest =
          this.getUserNamePasswordAuthenticationToken(request);
      // Allow subclasses to set the "details" property
      setDetails(request, authRequest);

      Authentication result = this.getAuthenticationManager().authenticate(authRequest);
      SecurityContextHolder.getContext().setAuthentication(result);
      return result;

    } catch (IOException ex) {
      throw new AuthenticationServiceException("Could not parse email and password", ex);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication authResult) throws IOException, ServletException {
    response.setStatus(HttpStatus.OK.value());
  }


  private UsernamePasswordAuthenticationToken getUserNamePasswordAuthenticationToken(
      HttpServletRequest request) throws IOException {
    String requestData = request.getReader().lines().collect(Collectors.joining());
    LoginRequest loginRequest = mapper.readValue(requestData, LoginRequest.class);
    log.info("Got auth request for user: {}", loginRequest.getEmail());
    return new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
        loginRequest.getPassword());
  }
}
