package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	// Methode GET
	@RequestMapping(value = "/villes", method = RequestMethod.GET)
	@ResponseBody
	public List<Ville> appelGet() {
		System.out.println("Appel GET");

		List<Ville> ville = villeBLOService.getInfoVilles();

		return ville;
	}
	
	// Methode GET
		@RequestMapping(value = "/ville", method = RequestMethod.GET)
		@ResponseBody
		public Ville ville(@RequestParam(value= "code_postal") String code_postal) {
			System.out.println("Appel GET");

			Ville ville = villeBLOService.getInfoVille(code_postal);

			return ville;
		}
		
		@GetMapping("trouver")
		public List<Ville> trouver(@RequestParam(name="codeCommune", defaultValue="") String codeCommune){
			Ville ville = new Ville();
			ville.setCode_commune_INSEE(codeCommune);
			return villeBLOService.trouverVilles(ville);
		}
		
	// Methode POST
		@PostMapping("create")
		public void CreerVille(@RequestBody Ville nouvelleVille) {
			villeBLOService.creerVille(nouvelleVille);
		}
		
		@PutMapping("update/{codeCommune}")
		public void modifier(@RequestBody Ville villeModif, @PathVariable("codeCommune") String codeCommune) {
			villeBLOService.modifierVille(villeModif, codeCommune);
		}
		
		@DeleteMapping("/delete/{codeCommune}")
		public void supprimer(@PathVariable("codeCommune") String codeCommuneINSEE) {
			villeBLOService.supprimerVille(codeCommuneINSEE);
		}
}
