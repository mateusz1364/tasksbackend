package pl.mateusz1364.tasksbackend.domain.service;

import io.jsonwebtoken.*;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.mateusz1364.tasksbackend.domain.config.AppCredentials;
import pl.mateusz1364.tasksbackend.domain.model.AccessToken;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class PasswordService {
    private final AppCredentials appCredentials;

    public String createHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkSamePassword(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }

    public AccessToken generateAccessToken(int userId) {
        byte[] secret = appCredentials.getAppSecret()
            .getBytes();
        Date expireAt = new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(2));
        String authToken = Jwts.builder()
            .setSubject(String.valueOf(userId))
            .setExpiration(expireAt)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
        return new AccessToken(authToken, expireAt);
    }

    public Optional<Integer> getUserIdFromAccessToken(String accessToken) {
        byte[] secret = appCredentials.getAppSecret()
            .getBytes();
        try {
            Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(accessToken)
                .getBody();
            return Optional.of(Integer.parseInt(claims.getSubject()));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
