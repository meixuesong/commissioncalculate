package com.foo.bill;

import java.util.List;

public class CommissionRate {
    private List<CommissionRateItem> commissionRateList;

    public CommissionRate(List<CommissionRateItem> commissionRateList) {
        this.commissionRateList = commissionRateList;
    }

    public List<CommissionRateItem> getCommissionRateList() {
        return commissionRateList;
    }
}
