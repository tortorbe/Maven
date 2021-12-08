package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville> getInfoVilles() {
		ArrayList<Ville> ville;
		
		ville = villeDAO.findAllVilles();
		return ville;
	}
	
	public ArrayList<Ville> trouverVilles(Ville villes){
		ArrayList<Ville> ville;
		
		ville = villeDAO.trouverVilles(villes);
		return ville;
	}
	
	public Ville getInfoVille(String name) {
		Ville ville;
		
		ville = villeDAO.findVille(name);
		return ville;
	}
	
	public void creerVille(Ville ville) {
		villeDAO.creerVille(ville);
	}
	
	public void supprimerVille(String codeville) {
		villeDAO.supprimerVille(codeville);
	}
	
	public void modifierVille(Ville ville, String code) {
		villeDAO.modifierVille(ville,code);
	}

}