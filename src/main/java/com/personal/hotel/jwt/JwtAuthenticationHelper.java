package com.personal.hotel.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtAuthenticationHelper {

    private String secret="IamkanishakgargasoftwaredeveloperIamGoodwithSPRINGfbjsdbfjksedbfjs";
    public String getUsernameFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        String username = claims.getSubject();
    }

    public Claims getClaimsFromToken(String token){
        JwtParser jwtParser = Jwts.parser().verifyWith(secret).build();
        Claims claims = jwtParser.parseEncryptedClaims(token).getPayload();
        return claims;
    }

    public Boolean isTokenExpired(String token){
        Claims claims = getClaimsFromToken(token);
        Date expDate = claims.getExpiration();
        return expDate.before(new Date()); //before will tell exp date is not before the current date
    }

}
