/**
*
* Copyright 2017, Lan Zukanovic, All rights reserved.
* 
*
*/
import java.util.Scanner;

class DN07_64170034 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int velikost=sc.nextInt();
		int[][] tabelaKvad=new int[velikost][velikost];
		int stEnk=0;
		int stKvad=0;

		for (int i=0; i<tabelaKvad.length; i++) {
			for (int j=0; j<tabelaKvad[i].length; j++) {
				tabelaKvad[i][j]=sc.nextInt();
				if(tabelaKvad[i][j] == 1) {stEnk++;}
			}
		}

		for (int i=0; i<tabelaKvad.length; i++) {
			for (int j=0; j<tabelaKvad[i].length; j++) {
				if(tabelaKvad[i][j] == 1){
					stKvad+=aliKvad(tabelaKvad,i,j);
				}
			}
		}
		System.out.println(stEnk+stKvad);
	}

	public static int aliKvad(int[][] tab,int x, int y){
		int kvad=0;
		int temp=0;
		int liha=3;
		if(tab[x].length-y>1 && tab.length-x>1){
			for (int k=1; k<tab[x].length-y && k<tab.length-x; k++) {
				if(tab[x][y+k]==1 && tab[x+k][y]==1){
					for(int i=1;i<=k;i++){
						for(int j=1;j<=k;j++){
							if(tab[x+i][y+j]==1){
								temp++;
							}
						}
					}
					if(temp == ((k+1)*(k+1))-liha) { kvad++; }	
					temp=0;
					liha+=2;
				}
			}
		}
		return kvad;
	}
}