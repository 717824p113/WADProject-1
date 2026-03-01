package com.insurance.dao;

import com.insurance.dao.model.Policy;
import java.util.List;

public interface PolicyDAO {
    boolean addPolicy(Policy policy);
    List<Policy> getAllPolicies();
    boolean updatePolicy(Policy policy);
    boolean deletePolicy(int policyId);
    Policy getPolicyById(int policyId);
}