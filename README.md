MaxStockPrice
=============

Program to find year, month in which stock price were high.
Steps involved are:
1. read the content of csv file line by line.
2. for the first line store the company name alongwith null values and initialize maxArr and company array with the lenth value.
3. from next line onwards store month and year value into a string and initialize maxArr array with value.
4. read and compare value of stock price for every company and compare with maxArr for that company.
5. if the read value is higher than previous max then update maxArr content and map as well 
6. at the end we will have a map which has company name alongwith its month year in which it has maximum share price.
