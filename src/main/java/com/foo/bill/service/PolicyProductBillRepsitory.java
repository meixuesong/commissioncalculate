package com.foo.bill.service;

import com.foo.bill.domain.PolicyProductBill;

public interface PolicyProductBillRepsitory {
    PolicyProductBill findById(Long policyProductBillId);
}
