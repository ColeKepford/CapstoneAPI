package com.HailMaryAPI.HailMary.Policies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/policies")
public class PolicyController {
    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping(value = "/policies/all")
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping(value = "/policies/{id}") 
    public Policy getPolicy(@PathVariable("id")Integer id) {
        return policyService.getPolicyById(id);
    }
    
    @PostMapping
    public void addNewPolicy(@RequestBody Policy policy) {
        policyService.addNewPolicy(policy);
    }
}
