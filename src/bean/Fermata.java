package bean;

public class Fermata {

	private int id_fermata;
	private String nome;
	private double coordX;
	private double coordY;
	public Fermata(int id_fermata, String nome, double coordX, double coordY) {
		super();
		this.id_fermata = id_fermata;
		this.nome = nome;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	public int getId_fermata() {
		return id_fermata;
	}
	public void setId_fermata(int id_fermata) {
		this.id_fermata = id_fermata;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCoordX() {
		return coordX;
	}
	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}
	public double getCoordY() {
		return coordY;
	}
	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}
	
	
	public String toString(){
		String r ;
		r = id_fermata+" "+nome+" \n";
		return r;
	}
	
}
