package com.chormun.learnspringframework.examples.c1;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalService {
    private DataService dataService;

    public BusinessCalService(DataService dataService){
        super();
        this.dataService=dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);}
}
