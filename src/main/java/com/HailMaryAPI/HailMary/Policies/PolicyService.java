package com.HailMaryAPI.HailMary.Policies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.HailMaryAPI.HailMary.Logging.LoggingController;



@Service
public class PolicyService {
    private final PolicyRepository policyRepository;
    private final LoggingController logs;

    @Autowired
    public PolicyService(PolicyRepository policyRepository, LoggingController logs) {
        this.policyRepository = policyRepository;
        this.logs = logs;
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public List<Policy> getAllPoliciesByEmail(String email) {
        Optional<List<Policy>> policiesOptional = policyRepository.findPoliciesByEmail(email);
        policyRepository.findPoliciesByEmail(email);
        if(policiesOptional.isPresent()) {
            List<Policy> policies = policiesOptional.get();
            logs.policyRetrievedSuccessfully("email");
            return policies;
        }
        this.logs.unableToFindPolicy("email");
        return null;
    }

    public List<Policy> getAllPoliciesByClientId(int id) {
      Optional<List<Policy>> policiesOptional = policyRepository.findPoliciesByClientId(id);
      if(policiesOptional.isPresent()) {
          List<Policy> policies = policiesOptional.get();
          logs.policyRetrievedSuccessfully("client ID");
          return policies;
      }
      this.logs.unableToFindPolicy("client ID");
      return null;
  }

        public List<Policy> findByName(String first_name, String last_name) {
            Optional<List<Policy>> policiesOptional = policyRepository.findByName(first_name, last_name);
            
            if(policiesOptional.isPresent()) {
                List<Policy> policies = policiesOptional.get();
                logs.policyRetrievedSuccessfully("name");
                return policies;
            }
        this.logs.unableToFindPolicy("name");
        return null;
    }

    public Policy getPolicyById(int id) {
        boolean exists = policyRepository.existsById(id);
        if(!exists) {
            logs.unableToFindPolicy("ID");
        }
        logs.policyRetrievedSuccessfully("ID");
        return policyRepository.getOne(id);
    }

    public void addNewPolicy(Policy policy) {
        Optional<Policy> policyOptional = policyRepository.findById(policy.getPolicy_id());
        if(policyOptional.isPresent()) {
            logs.policyExists();
        }
        logs.policyAddedSuccessfully();
        policyRepository.save(policy);
    }

    public void deletePolicy(Policy policy) {
        Optional<Policy> policyOptional = policyRepository.findById(policy.getPolicy_id());
        if(!policyOptional.isPresent()) {
            logs.unableToFindPolicy("searching");
        }
        policyRepository.delete(policy);
        logs.policyDeletedSuccessfully("main deletion");
    }

    public void deletePolicyById(int id) {
        Optional<Policy> policyOptional = policyRepository.findById(id);
        if(policyOptional.isPresent()) {
            logs.unableToFindPolicy("ID");
        }
        policyRepository.deleteById(id);
        logs.policyDeletedSuccessfully("ID");
    }
}
