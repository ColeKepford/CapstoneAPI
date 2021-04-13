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
            logs.policyRetrievedSuccessfully("Policies for " + email + " were retrieved successfully");
            return policies;
        }
        this.logs.unableToFindPolicy("No policies found for " + email);
        return null;
    }

    public List<Policy> getAllPoliciesByClientId(int id) {
      Optional<List<Policy>> policiesOptional = policyRepository.findPoliciesByClientId(id);
      if(policiesOptional.isPresent()) {
          List<Policy> policies = policiesOptional.get();
          logs.policyRetrievedSuccessfully("Policies for client " + id + " were retrieved successfully");
          return policies;
      }
      this.logs.unableToFindPolicy("No policies found for client " + id);
      return null;
  }

        public List<Policy> findByName(String first_name, String last_name) {
            Optional<List<Policy>> policiesOptional = policyRepository.findByName(first_name, last_name);
            
            if(policiesOptional.isPresent()) {
                List<Policy> policies = policiesOptional.get();
                logs.policyRetrievedSuccessfully("Policies for " + first_name + " " + last_name + " were retrieved successfully");
                return policies;
            }
        this.logs.unableToFindPolicy("No policies found for "  + first_name + " " + last_name);
        return null;
    }

    public Policy getPolicyById(int id) {
        boolean exists = policyRepository.existsById(id);
        if(!exists) {
            logs.unableToFindPolicy("Unable to find the policy with id: " + id);
        }
        logs.policyRetrievedSuccessfully("Policy with id: " + id + " was retrieved");
        return policyRepository.getOne(id);
    }

    public void addNewPolicy(Policy policy) {
        Optional<Policy> policyOptional = policyRepository.findById(policy.getPolicy_id());
        if(policyOptional.isPresent()) {
            logs.policyExists("Policy " + policy.getPolicy_id() + " already exsists");
        }
        logs.policyAddedSuccessfully("Policy was successfully added");
        policyRepository.save(policy);
    }

    public void updatePolicy(Policy policy) {
      Optional<Policy> policyOptional = policyRepository.findById(policy.getPolicy_id());
        if(policyOptional.isPresent()) {
            policyRepository.save(policy);
            logs.updateSuccessful("Policy: " + policy.getPolicy_id() + " was successfully updated");
        }else {
          logs.unableToUpdatePolicy("Unable to update" + "Policy\n" + policy.toString());
        }
    }

    public void deletePolicy(Policy policy) {
        Optional<Policy> policyOptional = policyRepository.findById(policy.getPolicy_id());
        if(!policyOptional.isPresent()) {
            logs.unableToFindPolicy("Policy " + policy.getPolicy_id() + " does not exsist");
        }
        policyRepository.delete(policy);
        logs.policyDeletedSuccessfully("Policy " + policy.getPolicy_id() + " was deleted");
    }

    public void deletePolicyById(int id) {
        Optional<Policy> policyOptional = policyRepository.findById(id);
        if(policyOptional.isPresent()) {
            logs.unableToFindPolicy("Policy " + id + " does not exsist");
        }
        policyRepository.deleteById(id);
        logs.policyDeletedSuccessfully("Policy " + id + " was deleted");
    }
}
