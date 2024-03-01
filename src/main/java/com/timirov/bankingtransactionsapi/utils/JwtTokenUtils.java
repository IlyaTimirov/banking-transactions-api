package com.timirov.bankingtransactionsapi.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.util.*;

@Component
@RequiredArgsConstructor
public class JwtTokenUtils {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.lifetime}")
    private Duration lifetime;

    public String generateToken(UserDetails userDetails){
        Date issuedDate = new Date();
        Date expiredDate = new Date(issuedDate.getTime() + lifetime.toMillis());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(issuedDate)
                .setExpiration(expiredDate)
                .signWith(getSignKeys(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKeys(){
        byte[] keys = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keys);
    }

    public String getUsername(String token){
        return getAllClaimsFromToken(token).getSubject();
    }

    private Claims getAllClaimsFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignKeys())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
