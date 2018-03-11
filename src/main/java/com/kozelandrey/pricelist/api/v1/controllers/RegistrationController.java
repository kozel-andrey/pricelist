package com.kozelandrey.pricelist.api.v1.controllers;

import com.kozelandrey.pricelist.data.dto.RegistrationDTO;
import com.kozelandrey.pricelist.services.LoginService;
import com.kozelandrey.pricelist.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody RegistrationDTO data) {
        registrationService.register(data.getLogin(), data.getFirstName(), data.getLastName(),
                data.getOrganizationTitle(), data.getEmail(), data.getPassword());
        loginService.authorise(data.getLogin(), data.getPassword());
        return ResponseEntity.ok().build();
    }

}
