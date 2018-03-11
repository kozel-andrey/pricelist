package com.kozelandrey.pricelist.services;

import com.kozelandrey.pricelist.dao.OrganizationRepository;
import com.kozelandrey.pricelist.dao.UserRepository;
import com.kozelandrey.pricelist.data.entity.Organization;
import com.kozelandrey.pricelist.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional(propagation = Propagation.REQUIRED)
    public User register(String login, String firstName, String lastName, String orgTitle, String email, String password) {
        Organization org = createOrganization(orgTitle);
        return createUser(org, login, firstName, lastName, email, password);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Organization createOrganization(String title) {
        Organization organization = new Organization();
        organization.setTitle(title);
        organizationRepository.save(organization);
        return organization;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User createUser(Organization organization, String login, String firstName, String lastName,
                           String email, String password) {
        String encryptedPassword = encoder.encode(password);
        User user = new User(organization, login, email, firstName, lastName, encryptedPassword);
        userRepository.save(user);
        return user;
    }


}
