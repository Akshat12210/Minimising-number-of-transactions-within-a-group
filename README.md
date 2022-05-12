# Minimising-number-of-transactions-withing-a-group
#Problem Statemment
In a group of people sometimes one person pays some bills, another person pays some other bills. It is very difficult to manage these bills and to tell how much a person owes and how much he needs to give and to minimise the number of transactions.

#Solution
Steps taken to solve this problem :- 
 1. Create an adjacency matrix that holds the information regarding who owes how much money to whom.
 2. Calculate the net amount for each member. Subtracting the total of all debts from the total of all credits gives the net amount for that member.
 3. Find the two people that have the most credit and the most debt.
 4. Find the minimum from both the values of max credit and max debt after getting the minimum value. Now the debt person pays this amount to the creditor and settles the transaction.
