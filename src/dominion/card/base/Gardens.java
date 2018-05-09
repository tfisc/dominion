package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Jardins (Gardens)
 * 
 * Vaut 1VP pour chaque 10 cartes dans votre deck (arrondi à l'unité inférieure).
 */
public class Gardens extends VictoryCard {
	private String description;
	
	public Gardens(){
		super("Gardens",4);
		description="Worth 1 pv for each 10 cards in your deck (rounded down)";
	}
	
	
	public int VictoryValue(Player p){
		return p.totalCards().size()/10;
	}
	
	public void play(Player p) {
		 
		
	}
}