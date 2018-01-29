// 64170034
/**
*
* Copyright 2017, Lan Zukanovic, All rights reserved.
* 
*
*/

public class Skladovnica{

	private int kapacitetaPrvega;
	private int prirast;
	public int doZdej;
	public int[] tabSkatel;

	public Skladovnica(int kapacitetaPrvega, int prirast){
		this.kapacitetaPrvega=kapacitetaPrvega;
		this.prirast=prirast;
	}

	public int kapacitetaKupa(int kup){
		int zac2=this.kapacitetaPrvega;
		int poveciZa=this.prirast;
		tabSkatel=new int[kup];

		tabSkatel[0]=zac2;

		for(int i=1;i<=kup;i++){
			tabSkatel[i-1]=zac2+(i-1)*poveciZa;
		}
		int kapKup=tabSkatel[kup-1];

		return kapKup;
	}

	public void dodaj(int stSkatel){
		doZdej+=stSkatel;
		
	}

	public int skupnoSteviloSkatel(){
		return doZdej;
	}

	public int zasedenostKupa(int kup){
		int temp2=0;
		int odstej=0;

		//ce je kup=1
		if(kup==1){
			if(doZdej>kapacitetaKupa(kup)){return kapacitetaKupa(kup);}
			else{return doZdej;}
		}

		else{
			int temp=doZdej-kapacitetaKupa(kup-1);
			for(int i=kup-3;i>=0;i--){
				temp=temp-kapacitetaKupa(i+1);
			}
			
			if(temp<0){return 0;}
			else{
				if(temp<kapacitetaKupa(kup)){return temp;}
				else{return kapacitetaKupa(kup);}
			}
		}
	}

	public boolean odvzemi(int stSkatel){
		if(doZdej-stSkatel>=0){
			doZdej-=stSkatel;
			return true;
		}else{return false;}
	}

	public int poisciKup(int skatla){
		int sestej=kapacitetaKupa(1);
		if(skatla<kapacitetaKupa(1)){return 1;}
		else{
			int i=2;
			if(skatla<=doZdej){
				do{
					sestej+=kapacitetaKupa(i);
					if(sestej>=skatla){return i;}
					i++;
				}while(skatla>kapacitetaKupa(i-1));
			}else{return -1;}

			// nisem se znal tega znebit!
			return 0;
		}
	}

	public Skladovnica prestavi(int kapacitetaPrvega, int prirast){

		Skladovnica nov=new Skladovnica(kapacitetaPrvega,prirast);
		nov.dodaj(doZdej);
		this.odvzemi(doZdej);
		return nov;
	}
}