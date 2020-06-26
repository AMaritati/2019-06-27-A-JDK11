package it.polito.tdp.crimes.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	private Graph<String, DefaultWeightedEdge> grafo;
	EventsDao dao;
	
	public Model() {
		dao = new EventsDao();
	}
	
	public List<String> returnCategories(){
		return dao.listAllCategories();
	}
	
	public List<Integer> listAllYears(){
		return dao.listAllYears();
	}
	
	public void creaGrafo (String categoria , Integer anno) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, dao.listVertices(categoria, anno));
		
		for(Adiacenza a : dao.listAdiacenze(categoria, anno)) {
			if(a.getPeso()>0) {
				Graphs.addEdge(this.grafo, a.getA(), a.getB(),a.getPeso());
			}
		}
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public int pesoMax(String cat, Integer year) {
		int p = 0;
		for (Adiacenza a : dao.listAdiacenze(cat, year)) {
			if (a.getPeso()>p) {
				p = a.getPeso();
			}
		}
		return p;
	}
	public List<Adiacenza> adiacenzeMax(int peso,String cat, Integer year){
		List<Adiacenza> ad = new ArrayList<>();
		for(Adiacenza a : dao.listAdiacenze(cat, year)) {
			if(a.getPeso()==peso) {
				ad.add(a);
			}
		}
		return ad;
	}
}
