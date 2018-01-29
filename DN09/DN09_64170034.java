/**
*
* Copyright 2017, Lan Zukanovic, All rights reserved.
* 
*
*/
import java.util.*;

class DN09_64170034{

	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);

		ArrayList<Delo> dela=new ArrayList<Delo>();

		String glAvtor=sc.next();
		int stObjav=sc.nextInt();

		for(int objava=0;objava<stObjav;objava++){
			String vrstaObjave=sc.next();

			switch(vrstaObjave){
				case "monografija":

					int stAvtorjev=sc.nextInt();
					String[] avtorji=new String[stAvtorjev];
					for(int i=0;i<stAvtorjev;i++){
						avtorji[i]=sc.next();
					}
					String naslov=sc.next();
					String zalozba=sc.next();
					int liz=sc.nextInt();
					String ISBN=sc.next();

					Monografija m=new Monografija(stAvtorjev,avtorji,naslov,zalozba,liz,ISBN);
					dela.add(m);

					break;

				case "referat":

					int stAvtorjev2=sc.nextInt();
					String[] avtorji2=new String[stAvtorjev2];
					for(int i=0;i<stAvtorjev2;i++){
						avtorji2[i]=sc.next();
					}
					String naslov2=sc.next();
					String imeKonferece=sc.next();
					boolean vrstaKonf=sc.nextBoolean();
					int zacStran=sc.nextInt();
					int konStran=sc.nextInt();

					Referat r=new Referat(stAvtorjev2,avtorji2,naslov2,imeKonferece,vrstaKonf,zacStran,konStran);
					dela.add(r);
					break;

				case "clanek":

					int stAvtorjev3=sc.nextInt();
					String[] avtorji3=new String[stAvtorjev3];
					for(int i=0;i<stAvtorjev3;i++){
						avtorji3[i]=sc.next();
					}
					String naslov3=sc.next();
					String naziv=sc.next();
					int letnik=sc.nextInt();
					int stevilka=sc.nextInt();
					int letoIzdaje=sc.nextInt();
					int mesto=sc.nextInt();
					int stRevij=sc.nextInt();
					int zacStran2=sc.nextInt();
					int konStran2=sc.nextInt();

					Clanek c=new Clanek(stAvtorjev3,avtorji3,naslov3,naziv,letnik,stevilka,letoIzdaje,mesto,stRevij,zacStran2,konStran2);
					dela.add(c);
					break;
			}
		}

		int iMax=0;
		for(int iz=0;iz<stObjav;iz++){
			for(int j=0;j<dela.size();j++){
				if(dela.get(j).vrniTocke() > dela.get(iMax).vrniTocke()){
					iMax=j;
				}
			}
			dela.get(iMax).izpisi(glAvtor);
			dela.remove(iMax);
			iMax=0;
		}
	}


// ~~~~~~Objekti~~~~~~~~
	private static abstract class Delo{

		 int stAvtorjev;
		 String[] avtorji;
		 String naslov;

		 abstract double vrniTocke();
		 abstract void izpisi(String glavniAvtor);
	}

	private static class Monografija extends Delo{

		private String zalozba;
		private int letoIzdaje;
		private String ISBN;
		private double tocke;
		private String lepeTocke;

		public Monografija(int stAvtorjev,String[] avt, String naslov, String zalozba, int liz, String ISBN){
			this.stAvtorjev=stAvtorjev;
			this.avtorji=new String[stAvtorjev];
			for(int i=0;i<avt.length;i++){
				avtorji[i]=avt[i];
			}
			this.naslov=naslov;
			this.zalozba=zalozba;
			this.letoIzdaje=liz;
			this.ISBN=ISBN;
			this.tocke=vrniTocke();
			this.lepeTocke=vrniLepeTocke(this.tocke);
		}

		public double vrniTocke(){
			return 10.0/this.stAvtorjev;
		}

		public String vrniLepeTocke(double tocke){
			if(tocke%1==0) return ""+(int)Math.floor(tocke);
			int celo=(int)Math.floor(tocke);
			double ostanek=tocke%1;
			double toleranca=1.0E-10;
			double stevec1=1, stevec2=0;
			double imenovalec1=0, imenovalec2=1;
			double temp=ostanek;
			
			while(Math.abs(ostanek-stevec1/imenovalec1)>ostanek*toleranca){
				double cel=Math.floor(temp);
				double xx=stevec1;
				stevec1=cel*stevec1+stevec2;
				stevec2=xx;
				xx=imenovalec1;
				imenovalec1=cel*imenovalec1+imenovalec2;
				imenovalec2=xx;
				temp=1/(temp-cel);
			}

			return celo+"+"+(int)stevec1+"/"+(int)imenovalec1;
		}

		public void izpisi(String glavniAvtor){

			String[] kopija=new String[this.stAvtorjev];
			for(int i=0;i<this.stAvtorjev;i++){
				if(this.avtorji[i].equals("#")){
					kopija[i]=glavniAvtor;
				}else{
					kopija[i]=this.avtorji[i];
				}

			}
			String vsiAvtorji=String.join(", ",kopija);
			System.out.printf("%s: %s. %s %d, ISBN %s | %s%n",vsiAvtorji,this.naslov,this.zalozba,this.letoIzdaje,
																this.ISBN,this.lepeTocke);
		}

	}


	private static class Referat extends Delo{

		private String konferenca;
		private boolean vrstaKonf;
		private int zacStran;
		private int konStran;
		private double tocke;
		private String lepeTocke;

		public Referat(int stAvtorjev,String[] avt, String naslov, String konfa, boolean vk, int zac, int kon){
			this.stAvtorjev=stAvtorjev;
			avtorji=new String[stAvtorjev];
			for(int i=0;i<avt.length;i++){
				avtorji[i]=avt[i];
			}
			this.naslov=naslov;
			this.konferenca=konfa;
			this.vrstaKonf=vk;
			this.zacStran=zac;
			this.konStran=kon;
			this.tocke=vrniTocke();
			this.lepeTocke=vrniLepeTocke(this.tocke);
		}

		public double vrniTocke(){
			if(this.vrstaKonf) return 3.0/this.stAvtorjev;
			return 1.0/this.stAvtorjev;
		}

		public String vrniLepeTocke(double tocke){
			if(tocke%1==0) return ""+(int)Math.floor(tocke);
			int celo=(int)Math.floor(tocke);
			double ostanek=tocke%1;
			double toleranca=1.0E-10;
			double stevec1=1, stevec2=0;
			double imenovalec1=0, imenovalec2=1;
			double temp=ostanek;
			while(Math.abs(ostanek-stevec1/imenovalec1)>ostanek*toleranca){
				double cel=Math.floor(temp);
				double xx=stevec1;
				stevec1=cel*stevec1+stevec2;
				stevec2=xx;
				xx=imenovalec1;
				imenovalec1=cel*imenovalec1+imenovalec2;
				imenovalec2=xx;
				temp=1/(temp-cel);
			}

			return celo+"+"+(int)stevec1+"/"+(int)imenovalec1;
		}

		public void izpisi(String glavniAvtor){
			
			String[] kopija=new String[this.stAvtorjev];
			for(int i=0;i<this.stAvtorjev;i++){
				if(this.avtorji[i].equals("#")){
					kopija[i]=glavniAvtor;
				}else{
					kopija[i]=this.avtorji[i];
				}

			}
			String vsiAvtorji=String.join(", ",kopija);
			System.out.printf("%s: %s. %s: %d-%d | %s%n",vsiAvtorji,this.naslov,this.konferenca,
																	this.zacStran,this.konStran,this.lepeTocke);
		}
	}

	private static class Clanek extends Delo{

		private String naziv;
		private int letnik;
		private int stevilka;
		private int letoIzdaje;
		private int mesto;
		private int stRevij;
		private int zacStran;
		private int konStran;

		private double tocke;
		private String lepeTocke;

		public Clanek(int stAvtorjev, String[] avt, String naslov, String naziv, int letnik, 
						int st, int letoIz, int mesto, int stRevij, int zacStran, int konStran) {

			this.stAvtorjev=stAvtorjev;
			avtorji=new String[stAvtorjev];
			for(int i=0;i<avt.length;i++){
				avtorji[i]=avt[i];
			}
			this.naslov=naslov;
			this.naziv=naziv;
			this.letnik=letnik;
			this.stevilka=st;
			this.letoIzdaje=letoIz;
			this.mesto=mesto;
			this.stRevij=stRevij;
			this.zacStran=zacStran;
			this.konStran=konStran;
			this.tocke=vrniTocke();
			this.lepeTocke=vrniLepeTocke(this.tocke);
		}

		public double vrniTocke(){
			double p=(this.mesto*1.0)/this.stRevij;
			if(p>0 && p<=1.0/4) {return 10.0/this.stAvtorjev;}
			else if(p>1.0/4 && p<=1.0/2) {return 8.0/this.stAvtorjev;}
			else if(p>1.0/2 && p<=3.0/4) {return 6.0/this.stAvtorjev;}
			else if(p>3.0/4 && p<=1) {return 4.0/this.stAvtorjev;}
			else {return 2.0/this.stAvtorjev;}
		}

		public String vrniLepeTocke(double tocke){
			if(tocke%1==0) return ""+(int)Math.floor(tocke);
			int celo=(int)Math.floor(tocke);
			double ostanek=tocke%1;
			double toleranca=1.0E-10;
			double stevec1=1, stevec2=0;
			double imenovalec1=0, imenovalec2=1;
			double temp=ostanek;
			while(Math.abs(ostanek-stevec1/imenovalec1)>ostanek*toleranca){
				double cel=Math.floor(temp);
				double xx=stevec1;
				stevec1=cel*stevec1+stevec2;
				stevec2=xx;
				xx=imenovalec1;
				imenovalec1=cel*imenovalec1+imenovalec2;
				imenovalec2=xx;
				temp=1/(temp-cel);
			}

			return celo+"+"+(int)stevec1+"/"+(int)imenovalec1;
		}

		public void izpisi(String glavniAvtor){
			
			String[] kopija=new String[this.stAvtorjev];
			for(int i=0;i<this.stAvtorjev;i++){
				if(this.avtorji[i].equals("#")){
					kopija[i]=glavniAvtor;
				}else{
					kopija[i]=this.avtorji[i];
				}

			}
			String vsiAvtorji=String.join(", ",kopija);
			System.out.printf("%s: %s. %s %d(%d): %d-%d (%d) | %s%n",vsiAvtorji,this.naslov,this.naziv,this.letnik,
																		this.stevilka,this.zacStran,this.konStran,
																		this.letoIzdaje,this.lepeTocke);
		}
	}
}