// 64170034
/**
*
* Copyright 2017, Lan Zukanovic, All rights reserved.
* 
*
*/
public class Oddaja {
	
	public static abstract class Lik{

		abstract boolean aliJe(int x, int y);
	}

	public static class Pravokotnik extends Lik {

		private int xLevo, yZgoraj, sirina, visina;

		public Pravokotnik(int xLevo, int yZgoraj, int sirina, int visina){
			this.xLevo=xLevo;
			this.yZgoraj=yZgoraj;
			this.sirina=sirina;
			this.visina=visina;
		}

		public boolean aliJe(int x, int y){
			return (x-this.xLevo>=0 && x-this.xLevo<this.sirina && y-this.yZgoraj>=0 && y-this.yZgoraj<this.visina);
		}
	}

	public static class Elipsa extends Lik {
		
		private int xSredisce, ySredisce, vodoravnaPolos, navpicnaPolos;

		public Elipsa(int xSredisce, int ySredisce, int vodoravnaPolos, int navpicnaPolos){
			this.xSredisce=xSredisce;
			this.ySredisce=ySredisce;
			this.vodoravnaPolos=vodoravnaPolos;
			this.navpicnaPolos=navpicnaPolos;
		}

		public boolean aliJe(int x, int y){
			return Math.pow(x-this.xSredisce,2)*Math.pow(this.navpicnaPolos,2) + 
					Math.pow(y-this.ySredisce,2)*Math.pow(this.vodoravnaPolos,2) <= 
					Math.pow(this.vodoravnaPolos,2)*Math.pow(this.navpicnaPolos,2);
		}
	}


	public static class Mnogokotnik extends Lik {
		
		private int[][] omejitve;

		public Mnogokotnik(int[][] omejitve){
			this.omejitve=omejitve;
		}

		public boolean aliJe(int x, int y){
			int stevecPogojev=0;
			for(int i=0;i<this.omejitve.length;i++){
				if(this.omejitve[i][0]*x + this.omejitve[i][1]*y + this.omejitve[i][2] <= 0) stevecPogojev++;
			}
			return stevecPogojev==omejitve.length;
		}
	}

	public static class Presek extends Lik {
		
		private Lik prvi, drugi;

		public Presek(Lik prvi, Lik drugi){
			this.prvi=prvi;
			this.drugi=drugi;
		}

		public boolean aliJe(int x, int y){
			return prvi.aliJe(x,y)==true && drugi.aliJe(x,y)==true;
		}
	}

	public static class Razlika extends Lik {
		
		private Lik prvi, drugi;

		public Razlika(Lik prvi, Lik drugi){
			this.prvi=prvi;
			this.drugi=drugi;
		}

		public boolean aliJe(int x, int y){
			return prvi.aliJe(x,y)==true && drugi.aliJe(x,y)==false;
		}
	}


	public static class Risar{
		
		private boolean[][] mreza;

		public Risar(){
			this.mreza=new boolean[100][100];
		}

		public void narisiLik(Lik lik){

			for(int i=0;i<mreza.length;i++){
				for(int j=0;j<mreza[i].length;j++){
					if(lik.aliJe(j,i)){
						this.mreza[i][j]=true;
					}
				}
			}
		}

		public void narisiRob(Lik lik, int debelina){

			for(int i=0;i<mreza.length;i++){
				for(int j=0;j<mreza[i].length;j++){
					if(lik.aliJe(j,i) && 
						(lik.aliJe(j-1,i)==false || lik.aliJe(j,i-1)==false ||
						 lik.aliJe(j+1,i)==false || lik.aliJe(j,i+1)==false)){
						this.mreza[i][j]=true;
					}
				}
			}
		}

		public boolean[][] slika(){
			return this.mreza;
		}
	}
}