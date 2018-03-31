package co.simplon.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ModelEntity.SuspectModel;
import co.simplon.Repository.IRepositorySuspect;

// Ouverture du port 4200 ppour laisser accès au front
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
// @RequestMapping("/truc")
public class SuspectController {
	
	// Pour donner accès aux méthodes de l'interface
	@Autowired
	private IRepositorySuspect iRepositorySuspect;
	
	
	// Je vais ici créer mes méthodes CRUD grâce aux méthodes existantes
	// dans l'interface de JPArepository
	
	
	// méthode GET(Read) pour récupérer une liste de suspects
	//Requête: SELECT * FROM suspect;
	@GetMapping(value="/suspects")
	public List<SuspectModel> GetSuspect() {
		
		return iRepositorySuspect.findAll();
		
	}
	
	
	// méthode POST(Create) pour ajouter un suspect
	// Requête: INSERT TO `suspect` VALUES ('pseud','taille',...);
	@PostMapping(value="/ajoutSuspect") 
	public SuspectModel PostSuspect(@RequestBody SuspectModel suspect) {
		return iRepositorySuspect.save(suspect);
	}
	
	// méthode Delete (Delete) pour supprimer un suspect
	// Requête: DELETE FROM `suspect` WHERE `id` = ?;
	@DeleteMapping(value="/supprimeSuspect/{id}")
	public void DeleteSuspect(@PathVariable Long id) {
		iRepositorySuspect.deleteById(id);
	}
	
	// méthode GET(Read) pour avoir le détail d'un suspect
	// Requête SQL: SELECT FROM `suspect` WHERE id LIKE ?;
	@GetMapping(value="suspect/{id}")
	public Optional<SuspectModel> GetSuspect(@PathVariable Long id) {
		return iRepositorySuspect.findById(id);
	}
	

	//méthode PUT(Update) pour modifier un suspect
	// Requête SQL : UPDATE suspect SET pseudo = '?', taille = '?' WHERE id LIKE '?'
	@PutMapping(value="/editSuspect/{id}") 
	public SuspectModel editSuspect(@RequestBody SuspectModel suspect,@PathVariable ("id") Long id) {
		SuspectModel suspectToUpdate = iRepositorySuspect.getOne(id);
		suspectToUpdate.setPseudo(suspect.getPseudo());
		suspectToUpdate.setPhoto(suspect.getPhoto());
		suspectToUpdate.setSigneParticulier(suspect.getSigneParticulier());
		suspectToUpdate.setCouleurPeau(suspect.getCouleurPeau());
		suspectToUpdate.setCouleurCheveux(suspect.getCouleurCheveux());
		suspectToUpdate.setTaille(suspect.getTaille());
		suspectToUpdate.setAffaire(suspect.getAffaire());

		return iRepositorySuspect.save(suspectToUpdate);
	}

}
