package application;

import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import bean.Connessione;
import bean.Fermata;
import db.Dao;

public class Model {
	
	private Dao dao= new Dao();
	private SimpleWeightedGraph<Fermata, DefaultWeightedEdge> grafo ;

	public List<Fermata > getAllF(){
		List<Fermata> all= dao.getAllF();
		return all;
	}
	
	public List<Connessione> getAllC(){
		List<Connessione> all= dao.getAllConnessioni();
		return all;
	}
	
//	public double getTempo(Fermata f1, Fermata f2){
//		double tempo =-1;
//		if(f1!= null && f2!=null){
//			List<Connessione> conness = getAllC();
//			for(Connessione c : conness){
//				if(c.getId_staA()==f1.getId_fermata() && c.getId_staP()==f2.getId_fermata()){
//					LatLng c1 = new LatLng(f1.getCoordX(), f2.getCoordY());
//				    LatLng c2 = new LatLng (f2.getCoordX(), f2.getCoordY());
//				    double distanza = LatLngTool.distance(c1,  c2,  LengthUnit.KILOMETER);
//				    double velocitaLinea = c.getLinea().getVelocita();
//				    tempo = distanza / velocitaLinea;
//				    }
//			  }
//		 }
//		return tempo;
//	}
//	
	
	
	public double calcolaDistanza(Fermata f1 , Fermata f2){
		double distanza =0;
		if(f1!=null && f2!=null){
			LatLng c1 = new LatLng(f1.getCoordX(), f2.getCoordY());
		    LatLng c2 = new LatLng (f2.getCoordX(), f2.getCoordY());
		    distanza = LatLngTool.distance(c1,  c2,  LengthUnit.KILOMETER);
		  
		}
		return distanza;
	}
	
	public void buildGraph(){   //errore riga 71
		grafo = new SimpleWeightedGraph<Fermata, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo,  getAllF());          // vertici = fermate
		for(Connessione c : getAllC()){
			for(Fermata f1 : grafo.vertexSet()){
				for(Fermata f2 : grafo.vertexSet()){
					if(!f1.equals(f2)){
						if(  f1.getId_fermata()==c.getId_staA()     &&       f2.getId_fermata()==c.getId_staP()){
							double distanza = calcolaDistanza(f1, f2);
							double velocita = c.getLinea().getVelocita();
							double tempo = distanza/velocita;
							Graphs.addEdge(grafo, f1, f2, tempo);
						}
					}
				}
			}
		}
		System.out.println(grafo.toString());
	}
	
	
	public static void main(String [] args){
		Model m = new Model();
		m.buildGraph();
	}
	
}
