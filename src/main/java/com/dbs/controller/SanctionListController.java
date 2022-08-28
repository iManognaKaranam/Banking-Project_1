package com.dbs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.service.SanctionListService;
import com.dbs.service.Status;

@RestController
public class SanctionListController {

    @Autowired
    SanctionListService sanctionListService;
    
    @GetMapping("/checkSDNList/{name}")
    public ResponseEntity<Status> checkName(@PathVariable("name") String name) throws IOException {
        
    	Status status = sanctionListService.getUserInSanctionList(name);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
