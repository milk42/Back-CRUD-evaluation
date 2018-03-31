package co.simplon.ModelEntity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


// Avec Hibernate (JPA), après avoir créer une base de données dans sql du même
// nom que dans le fichier application properties avec les informations de connexion
// à la bdd, cette technologie est capable de créer ma ou mes tables dans la base.

// Pour cela, nous ajouterons des annotations
// ici, pour préciser à JPA que c'est un model
@Entity
// Que ce model sera celui d'une table
@Table(name = "suspect")
public class SuspectModel implements Serializable{
	
	
	// Les attributs représentent les colonnes de la table
	// Précise que c'est la clé primaire id
	@Id
	// s'incrémente automatiquement
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// Pour préciser le nombre de caractère maximum pour ce champ
	@Column(length=40)
	private String pseudo;
	private String photo;
	private String signeParticulier;
	@Column(length=15)
	private String couleurPeau;
	@Column(length=15)
	private String couleurCheveux;
	@Column(length=10)
	private String taille;
	
	// Pour définir la relation avec la table affaire
	@ManyToOne
	// clé étrangère
	@JoinColumn(name="id_affaire")
	@JsonIgnore
	private AffaireModel affaire;
	
	
	//Getters Setters
	
	public AffaireModel getAffaire() {
		return affaire;
	}
	public void setAffaire(AffaireModel affaire) {
		this.affaire = affaire;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSigneParticulier() {
		return signeParticulier;
	}
	public void setSigneParticulier(String signeParticulier) {
		this.signeParticulier = signeParticulier;
	}
	public String getCouleurPeau() {
		return couleurPeau;
	}
	public void setCouleurPeau(String couleurPeau) {
		this.couleurPeau = couleurPeau;
	}
	public String getCouleurCheveux() {
		return couleurCheveux;
	}
	public void setCouleurCheveux(String couleurCheveux) {
		this.couleurCheveux = couleurCheveux;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}

	
	

}
