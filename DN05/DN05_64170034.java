/**
*
* Copyright 2017, Lan Zukanovic, All rights reserved.
* 
*
*/
import java.util.Scanner;
import java.util.Arrays;
class DN05_64170034{
	
	static Scanner sc=new Scanner(System.in);

	static int stPosesti=sc.nextInt();
	static int zapPosesti=sc.nextInt();
	static int cenaVSkupini=sc.nextInt();
	static int stIgralcev=sc.nextInt();
	static int zacetniDenar=sc.nextInt();
	static int stMetovKocke=sc.nextInt();

	static int[] polozaj=new int[stIgralcev];
	static int[] denar=new int[stIgralcev];
	static int[] igralnoPolje=new int[stPosesti];

	static boolean aliJe;

	public static void main(String[] args){

		// dodeljevanje zacetnega denarja
		for(int i=0;i<denar.length;i++){
			denar[i]=zacetniDenar;
		}

		// priprava igralnega polja
		for(int i=0;i<igralnoPolje.length;i++){
			igralnoPolje[i]=(-1);
		}

		// ***SIMULACIJA IGRE***
		int naVrsti=0;
		for(int i=0;i<stMetovKocke;i++){

			// ***RAZLASTITEV POSESTI
			for(int b=0;b<denar.length;b++){
				if(denar[b]<0){
					bankrotPosesti(b);
				}
			}
			// ***PREMIKANJE
			int metKocke = sc.nextInt();
			while(denar[naVrsti]<0){
				naVrsti++;
				if(naVrsti>=stIgralcev){naVrsti=0;}
			}
				polozaj[naVrsti] = pomik(metKocke,naVrsti);
				
			// ***PLACEVANJE
			if(igralnoPolje[polozaj[naVrsti]]==-1 && denar[naVrsti]>=cenaVSkupini){
				igralnoPolje[polozaj[naVrsti]]=naVrsti;
				denar[naVrsti]-=cenaVSkupini;
			}
			else{
				for(int j=0;j<stIgralcev;j++){
					if(igralnoPolje[polozaj[naVrsti]]==j && denar[naVrsti]>=0 && naVrsti!=j){
						int najemnina=1;
						najemnina=stPosestiVSkupini(polozaj[naVrsti],j);
						denar[naVrsti]-=najemnina;
						if(denar[naVrsti]>=0 && denar[j]>=0){
							denar[j]+=najemnina;
						}
					}
				}
			}
			// preveri, ce je ostal samo 1 igralec, ki ni bankrotiral
			if(aliKonec()){break;}

			naVrsti++;
			if(naVrsti>=stIgralcev){naVrsti=0;}
		}

		// ***REZULTAT***
		for(int i=0;i<polozaj.length;i++){
			if(denar[i]>=0){
				System.out.printf("%d %d%n",polozaj[i],denar[i]);
			}else{
				System.out.printf("%d bankrot%n",polozaj[i]);
			}
		}
	}

	public static int pomik(int metKocke, int naVrsti){
		if(metKocke+polozaj[naVrsti] <= stPosesti-1){
			return polozaj[naVrsti]+=metKocke;
		}
		else{
			if((metKocke+polozaj[naVrsti])%stPosesti==0){
				return 0;
			}
			else{
				return metKocke+polozaj[naVrsti]-stPosesti;
			}
		}
	}

	public static boolean aliKonec(){
		int stevec=0;
		for(int i=0;i<denar.length;i++){
			if(denar[i]>=0){
				stevec++;
			}
		}
		if(stevec==1){return true;}
		else{return false;}
	}

	public static void bankrotPosesti(int ixIgralec){
		for(int i=0;i<igralnoPolje.length;i++){
			if(igralnoPolje[i]==ixIgralec){
				igralnoPolje[i]=-1;
			}
		}
	}

	public static int stPosestiVSkupini(int ixNahaja, int lastnik){
		int stevecParcel=0;
		for(int i=0;i<=igralnoPolje.length;i+=zapPosesti){
			if(ixNahaja+1 <= i+zapPosesti && ixNahaja+1 > i){
				for(int j=i;j<i+zapPosesti ;j++){
					if(igralnoPolje[j]==lastnik){
						stevecParcel++;
					}
				}
			}
		}
		return stevecParcel;
	}
}