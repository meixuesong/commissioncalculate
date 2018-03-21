package com.foo.bill.repository;

import com.foo.bill.domain.PolicyProductBill;
import com.foo.bill.service.PolicyProductBillRepsitory;

//职责：从DB读取相应的数据，转换成domain model
public class PolicyProductBillRepsitoryImpl implements PolicyProductBillRepsitory {

    public PolicyProductBill findById(Long policyProductBillId) {

        return null;
    }
}
