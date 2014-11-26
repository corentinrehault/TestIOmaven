package fr.macie.TestIOmaven.service;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import fr.macie.TestIOmaven.main.Conteneur;

public class Ecriture {

	public static void EcritureFichiers() throws IOException, FileNotFoundException {

		DataOutputStream listeComplete;
		DataOutputStream ver;
		DataOutputStream alpha;
		DataOutputStream nbreLettres;
		
		Iterator<String> parcoursMots = Conteneur.listDeMot.iterator();
		Iterator<String> parcoursVer = Conteneur.listVer.iterator();
		Iterator<Entry<String, Integer>> parcoursAlpha = Conteneur.listPremiereLettre.entrySet().iterator();
		Iterator<Entry<Integer, Integer>> parcoursNbreLettres = Conteneur.listNbreLettres.entrySet().iterator();

		String nextLine = System.getProperty("line.separator");

		listeComplete = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(ScannerTexte.titre + ".txt"))));
		while (parcoursMots.hasNext()) {
			String mot = parcoursMots.next();
			listeComplete.writeBytes(mot + nextLine);
		}
		listeComplete.close();

		ver = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("mots_en_ver.txt"))));
		while (parcoursVer.hasNext()) {
			String mot = parcoursVer.next();
			ver.writeBytes(mot + nextLine);
		}
		ver.close();

		alpha = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("mots_par_lettre.txt"))));	
		while (parcoursAlpha.hasNext()) {
			Entry<String, Integer> valeur = parcoursAlpha.next();
			alpha.writeBytes(valeur.getKey() + " : " + valeur.getValue() + " mots." + nextLine);
		}
		alpha.close();

		nbreLettres = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("nombre_de_lettres.txt"))));
		while (parcoursNbreLettres.hasNext()) {
			Entry<Integer, Integer> valeur2 = parcoursNbreLettres.next();
			nbreLettres.writeBytes(valeur2.getKey() + " : " + valeur2.getValue() + " mots." + nextLine);
		}
		nbreLettres.close();

	}

}
