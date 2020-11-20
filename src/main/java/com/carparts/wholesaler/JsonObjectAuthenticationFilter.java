package com.carparts.wholesaler;

import com.carparts.wholesaler.dtos.AccountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonObjectAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;

    public JsonObjectAuthenticationFilter(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                sb.append(line);
            } //odczytywanie danych z requesta linijka po linijce
            AccountDto authRequest = objectMapper.readValue(sb.toString(), AccountDto.class);//przekazujemy JSON do mappera
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(), authRequest.getPassword()
            ); //zamiana json na dane do logowania, tworzymy z tego authToken
            setDetails(request, token);
            return this.getAuthenticationManager().authenticate(token); //przekazujemy tokena do menedzera
        }catch(IOException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
