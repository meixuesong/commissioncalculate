package com.foo.bill;

import com.foo.bill.domain.CommissionRate;
import com.foo.bill.domain.CommissionRateItem;
import com.foo.bill.domain.PolicyProduct;
import com.foo.bill.domain.PolicyProductBill;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PolicyProductBillTest {

    private CommissionRate commissionRate;
    private PolicyProduct policyProduct;

    @Before
    public void setUp() throws Exception {
        policyProduct = new PolicyProduct();

        List<CommissionRateItem> commissionRateList = Arrays.asList(
            new CommissionRateItem(10000, 0.05),
            new CommissionRateItem(20000, 0.06),
            new CommissionRateItem(Long.MAX_VALUE, 0.10)
        );

        commissionRate = new CommissionRate(commissionRateList);
        policyProduct.setCommissionRate(commissionRate);
    }

    @Test
    public void should_return_0_commission_when_bill_money_is_0() throws Exception {
        PolicyProductBill policyProductBill = new PolicyProductBill(12323L, 0L, policyProduct);

        double result = policyProductBill.calculateCommission();

        assertEquals(0, result, 0.001);
    }

    @Test
    public void should_return_250_commission_when_bill_money_is_5000() throws Exception {
        PolicyProductBill policyProductBill = new PolicyProductBill(12323L, 5000L, policyProduct);

        double result = policyProductBill.calculateCommission();

        assertEquals(250, result, 0.001);
    }

    @Test
    public void should_return_500_06_commission_when_bill_money_is_10001() throws Exception {
        PolicyProductBill policyProductBill = new PolicyProductBill(12323L, 10001L, policyProduct);

        double result = policyProductBill.calculateCommission();

        assertEquals(500.06, result, 0.01);
    }

    @Test
    public void should_return_1100_1_commission_when_bill_money_is_20001() throws Exception {
        PolicyProductBill policyProductBill = new PolicyProductBill(12323L, 20001L, policyProduct);

        double result = policyProductBill.calculateCommission();

        assertEquals(1100.1, result, 0.01);
    }

}
