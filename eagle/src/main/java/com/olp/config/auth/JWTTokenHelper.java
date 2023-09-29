package com.olp.config.auth;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.olp.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JWTTokenHelper {

    @Value("${jwt.auth.app}")
    private String appName;

    @Value("${jwt.auth.secret_key}")
    private String secretKey;

    @Value("${jwt.auth.expires_in}")
    private int expiresIn;




    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    static Logger logger = LoggerFactory.getLogger(JWTTokenHelper.class);




    private Claims getAllClaimsFromToken(String token) {
        Claims claims = null;

        try {
            if(token!=null && !token.equals("")) {
                claims = Jwts.parser()
                        .setSigningKey(secretKey)
                        .parseClaimsJws(token)
                        .getBody();
            }

        } catch (Exception e) {
            logger.error("Exception - invalid token --> "+ e);
            claims = null;
        }
        return claims;
    }



    public String getEmailFromToken(String token) {
        String email="";

        try {
            final Claims claims = this.getAllClaimsFromToken(token);

            if(claims!=null) {
                email = claims.getSubject();
            }


        } catch (Exception e) {
            logger.error("Exception in getEmailFromToken ", e);
            email = null;
        }
        return email;
    }



    public String generateToken(UserEntity userEntity) throws InvalidKeySpecException, NoSuchAlgorithmException {

        return Jwts.builder()
                .setIssuer(appName)
                .setSubject(userEntity.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALGORITHM, secretKey)
                .compact();
    }



    private Date generateExpirationDate() {
        return new Date(new Date().getTime() + expiresIn * 1000);
    }



    public boolean validateToken(String token, UserDetails userDetails) {
        final String email = getEmailFromToken(token);

        return(
                email != null &&
                        email.equals(userDetails.getUsername()) &&
                        !isTokenExpired(token)
        );
    }


    public boolean isTokenExpired(String token) {
        Date expireDate = getExpirationDate(token);
        return expireDate.before(new Date());
    }




    private Date getExpirationDate(String token) {

        Date expireDate;
        try {

            final Claims claims = this.getAllClaimsFromToken(token);
            expireDate = claims.getExpiration();

        } catch (Exception e) {
            logger.error("Exception in getExpirationDate ", e);
            expireDate = null;
        }
        return expireDate;
    }



    public Date getIssuedAtDateFromToken(String token) {
        Date issueAt;

        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            issueAt = claims.getIssuedAt();

        } catch (Exception e) {
            logger.error("Exception in getIssuedAtDateFromToken ", e);
            issueAt = null;
        }
        return issueAt;
    }



    public String getToken(HttpServletRequest request) {

        String authHeader = getAuthHeaderFromHeader(request);

        logger.info("authHeader >>>> " + authHeader );

        if( authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }


    public String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }


}
