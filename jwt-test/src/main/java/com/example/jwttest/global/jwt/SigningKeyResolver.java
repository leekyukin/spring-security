package com.example.jwttest.global.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolverAdapter;

import java.security.Key;

/**
 * JwsHeader 를 통해 Signature 검증에 필요한 Key 를 가져오는 코드를 구현합니다.
 */
public class SigningKeyResolver extends SigningKeyResolverAdapter {

    public static SigningKeyResolver instance = new SigningKeyResolver();

    @Override
    public Key resolveSigningKey(JwsHeader header, Claims claims) {
        String kid = header.getKeyId();
        if (kid == null)
            return null;
        return JwtKey.getKey(kid);
    }
}
