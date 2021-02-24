package com.HailMaryAPI.HailMary.Policies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service
public class PolicyService {
    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public List<Policy> getAllPoliciesByEmail(String email) {
        Optional<List<Policy>> policiesOptional = policyRepository.findPoliciesByEmail(email);
        policyRepository.findPoliciesByEmail(email);
        if(policiesOptional.isPresent()) {
            List<Policy> policies = policiesOptional.get();
            return policies;
        }
        throw new IllegalStateException("No policies under that email");
    }

        public List<Policy> findByName(String first_name, String last_name) {
            Optional<List<Policy>> policiesOptional = policyRepository.findByName(first_name, last_name);
            
            if(policiesOptional.isPresent()) {
                List<Policy> policies = policiesOptional.get();
                return policies;
            }
        throw new IllegalStateException("No policies under that name");
    }

    public Policy getPolicyById(int id) {
        boolean exists = policyRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Client doesn't exist");
        }
        return policyRepository.getOne(id);
    }

    public void addNewPolicy(Policy policy) {
        Optional<Policy> policyOptional = policyRepository.findById(policy.getPolicy_id());
        if(policyOptional.isPresent()) {
            throw new IllegalStateException("Policy with that ID already exists");
        }
        policyRepository.save(policy);
    }
}
