package com.example.angularshool;

import com.example.angularshool.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class AngularSchoolApplication  {
    @Autowired
    private UsersService usersService;

    public static void main(String[] args) {
        SpringApplication.run(AngularSchoolApplication.class, args);
    }
   /* @Bean @Transactional
    public ApplicationRunner runner(){
        return args -> {
            usersService.getCoursesByUserId(1)
                    .stream()
                    .forEach(System.out::println);
        };
    }*/

}
