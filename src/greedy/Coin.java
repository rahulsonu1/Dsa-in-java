package greedy;


import java.util.Arrays;

public class Coin {

	public static void main(String[] args) {
		int coin[]= {186,419,83,408};
		int money=6249;
		System.out.println(change(coin, money));
 	}
	public static int change(int coins[],int amount) {
		if(amount==0){
	           return 0;
	       }
	       Arrays.sort(coins);
	       int count=0;
	       for(int i=coins.length-1;i>=0;i--){
	           if(amount>=coins[i]){
	               amount=amount-coins[i];
	               i++;
	               count++;
	           }
	       }
//	       if(amount!=0){
//	           return -1;
//	       }
	       return count;
	    }
	}

