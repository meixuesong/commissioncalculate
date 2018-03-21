# Readme

This is a sample project which will demostrate how TDD applied to real business.

# Tasking

1. domain: calculate commission without bonus
1.1 Billmoney = 0 -> commission = 0
1.2 Billmoney = 5000 -> commission = 5000 * 5%
1.3 Billmoney = 10001 -> commission = 10000 * 5% + 1 * 6%
1.4 Billmoney = 20001 -> commission =  10000 * 5% + 10000 * 6% + 1 * 10%

2. provide api to calculate commission
2.1 implement api (without DB): 
2.2 implement api (read from DB)

3. calculate bonus
3.1 Commission > 2500, bonus = commission * 1%
3.1 Commission > 2500, bonus = 50 (fixed)


