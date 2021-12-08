package com.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.dto.Ville;
@Repository
public interface VilleDAO {
	
	public ArrayList<Ville> findAllVilles();
	
	public Ville findVille(String name);
	
	public void creerVille(Ville ville);
	
	public void supprimerVille(String codeville);
	
	public void modifierVille(Ville ville, String codecommu);
	
	public ArrayList<Ville> trouverVilles(Ville ville);

}
