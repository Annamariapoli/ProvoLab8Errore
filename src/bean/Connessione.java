package bean;

public class Connessione {
	private int id_connessione;
	private int id_linea;
	private int id_staP;
	private int id_staA;
	
	
	private Linea linea;
	
	
	
	public Linea getLinea() {
		return linea;
	}
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	
	
	public Connessione(int id_connessione, int id_linea, int id_staP, int id_staA) {
		super();
		this.id_connessione = id_connessione;
		this.id_linea = id_linea;
		this.id_staP = id_staP;
		this.id_staA = id_staA;
	}
	public int getId_connessione() {
		return id_connessione;
	}
	public void setId_connessione(int id_connessione) {
		this.id_connessione = id_connessione;
	}
	public int getId_linea() {
		return id_linea;
	}
	public void setId_linea(int id_linea) {
		this.id_linea = id_linea;
	}
	public int getId_staP() {
		return id_staP;
	}
	public void setId_staP(int id_staP) {
		this.id_staP = id_staP;
	}
	public int getId_staA() {
		return id_staA;
	}
	public void setId_staA(int id_staA) {
		this.id_staA = id_staA;
	}
	
	
}
