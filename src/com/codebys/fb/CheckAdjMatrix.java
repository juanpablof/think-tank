package com.codebys.fb;

import com.codebys.graphs.Node;
import com.codebys.graphs.State;

public class CheckAdjMatrix {

	private Node root;
	
	public boolean checkAdj(String adj){
	     
	    // 0 1 2 3
	    // p q m k 
	    for(int i=0; i < adj.length() -1; i++){
	    
	        char val = adj.charAt(i);
	        char adjVal = adj.charAt(i+1); 
	        
	        if(!dfs(root, val, adjVal)) return false;
	    }
	    return true;
	}


	public boolean dfs(Node root, char val, char adjVal){

	    if(root == null) return false;
	    
	    root.state = State.Visited;
	    
	    if(root.value == val){
	        
	        for(Node n : root.child){
	        
	            if(n.state == State.Unvisited){
	               
	                if(n.value == adjVal){
	                
	                    return true;
	                
	                }
	            }
	        }
	        
	        return false;
	        
	    }else { 
	    
	        for(Node n : root.child){
	        
	             dfs(n, val, adjVal);
	    
	        }
	   
	    }
	                 
	    return false;
	}
}
