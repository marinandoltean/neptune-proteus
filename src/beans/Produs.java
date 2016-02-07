package beans;

public class Produs {
	private int id;
	private String denumire;
	private int pret;
	private String categorie;
	private String imagine;
	
	public Produs()	{
		
	}
	
	public Produs(int id, String denumire, int pret, String categorie, String imagine) {
		this.id = id;
		this.denumire = denumire;
		this.pret = pret;
		this.categorie = categorie;
		this.imagine = imagine;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getImagine() {
		return imagine;
	}
	public void setImagine(String imagine) {
		this.imagine = imagine;
	}
}