//package com.credithaat.crm.util;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import com.auth0.jwt.JWTSigner;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
//
//import jakarta.servlet.http.Cookie;
//
//public class JWTUtil {
//	
//	private static final String SECRET = "XX#$%()(#*!()!KL<><MQ7LM4NQN2QJQ0K sdkjsrow323454fd>?N<:{LWPW";
//    private static final String EXP = "exp";
//    private static final String PAYLOAD = "payload";
//
//    //åŠ å¯†ï¼Œä¼ å…¥ä¸€ä¸ªå¯¹è±¡å’Œæœ‰æ•ˆæœŸ
//    public static<T> String sign(T object, long maxAge){
//        try {
//            final JWTSigner signer = new JWTSigner(SECRET);
//            final Map<String, Object> claims = new HashMap<>();
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonString = mapper.writeValueAsString(object);
//            claims.put(PAYLOAD, jsonString);    
//            claims.put(EXP, System.currentTimeMillis() + maxAge);
//            return signer.sign(claims);
//        } catch(Exception e){
//            return null;
//        }
//    }
//
//    //è§£å¯†ï¼Œä¼ å…¥ä¸€ä¸ªåŠ å¯†å�Žçš„tokenå­—ç¬¦ä¸²å’Œè§£å¯†å�Žçš„ç±»åž‹
//    public static<T> T unsign(String jwt, Class<T> classT){
//        final JWTVerifier verifier = new JWTVerifier(SECRET);
//        try{
//            final Map<String,Object> claims= verifier.verify(jwt);
//            if(claims.containsKey(EXP) && claims.containsKey(PAYLOAD)){
//                long exp = (Long)claims.get(EXP);
//                long currentTimeMillis = System.currentTimeMillis();
//                if (exp > currentTimeMillis){
//                    String json = (String)claims.get(PAYLOAD);
//                    ObjectMapper objectMapper = new ObjectMapper();
//                    return objectMapper.readValue(json, classT);
//                }
//            }
//            return null;
//        }catch (Exception e){
//            return null;
//        }
//    }
//
//	
//	public static String generateToken(Map<String, Object> claims, long expiration) {
//        // Implement your JWT generation logic
//        // Use libraries like JJWT (Java JWT)
//        return "your-jwt-token";
//    }
//	
//
//    public static Cookie createCookie(String name, String value, int maxAge) {
//        Cookie cookie = new Cookie(name, value);
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(maxAge);
//        return cookie;
//    }
//
//}

package com.credithaat.crm.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    private static final String SECRET = "XX#$%()(#*!()!KL<><MQ7LM4NQN2QJQ0K sdkjsrow323454fd>?N<:{LWPW";
    private static final String PAYLOAD = "payload";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    public static <T> String sign(T object, long maxAge) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);
            return JWT.create()
                    .withClaim(PAYLOAD, jsonString)
                    .withExpiresAt(new Date(System.currentTimeMillis() + maxAge))
                    .sign(ALGORITHM);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object", e);
        }
    }

    public static <T> T unsign(String token, Class<T> classT) {
        try {
            DecodedJWT jwt = JWT.require(ALGORITHM)
                    .build()
                    .verify(token);
            
            String payloadJson = jwt.getClaim(PAYLOAD).asString();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(payloadJson, classT);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Invalid token", e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize payload", e);
        }
    }

    public static String generateToken(Map<String, Object> claims, long expiration) {
        return JWT.create()
                .withPayload(claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(ALGORITHM);
    }

    public static Cookie createCookie(String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        return cookie;
    }
}
