package com.foo.bill;

import com.foo.bill.domain.CommissionRate;
import com.foo.bill.domain.CommissionRateItem;
import com.foo.bill.domain.PolicyProduct;
import com.foo.bill.domain.PolicyProductBill;
import com.foo.bill.domain.PolicyProductBillRepsitory;
import com.foo.bill.repository.PolicyProductBillRepsitoryImpl;
import com.foo.bill.service.CommissionCalculateService;
import com.foo.bill.service.CommissionCalculateServiceImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommissionCalculateServiceTest {
    private PolicyProductBillRepsitory repsitory;

    @Test
    public void should_return_commission_when_given_policy_product_bill_id() throws Exception {
        //Given
        Long policyProductBillId = 121224124L;
        repsitory = mock(PolicyProductBillRepsitoryImpl.class);
        PolicyProductBill policyProductBill = getPolicyProductBill();
        when(repsitory.findById(anyLong())).thenReturn(policyProductBill);
        CommissionCalculateService commissionCalculateService = new CommissionCalculateServiceImpl(repsitory);

        //When
        double result = commissionCalculateService.calculate(policyProductBillId);

        //Then
        assertEquals(500.06D, result, 0.001D);
    }

    private PolicyProductBill getPolicyProductBill() {
        CommissionRate commissionRate;
        PolicyProduct policyProduct = new PolicyProduct();

        List<CommissionRateItem> commissionRateList = Arrays.asList(
                new CommissionRateItem(10000, 0.05),
                new CommissionRateItem(20000, 0.06),
                new CommissionRateItem(Long.MAX_VALUE, 0.10)
        );

        commissionRate = new CommissionRate(commissionRateList);
        policyProduct.setCommissionRate(commissionRate);

        return new PolicyProductBill(12323L, 10001L, policyProduct);
    }
}
