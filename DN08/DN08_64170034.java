/**
*
* Copyright 2017, Lan Zukanovic, All rights reserved.
* 
*
*/
import java.util.*;

class DN08_64170034{
	
	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);
		int pozObr=sc.nextInt();
		int negObr=sc.nextInt();
		int stUkazov=sc.nextInt();

		ArrayList<Racun> uporabniki= new ArrayList<Racun>();

		int obrestP=0;
		int obrestN=0;

		for(int i=0;i<stUkazov;i++){

			char ukaz = sc.next().charAt(0);

			switch(ukaz){
				case 'r':
					int dan=sc.nextInt();
					int mesec=sc.nextInt();
					int leto=sc.nextInt();
					String naziv=sc.next();
					int N=sc.nextInt();
					int D=sc.nextInt();
					int M=sc.nextInt();

					Racun r=new Racun(dan, mesec, leto, naziv, N, D, M);
					uporabniki.add(r);
					System.out.println("OK");
					break;

				case '+':
					int danP=sc.nextInt();
					int mesecP=sc.nextInt();
					int letoP=sc.nextInt();
					String nazivP=sc.next();
					int dodano=sc.nextInt();

					for(int u=0;u<uporabniki.size();u++){


						if(uporabniki.get(u).naziv.equals(nazivP)){
							
							// reset, ce pride do spremembe dneva ali meseca
							if(danP!=uporabniki.get(u).danDodan){
								uporabniki.get(u).danDoZdej=0;
							}

							if(mesecP!=uporabniki.get(u).mesecDodan){
								uporabniki.get(u).mesecDoZdej=0;
							}

							// ~~~~~POZITIVNO STANJE~~~~~
							if(uporabniki.get(u).stanje>=0){


								// stevilo mesecev
								int razLeto=letoP-uporabniki.get(u).letoDodan;
								int razMes=razLeto*12+mesecP-uporabniki.get(u).mesecDodan;

								int kopijaStanja=uporabniki.get(u).stanje;

								// obresti
								for(int obresti=0; obresti<razMes;obresti++){
									obrestP=(int)Math.floor((kopijaStanja*pozObr)/1000);
									kopijaStanja+=obrestP;
								}
								obrestP=kopijaStanja-uporabniki.get(u).stanje;
								
								// pristevek obresti in njihov reset 
								uporabniki.get(u).stanje+=obrestP;
								obrestP=0;

								// stanju pristejemo kar uporabnik nalozi gor na racun
								uporabniki.get(u).stanje+=dodano;
								System.out.println(uporabniki.get(u).stanje);

								// zapisemo mesec in leto, ko je bilo nazadnje osvezeno
								uporabniki.get(u).danDodan=danP;
								uporabniki.get(u).mesecDodan=mesecP;
								uporabniki.get(u).letoDodan=letoP;
							}
							// ~~~~~NEGATIVNO STANJE~~~~~
							else{

								// stevilo mesecev
								int razLeto=letoP-uporabniki.get(u).letoDodan;
								int razMes=razLeto*12+mesecP-uporabniki.get(u).mesecDodan;

								int kopijaStanja=uporabniki.get(u).stanje;

								// obresti
								for(int obresti=0; obresti<razMes;obresti++){
									obrestP=-1*(int)Math.floor((-1*kopijaStanja*negObr)/1000);
									kopijaStanja+=obrestP;
								}
								obrestP=kopijaStanja-uporabniki.get(u).stanje;

								// pristevek obresti in njihov reset 
								uporabniki.get(u).stanje+=obrestP;
								obrestP=0;

								// stanju pristejemo kar uporabnik nalozi gor na racu
								uporabniki.get(u).stanje+=dodano;
								System.out.println(uporabniki.get(u).stanje);

								// zapisemo mesec in leto, ko je bilo nazadnje osvezeno
								uporabniki.get(u).danDodan=danP;
								uporabniki.get(u).mesecDodan=mesecP;
								uporabniki.get(u).letoDodan=letoP;
							}
						}
					}
					break;

				case '-':
					int danM=sc.nextInt();
					int mesecM=sc.nextInt();
					int letoM=sc.nextInt();
					String nazivM=sc.next();
					int odvzel=sc.nextInt();


					for(int u=0;u<uporabniki.size();u++){

						if(uporabniki.get(u).naziv.equals(nazivM)){

							// ~~~~~NEGATIVNO STANJE~~~~~
							if(uporabniki.get(u).stanje<0){

								// stevilo mesecev
								int razLeto=letoM-uporabniki.get(u).letoDodan;
								int razMes=razLeto*12+mesecM-uporabniki.get(u).mesecDodan;

								int kopijaStanja=uporabniki.get(u).stanje;

								// obresti
								for(int obresti=0; obresti<razMes;obresti++){
									obrestN=-1*(int)Math.floor((-1*kopijaStanja*negObr)/1000);
									kopijaStanja+=obrestN;
								}
								obrestN=kopijaStanja-uporabniki.get(u).stanje;
							}

							// ~~~~~POZITIVNO STANJE~~~~~
							else{

								// stevilo mesecev
								int razLeto=letoM-uporabniki.get(u).letoDodan;
								int razMes=razLeto*12+mesecM-uporabniki.get(u).mesecDodan;

								int kopijaStanja=uporabniki.get(u).stanje;

								// obresti
								for(int obresti=0; obresti<razMes;obresti++){
									obrestN=(int)Math.floor((kopijaStanja*pozObr)/1000);
									kopijaStanja+=obrestN;
								}
								obrestN=kopijaStanja-uporabniki.get(u).stanje;
							}

							// ~~~~~~~~~~~~~1. nivo~~~~~~~~~~
							if((uporabniki.get(u).maxMin == -1) || !(uporabniki.get(u).stanje-odvzel < -1*uporabniki.get(u).maxMin)){

								// ~~~~~~~~~~2. nivo~~~~~~~~~~
								if(danM!=uporabniki.get(u).danDodan){
									uporabniki.get(u).danDoZdej=0;
								}

								if(odvzel+uporabniki.get(u).danDoZdej<=uporabniki.get(u).maxDan || uporabniki.get(u).maxDan == -1){
									uporabniki.get(u).danDoZdej+=odvzel;
									if(uporabniki.get(u).danDoZdej>uporabniki.get(u).maxDan){uporabniki.get(u).danDoZdej=0;}
										
										// ~~~~~~~~~~3. nivo~~~~~~~~~~~~
										if(mesecM!=uporabniki.get(u).mesecDodan){
											uporabniki.get(u).mesecDoZdej=0;
										}

										if(odvzel+uporabniki.get(u).mesecDoZdej<=uporabniki.get(u).maxMes || uporabniki.get(u).maxMes == -1){
											uporabniki.get(u).mesecDoZdej+=odvzel;
											if(uporabniki.get(u).mesecDoZdej>uporabniki.get(u).maxMes){uporabniki.get(u).mesecDoZdej=0;}

											uporabniki.get(u).stanje-=odvzel;

											uporabniki.get(u).stanje+=obrestN;
											obrestN=0;
											
											uporabniki.get(u).danDodan=danM;
											uporabniki.get(u).mesecDodan=mesecM;
											uporabniki.get(u).letoDodan=letoM;

											System.out.println(uporabniki.get(u).stanje);
										}
										else{
											System.out.println("M");
										}
								}
								else{
									System.out.println("D");
								}
							}
							else{
								System.out.println("N");
							}
						}
					}
					break;
			}
		}
	}

	public static class Racun{

		private int dan;
		private int mesec;
		private int leto;
		private String naziv;
		private int stanje;
		private int maxMin;
		private int maxDan;
		private int maxMes;

		private int danDoZdej;
		private int mesecDoZdej;

		private int danDodan;
		private int mesecDodan;
		private int letoDodan;

		public Racun(int dan, int mesec, int leto, String naziv, int N, int D, int M){
			this.dan=dan;
			this.mesec=mesec;
			this.leto=leto;
			this.naziv=naziv;
			this.maxMin=N;
			this.maxDan=D;
			this.maxMes=M;
			this.stanje=0;

			this.danDoZdej=0;
			this.mesecDoZdej=0;

			this.danDodan=dan;
			this.mesecDodan=mesec;
			this.letoDodan=leto;
		}
	}
}