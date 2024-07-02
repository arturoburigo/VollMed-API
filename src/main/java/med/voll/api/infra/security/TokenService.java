package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import med.voll.api.domain.users.Users;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    public String generateToken(Users users) {
        try {
            var algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .withSubject(users.getLogin())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Could not generate token", exception);
        }
    }

    public String getSubject(String token) {
        try {
            var algorithm = Algorithm.HMAC256("123456");
            return JWT.require(algorithm)
                    .withIssuer("API Voll.med")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Could not verify token", exception);
        }
    }

    private Instant dateExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
