package com.itsdigitalacademy.corsocyber.scaffale.beans;

public class Libro{
	//javabean
	private String codiceSocieta;
	private String descrizioneSocieta;
	private String isbn;
	private int checkDigit;
	private String autore;
	private String titolo;

	public void setCodiceSocieta(String newVal){
		this.codiceSocieta=newVal;
	}

	public String getCodiceSocieta(){
		return this.codiceSocieta;
	}
	
	public void setdescrizioneSocietà(String newVal){
		this.descrizioneSocieta=newVal;
	}

	public String getdescrizioneSocieta(){
		return this.descrizioneSocieta;
	}
	
	public void setisbn(String newVal){
		this.isbn=newVal;
	}

	public String getisbn(){
		return this.isbn;
	}
	public void setcheckDigit(int newVal){
		this.checkDigit=newVal;
	}

	public int getcheckDigit(){
		return this.checkDigit;
	}
	public void setautore(String newVal){
		this.autore=newVal;
	}

	public String getautore(){
		return this.autore;
	}
	public void settitolo(String newVal){
		this.titolo=newVal;
	}

	public String gettitolo(){
		return this.titolo;
	}
	
	
	
	
	@Override
	public String toString(){
		return codiceSocieta+';'+ descrizioneSocieta+';'+isbn+';'+checkDigit+';'+autore+';'+ titolo;
		}

	}
