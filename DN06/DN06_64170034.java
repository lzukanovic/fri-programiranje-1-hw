/**
*
* Copyright 2017, Lan Zukanovic, All rights reserved.
* 
*
*/
import java.util.Scanner;
import java.util.Arrays;

class DN06_64170034{

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int stVrstic=sc.nextInt();
		int stStolpcev=sc.nextInt();
		int stZnamenitosti=sc.nextInt();
		int[][] koordinateZnamenitosti=new int[stZnamenitosti][2];

		for(int i=0;i<stVrstic;i++){
			for(int j=0;j<stStolpcev;j++){
				int polje=sc.nextInt();
				if(polje>0){
					// koordinate zapise v tabelo glede na to kera znamenitost je po vrsti
					koordinateZnamenitosti[polje-1][0]=i; //x
					koordinateZnamenitosti[polje-1][1]=j; //y
				}
			}
		}
		// razdlaja od (0,0) do prve znamenitosti
		int razdalja=Math.abs(koordinateZnamenitosti[0][0])+Math.abs(koordinateZnamenitosti[0][1]);

		for(int i=1;i<stZnamenitosti;i++){
			razdalja+=Math.abs(koordinateZnamenitosti[i][0]-koordinateZnamenitosti[i-1][0])+Math.abs(koordinateZnamenitosti[i][1]-koordinateZnamenitosti[i-1][1]);
		}
		System.out.println(razdalja);
	}
}