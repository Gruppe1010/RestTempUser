package com.example.demo.services;

import com.example.demo.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class APIServiceImplTest
{

    @Autowired // den kan genkende vores Service fordi vi har brugt @Service-annotationen
            // Autowired == endnu en dependyinjection - dvs. når Spring starter op gør den det her
    APIService apiService;

    @Test
    void getUsers()
    {

        List<User> users = apiService.getUsers(10);

        assertEquals(10, users.size());

        // opgave: Kurtis Weisnat

        for(User user : users)
        {
            if(user.getName().equals("Kurtis Weissnat"))
            {
                assertEquals("Kurtis Weissnat", user.getName());
            }
        }

    }
}