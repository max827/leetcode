package com.company.Array;

/**
 * 买卖股票的最佳时机
 * 唉，这道题我写的相当杂乱无章，一点都不优雅，全是ifelse的堆砌而已
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int buy=-1;
        int sell=-1;
        boolean flag=false;

        if(prices.length==1){
            return 0;
        }else if(prices.length==2){
            if(prices[0]<prices[1]){
                return prices[1]-prices[0];
            }else {
                return 0;
            }

        }

        for(int i=0;i<prices.length-1;i++){


            if(prices[i]<prices[i+1] && !flag){
                buy=prices[i];
                i++;
                flag=true;
            }

            if(i==prices.length-1){
                sell=prices[i];
                maxProfit +=sell-buy;
                return maxProfit;
            }

            if(i==prices.length-2){
                if(prices[i]<prices[i+1]){
                    if(flag){
                        sell=prices[i+1];
                        maxProfit +=sell-buy;
                        return maxProfit;
                    }else {
                        maxProfit +=prices[i+1]-prices[i];
                        return maxProfit;
                    }
                }else {
                    if(flag){
                        sell=prices[i];
                        maxProfit +=sell-buy;
                        return maxProfit;
                    }else {
                        return maxProfit;
                    }
                }


            }
            if(prices[i]>prices[i+1] && flag){
                sell=prices[i];
                maxProfit +=sell-buy;
                flag=false;
            }

        }

        return maxProfit;
    }
}
