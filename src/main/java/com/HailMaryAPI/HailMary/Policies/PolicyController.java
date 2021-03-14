package com.HailMaryAPI.HailMary.Policies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/policies")
public class PolicyController {
    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping(value = "/all")
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping(value = "/{email}")
    public List<Policy> getPoliciesByEmail(@PathVariable("email") String email) {
      return policyService.getAllPoliciesByEmail(email);
    }

    
    @GetMapping(value = "/{id}") 
    public Policy getPolicy(@PathVariable("id")Integer id) {
        return policyService.getPolicyById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePolicy(@PathVariable("id") int id) {
        policyService.deletePolicyById(id);
    } 
    @PostMapping
    public void addNewPolicy(@RequestBody Policy policy) {
        policyService.addNewPolicy(policy);
    }
    
}
