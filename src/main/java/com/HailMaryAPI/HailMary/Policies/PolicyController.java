package com.HailMaryAPI.HailMary.Policies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping(value = "/policies")
=======
@RequestMapping("/policies")
>>>>>>> ac43441a6ab671669c2d61c81e20bae59b143faf
@CrossOrigin(origins="http://localhost:3000")
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

    @GetMapping(value = "/email:{email}")
    public List<Policy> getPoliciesByEmail(@PathVariable("email") String email) {
      return policyService.getAllPoliciesByEmail(email);
    }

    @GetMapping(value = "/clientId:{id}")
    public List<Policy> getPoliciesByClientId(@PathVariable("id") int id) {
      return policyService.getAllPoliciesByClientId(id);
    }

    @GetMapping(value = "/id:{id}") 
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
