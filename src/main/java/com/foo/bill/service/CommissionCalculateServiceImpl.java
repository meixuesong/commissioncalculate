package com.foo.bill.service;

import com.foo.bill.domain.PolicyProductBill;

public class CommissionCalculateServiceImpl implements CommissionCalculateService {
    private com.foo.bill.domain.PolicyProductBillRepsitory policyProductBillRepsitory;

    public CommissionCalculateServiceImpl(com.foo.bill.domain.PolicyProductBillRepsitory policyProductBillRepsitory) {
        this.policyProductBillRepsitory = policyProductBillRepsitory;
    }

    public double calculate(Long policyProductBillId) {
        PolicyProductBill policyProductBill = policyProductBillRepsitory.findById(policyProductBillId);

        return policyProductBill.calculateCommission();
    }
}
