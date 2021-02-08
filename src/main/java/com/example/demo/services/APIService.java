package com.example.demo.services;

import com.example.demo.models.User;
import java.util.List;


public interface APIService
{
    // metode som henter brugere
    List<User> getUsers(Integer limit);





}
