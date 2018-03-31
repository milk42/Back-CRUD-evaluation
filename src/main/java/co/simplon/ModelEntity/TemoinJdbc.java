package co.simplon.ModelEntity;

public class TemoinJdbc {
	
	private int id;
	private String temoignage;
	private String nom;
	
	
	public TemoinJdbc(int id, String temoignage, String nom) {
		super();
		this.id = id;
		this.temoignage = temoignage;
		this.nom = nom;
	}


	public TemoinJdbc() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTemoignage() {
		return temoignage;
	}


	public void setTemoignage(String temoignage) {
		this.temoignage = temoignage;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	

	
}
