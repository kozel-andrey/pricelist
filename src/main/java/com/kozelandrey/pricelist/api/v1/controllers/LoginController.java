package com.kozelandrey.pricelist.api.v1.controllers;

import com.kozelandrey.pricelist.data.dto.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(LoginDTO loginData) {
        return ResponseEntity.ok().build();
    }

}
