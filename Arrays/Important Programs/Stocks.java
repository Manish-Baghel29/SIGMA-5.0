public class Stocks {
    public static int maximumProfit(int arr[]){
        int buyPrice=Integer.MAX_VALUE;
        int globalProfit=0;
        for(int i=0;i<arr.length;i++){
            if(buyPrice<arr[i]){
                int profit=arr[i]-buyPrice;
                globalProfit=Math.max(profit, globalProfit);
            }
            else{
                buyPrice=arr[i];
            }
        }
        return globalProfit;
    }
    public static void main(String[] args) {
        int prices[]={7,1,3,4,6,5};
        System.out.println(maximumProfit(prices));
    }
}
