package com.revature.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.revature.model.User;
import com.revature.model.UserPayload;

public class JWTUtility {

    public static String createToken(UserPayload payload) {
        Algorithm algorithm = Algorithm.HMAC256("thisisasecret");

        String token = JWT.create()
                .withClaim("username", payload.getUsername())
                .withClaim("role", payload.getRole())
                .sign(algorithm);

        return token;
    }

    public static UserPayload verifyTokenAndReturnPayload(String token) {
        Algorithm algorithm = Algorithm.HMAC256("thisisasecret");
        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decodedJwt = verifier.verify(token);

        Claim usernameClaim = decodedJwt.getClaim("username");
        Claim roleClaim = decodedJwt.getClaim("role");

        String username = usernameClaim.asString();
        String role = roleClaim.asString();

        return new UserPayload(username, role);
    }

//    public static void main(String[] args) {
//        // Testing out createToken
//        UserPayload payload = new UserPayload("testing123", "employee");
//        String token = createToken(payload);
//        System.out.println(token);
//
//        // Testing out verifyTokenAndReturnPayload
//        UserPayload payload2 = verifyTokenAndReturnPayload(token);
//        System.out.println(payload2.getUsername());
//        System.out.println(payload2.getRole());
//    }

}
