package com.hospital.Security.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Key;

@Provider
public class JwtTokenFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (!containerRequestContext.getUriInfo().getPath().equalsIgnoreCase("/api/login")) {
            try {
                String token = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
                String keyString = "C9OJTFHLT";
                Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
                Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            } catch (Exception e) {
                containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        }
    }
}
