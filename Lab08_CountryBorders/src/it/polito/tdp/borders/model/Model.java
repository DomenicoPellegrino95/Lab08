package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;




public class Model {
    
	BordersDAO bordersDAO = new BordersDAO();
	List<Country> stati;
	List<Border> confini;
	SimpleGraph<Country, DefaultEdge> grafo= new SimpleGraph<Country, DefaultEdge>(DefaultEdge.class);
	
	
	public List<Country> createGraph(int anno) { 
		stati= new ArrayList<Country>(bordersDAO.loadAllCountries());
		for(Country c:stati){
			grafo.addVertex(c);
		}
	    confini = new ArrayList<Border>(bordersDAO.getCountryPairs(anno));
	    
	    for(Border b: confini){
	    	Country c1= null;
	    	Country c2= null;
	    	for(Country s: stati) {
	    		if( s.getCCode()== b.getSate1no()){
	    			c1=s;
	    		}
	    	}
	    	for(Country s: stati) {
	    		if( s.getCCode()== b.getSate2no()){
	    			c2=s;
	    		}
	    	}
	    	grafo.addEdge(c1, c2);
	    	} 
	        
	    for (Country s:grafo.vertexSet()){
	    	s.setConfinanti(grafo.degreeOf(s));
	    }
	    
	    return stati;
			
		}
	


    public int getComponentiConnesse(){
    	ConnectivityInspector<Country, DefaultEdge> conI= new ConnectivityInspector<Country, DefaultEdge>(grafo);
    	return conI.connectedSets().size();}
    
    }
	
	



