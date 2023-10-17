package com.example.demo1.beans;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

// u can't create multile instances of the same class.

@Data
@NoArgsConstructor
@AllArgsConstructor


@Component
public class SecondBean {

    String name;

    @PostConstruct
    private void init(){
        //code
        name = "second bean";
    }

    //The PostConstruct annotation  is what tell Spring that it has tocall that method immediatly after the creation of te component
}
