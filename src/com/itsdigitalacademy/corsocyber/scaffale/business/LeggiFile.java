package com.itsdigitalacademy.corsocyber.scaffale.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

import com.itsdigitalacademy.corsocyber.scaffale.beans.Libro;
import com.itsdigitalacademy.corsocyber.scaffale.beans.RigheErrate;

public class LeggiFile {
	File fileIn;// puntamento, so solo dov'e il file, il reader invece entra nel file
	File fileOut;
	ArrayList<Libro> scaffale = new ArrayList<Libro>();
	ArrayList<RigheErrate> righeErrate = new ArrayList<RigheErrate>();

	public static Libro creaLibro(String riga) {
		Libro libro = new Libro();// creo l'stanza per poter lavorare dentro la classe libro
		String[] dati = new String[6];// solo qui lavoro sulla riga
		dati = riga.split(";");
		libro.setCodiceSocieta(dati[0]);
		libro.setdescrizioneSocietà(dati[1]);
		libro.setisbn(dati[2]);
		libro.setcheckDigit(Integer.parseInt(dati[3]));
		libro.setautore(dati[4]);
		libro.settitolo(dati[5]);

		return libro;
	}

	public static void main(String[] args) {
		LeggiFile leggiFile = new LeggiFile();
		try {
			Date inizio = new Date();
			// LeggiFile leggiFile = new LeggiFile();
			leggiFile.fileIn = new File("C:\\FORMAZIONE\\ITS_2022\\Input\\titoli_gennaio_marzo.txt");// indirizzo di
																										// casa
			FileReader reader = new FileReader(leggiFile.fileIn);// il giardiniere entra in casa mia tagliando un ciuffo
																	// alla volta
			BufferedReader bReader = new BufferedReader(reader);// qui invece usa il taglia erba

			// per tutti le righe del file

			String riga = bReader.readLine();// viene letta una rigariga = bReader.readLine();// viene letta una riga
			
			do {
				try {
					Libro libro = creaLibro(riga);
					leggiFile.scaffale.add(libro);
				} catch (Exception e) {
					RigheErrate errore = new RigheErrate();
					errore.setErrore(e.getMessage());
					errore.setRiga(riga);
					leggiFile.righeErrate.add(errore);
				} // aggiungo la riga allo scaffale
				riga = bReader.readLine();// viene letta una riga
			} while (riga != null);// finche ci sono righe
			//
			bReader.close();// crea invece una stringa //devo ricordarmi di chiudere la risorsa perche
			reader.close();// legge solo carattere per carattere //sennò può rimanere bloccata
			// -----
//			for (Libro Libro : leggiFile.scaffale) {
//				System.out.println(Libro.toString());
//			}
			System.out.println(leggiFile.scaffale.size());
			Date fine = new Date();
			Long differenza = fine.getTime() - inizio.getTime();
			System.out.println("Tempo impiegato: " + differenza);
		leggiFile.fileOut = new File ("C:\\\\FORMAZIONE\\\\ITS_2022\\\\Input\\rigaErrate");
		FileWriter write = new FileWriter(leggiFile.fileOut);
		BufferedWriter bWriter = new BufferedWriter(write);
		
		bWriter.write("Queste sono le tue righe errate ");
		bWriter.write("\n");
		for (int i = 0; i < leggiFile.righeErrate.size(); i++) {
			RigheErrate rigaErrore = leggiFile.righeErrate.get(i);
			bWriter.write(rigaErrore.getErrore() + "->" + rigaErrore.getRiga());
			bWriter.write("\n");
		}
		bWriter.close();
		write.close();
		System.out.println ("Gli errori sono nel file " + leggiFile.fileOut.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();// mi dice la riga dov e l'errore
			System.err.println("si è verificato un errore:" + e.getMessage());
			
		}
		}
}
