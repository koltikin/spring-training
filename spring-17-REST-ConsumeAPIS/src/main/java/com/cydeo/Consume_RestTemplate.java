package com.cydeo;

import com.cydeo.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ziya")
public class Consume_RestTemplate {
    private final RestTemplate restTemplate;
    private final String URI = "https://jsonplaceholder.typicode.com/users";

    @GetMapping
    public ResponseEntity<User[]> readAllUser(){
        return restTemplate.getForEntity(URI, User[].class);
    }
    @GetMapping("/{id}")
    public Object readUser(@PathVariable("id") Integer userId){
        String URL = URI + "/{id}";

        return restTemplate.getForObject(URL, Object.class,userId);
    }

}

