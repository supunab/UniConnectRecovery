package com.smbsoft.uniconnect.service;

import com.smbsoft.uniconnect.domain.Opportunity;
import com.smbsoft.uniconnect.repository.OpportunityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing Opportunity.
 */
@Service
public class OpportunityService {

    private final Logger log = LoggerFactory.getLogger(OpportunityService.class);
    
    private final OpportunityRepository opportunityRepository;

    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    /**
     * Save a opportunity.
     *
     * @param opportunity the entity to save
     * @return the persisted entity
     */
    public Opportunity save(Opportunity opportunity) {
        log.debug("Request to save Opportunity : {}", opportunity);
        Opportunity result = opportunityRepository.save(opportunity);
        return result;
    }

    /**
     *  Get all the opportunities.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page<Opportunity> findAll(Pageable pageable) {
        log.debug("Request to get all Opportunities");
        Page<Opportunity> result = opportunityRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one opportunity by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Opportunity findOne(String id) {
        log.debug("Request to get Opportunity : {}", id);
        Opportunity opportunity = opportunityRepository.findOne(id);
        return opportunity;
    }

    /**
     *  Delete the  opportunity by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Opportunity : {}", id);
        opportunityRepository.delete(id);
    }
}