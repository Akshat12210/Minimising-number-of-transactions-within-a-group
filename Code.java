package Codes;
import java.util.*;
/*
 * Steps taken to solve this problem :- 
 * 1. Create a adjacency matrix which holds the information regarding who 
 * 	  owes how much money to whom
 * 2. Calculate the net amount for each member. 
 *    Subtracting the total of all debts from the total of all 
 *    credits gives the net amount for that member.
 * 3. Find the two people that have the most credit and the most debt.
 * 4. Find the minimum from both the values of max credit and max debt after 
 * 	  getting minimum value. Now the debt person pays this amount to the creditor
 *    and settle the transaction.
 */
class MinimumTransaction{
	//initialising matrix -> adjacency matrix and N -> number of person/vertices in the graph 
	static int[][] matrix;
	static int N;
	
	MinimumTransaction(int[][] graph){
		//assigning values
		matrix=graph;
		N=graph.length;
	}
	
	  static void mintransactions()
	    {
	       //Create a amount array which will store the net amount of each person
	        int amount[]=new int[N];
	     
	        /*
	         * We calculate net amount to be paid by the member by 
	         * subtracting his debts from his credits and storing that value
	         * in amount array.
	         */
	        for (int m = 0; m < N; m++)
	        for (int i = 0; i < N; i++)
	            amount[m] += (matrix[i][m] - matrix[m][i]);
	     
	        /*
	         * After calculating the net amount now we will check 
	         * which transactions are required to be made
	         */
	        transaction(amount);
	    }
	 
	 static void transaction(int amount[])
	    {
	        /*
	         * Now we will find the index of minimum and maximum values in
	         * amount array.
	         * maxCredit denotes the index of maximum value in amount array 
	         * and its value (amount[maxCredit]) denotes the maximum
	         * amount to be given to any member.
	         */
	        int maxCredit = getMaxIndex(amount);
	        
	        /*
	         * maxDebit denotes the index of minimum value in amount array 
	         * and its value (amount[minDebit]) denotes the maximum
	         * amount to be taken from any member.
	         */
	        int maxDebit = getMinIndex(amount);
	     
	        /*
	         * If both are zero, all balances have been cleared.
	         */
	        if (amount[maxCredit] == 0 && amount[maxDebit] == 0)
	            return;
	     
	        //Minimum of maxDebt and max Credit
	        int min = Math.min(-amount[maxDebit], amount[maxCredit]);
	        amount[maxCredit] -= min;
	        amount[maxDebit] += min;
	     
	        //Printing the transaction which needs to be done
	        System.out.println("Person "+(char)(65+maxDebit) + " please pay " + min
	                                + "$ to " + "Person "+(char)(65+maxCredit));
	     
	        //Again calling the transaction function until all balances have been cleared.
	        transaction(amount);
	    }
	 

	 /*
	  * getMinIndex() -> function to calculate the index of maximum debt
	  */
	 static int getMinIndex(int arr[])
	    {
	        int minInd = 0;
	        for (int i = 1; i < N; i++)
	            if (arr[i] < arr[minInd])
	                minInd = i;
	        return minInd;
	    }
	 /*
	  * getMaxIndex() -> function to calculate the index of maximum credit
	  */
	static int getMaxIndex(int arr[])
	    {
	        int maxInd = 0;
	        for (int i = 1; i < N; i++)
	            if (arr[i] > arr[maxInd])
	                maxInd = i;
	        return maxInd;
	    }
	     
	 
	   
}
public class Code {
	/*
	 * This class is runner class in the main function we will take input and
	 * pass the values to Minimum Transaction class which will tell us the
	 * final transactions to be made.  
	 */
	
	
	
	public static void main(String[] args) {
		//scanner class to take input from user
		Scanner sc=new Scanner(System.in);
		
		System.out.println("######### Welcome #########");
		// n will store the size of group
		System.out.println("Enter the number of people in group :");
		int n=sc.nextInt();
		
		/*
		 * This graph will stores the data that who owes how much money 
		 * and to whom. For example A owes 20$ to B so A represents index 0
		 * and B represents index 1 so we will create adjacency matrix 
		 * as per the input given
		 */
		int[][] graph=new int[n][n];
		
		//we are currently naming person with characters from A-Z
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				if(i!=j) {
				System.out.println("Enter the amount "+ (char)(65+i) + " owes to "+(char)(65+j));
				graph[i][j]=sc.nextInt();
				}
			}
		}
		/*
		 * Creating a object of Minimum Transaction class and passing the 
		 * adjacency matrix
		 */
		MinimumTransaction m=new MinimumTransaction(graph);
		System.out.println("#####################");
		System.out.println("Only these transactions need to be made :");
		System.out.println("#####################");
		/*
		 * mintransactions function will print the minimum transaction 
		 * which need to carried out
		 */
		m.mintransactions();

	}

}
