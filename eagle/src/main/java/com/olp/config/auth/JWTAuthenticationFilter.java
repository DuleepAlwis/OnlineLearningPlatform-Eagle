package com.olp.config.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.olp.impl.UserManagementServiceImpl;

public class JWTAuthenticationFilter extends OncePerRequestFilter{


    private UserManagementServiceImpl userManagementServiceImpl;

    private JWTTokenHelper jwtTokenHelper;


    static Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    public JWTAuthenticationFilter(UserManagementServiceImpl userManagementServiceImpl, JWTTokenHelper jwtTokenHelper) {
        this.userManagementServiceImpl = userManagementServiceImpl;
        this.jwtTokenHelper = jwtTokenHelper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("Inside doFilterInternal >");
        logger.info("request >" + request);

        String authToken = jwtTokenHelper.getToken(request);

        logger.info("authToken >>> " + authToken);



        if(authToken != null) {

            String email = jwtTokenHelper.getEmailFromToken(authToken);

            System.out.println("email >>> " + email);

            if(email != null && !email.equals("")) {
                UserDetails userDetails = userManagementServiceImpl.loadUserByUsername(email);

                if(jwtTokenHelper.validateToken(authToken, userDetails)) {

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }

        }

        filterChain.doFilter(request, response);
    }
}
