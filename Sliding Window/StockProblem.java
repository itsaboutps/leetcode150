
public class StockProblem {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};

        // T : O(n)
        // S : O(1)
        twoPointerSOlution(prices);
    }

    private static void twoPointerSOlution(int[] prices) {
        int l =0; //buy pointer
        int r = 1; // sell pointer
        int maxProfit = 0;

        // so as soon as we will see the loss we have to update the left pointer

        while(r<prices.length){
            if(prices[l]<prices[r]){
                //PROFIT
                maxProfit = Math.max(maxProfit,prices[r]-prices[l]);
                r+=1;

            }else if(prices[l]>=prices[r]){
                //LOSS
                l+=1;
                r+=1;
            }
        }
        System.out.println("Max Profit is ==> "+ maxProfit);
    }
}
