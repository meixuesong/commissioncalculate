package com.foo.bill.domain;

public class CommissionRateItem {
    private long maxPremium;
    private double rate;

    public CommissionRateItem(long maxPremium, double rate) {
        this.maxPremium = maxPremium;
        this.rate = rate;
    }

    public long getMaxPremium() {
        return maxPremium;
    }

    public double getRate() {
        return rate;
    }
}
