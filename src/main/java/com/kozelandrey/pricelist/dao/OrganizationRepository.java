package com.kozelandrey.pricelist.dao;

import com.kozelandrey.pricelist.data.entity.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends MongoRepository<Organization, String> {


}
