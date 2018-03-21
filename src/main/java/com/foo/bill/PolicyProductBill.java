package com.foo.bill;

import java.util.List;

public class PolicyProductBill {
    private long policyProductBillId;
    private long premium;
    private PolicyProduct policyProduct;

    public PolicyProductBill(long policyProductBillId, long premium, PolicyProduct policyProduct) {
        this.policyProductBillId = policyProductBillId;
        this.premium = premium;
        this.policyProduct = policyProduct;
    }

    public double calculateCommission() {
        List<CommissionRateItem> rateItemList = policyProduct.getCommissionRate().getCommissionRateList();
        double result = 0;
        int index = getCurrentPremiumIndexOf(rateItemList);

        for (int i = 0; i < index; i++) {
            double previousMaxPremium = getPreviousMaxPremium(rateItemList, i);
            double currentMaxPremium = rateItemList.get(i).getMaxPremium();
            double currentRate = rateItemList.get(i).getRate();

            result = result + (currentMaxPremium - previousMaxPremium) * currentRate;
        }

        long lastMaxPremium = getPreviousMaxPremium(rateItemList, index);
        result = result + (premium - lastMaxPremium) * rateItemList.get(index).getRate();

        return result;
    }

    private long getPreviousMaxPremium(List<CommissionRateItem> rateItemList, int index) {
        return index > 0 ? rateItemList.get(index - 1).getMaxPremium() : 0;
    }

    private int getCurrentPremiumIndexOf(List<CommissionRateItem> rateItemList) {
        for (int i = 0; i < rateItemList.size(); i++) {
            if (premium <= rateItemList.get(i).getMaxPremium()) {
                return i;
            }
        }

        return 0;
    }
}
