package com.foo.bill.service;

import com.foo.bill.domain.PolicyProductBill;

public class CommissionCalculateServiceImpl implements CommissionCalculateService {
    private PolicyProductBillRepsitory policyProductBillRepsitory;

    public CommissionCalculateServiceImpl(PolicyProductBillRepsitory policyProductBillRepsitory) {
        this.policyProductBillRepsitory = policyProductBillRepsitory;
    }

    public double calculate(Long policyProductBillId) {
        PolicyProductBill policyProductBill = policyProductBillRepsitory.findById(policyProductBillId);

        return policyProductBill.calculateCommission();
    }
}
