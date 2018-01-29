
/**
*
* Copyright 2017, Lan Zukanovic, All rights reserved.
* 
*
*/


import java.util.Scanner;
class DN02 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int stParov = sc.nextInt();
		int ukaz = sc.nextInt();
		int stevecParov = 0;

		for(int i=0;i<stParov;i++){
			int par1 = sc.nextInt();
			int par2 = sc.nextInt();

			if(ukaz == 1){
				if(par1<par2){
					stevecParov++;
				}
			}

			if(ukaz == 2){
				if((par1%10) == (par2%10)){
					stevecParov++;
				}
			}

			int prva1=par1; //ni potrebno, ampak vseeno
			int prva2=par2;
			if(ukaz == 3){
				while(prva1>9 || prva1<-9){
					prva1/=10;
				}
				while(prva2>9 || prva2<-9){
					prva2/=10;
				}
				if(prva1 == prva2){
					stevecParov++;
				}
			}

			if(ukaz == 4){
				stevecParov += aliPermutacija(par1,par2);
			}
		}
		System.out.println(stevecParov);
	}

	public static int aliPermutacija(int par1, int par2){
		int dolzina1=0;
		int dolzina2=0;
		int tempPar1=par1;
		int tempPar2=par2;
		int tempPar22=par2;
		int stevecPopravek=0;
		int eliminacija=0;

		while(par1!=0){
			par1/=10;
			dolzina1++;
		}
		while(par2!=0){
			par2/=10;
			dolzina2++;
		}

		if(dolzina1==dolzina2){
			if(tempPar1!=tempPar2){
				if(dolzina1!=1){
					int potenca=1;

					while(tempPar1>0){
						int zadnji1=tempPar1%10;
						tempPar1=tempPar1/10;

						while(tempPar2>0){
							int zadnji2=tempPar2%10;
							tempPar2/=10;

							if(zadnji1==zadnji2){	// sistem eliminacije najdenih stevk			
								eliminacija=(((tempPar22/potenca)-zadnji2)*potenca+(tempPar22%potenca));
								tempPar22=eliminacija;
								break;
							}
							else{ // <POPRAVLJENO> bug ko se zadnja stevka prvega para ne najde takoj
								stevecPopravek++;
								if(stevecPopravek==dolzina1){return 0;}
							}
							potenca*=10;
						}

						tempPar2=eliminacija;
						potenca=1;
						stevecPopravek=0;
					}

					if(eliminacija==0){return 1;}
					else{return 0;}
				}
				else{return 0;}
			}
			else{return 1;}
		}
		else{return 0;}
	}
}
