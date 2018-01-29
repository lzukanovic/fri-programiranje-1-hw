/**
*
* Copyright 2017, Lan Zukanovic, All rights reserved.
* 
*
*/
import java.util.Scanner;
class DN03_64170034{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		long p=sc.nextLong();
		long k=sc.nextLong();

		long nov=p;
		int del=0;

		while(del<k){
			del=del+vrniDeljivost(nov,p);
			nov+=p;
		}

		System.out.println(nov-p);
	}

	public static int vrniDeljivost(long nov,long p){
		int zaKok=0;
		while(nov%p==0){
			nov/=p;
			zaKok++;
		}
		return zaKok;
	}
}