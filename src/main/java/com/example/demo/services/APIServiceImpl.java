package com.example.demo.services;


import com.example.demo.models.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

// Man SKAL skrive @Service-annotationen, ellers virker det ikke
@Service
public class APIServiceImpl implements APIService
{

    String userUrl = "https://jsonplaceholder.typicode.com/users";

    private RestTemplate restTemplate;


    public APIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // bruger fra interface
    @Override
    public List<User> getUsers(Integer limit)
    {
        List<User> users = new ArrayList<>();

        try {
            // denne linje kode skal gå ud på nettet, hente JSON objektet og så konvertere JSON-objektet til kode
            // hvilken http-metode man skal bruge
            ResponseEntity<List<User>> userResponse = restTemplate.exchange(userUrl, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<User>>() {
                    });

            users = userResponse.getBody();
        }
        catch (Exception e)
        {
            System.err.println("Error in getUsers: " + e.getMessage());
        }
        return users;
    }
}
