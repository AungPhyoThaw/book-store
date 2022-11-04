package com.example.angularshool.ds;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Users  extends IdClass{

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;


}
