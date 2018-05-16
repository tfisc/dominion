package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {
	private String description;
	
	public Bureaucrat() {
		super("Bureaucrat",4);
		description="Tous vos adversaires dévoilent une carte Victoire et la placent "
				+ "sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire)";
	}
		public void play (Player p) {
			int i=0;
			String carte;
			p.addDraw(p.getGame().removeFromSupply("Silver"));
			
			while(i<p.getGame().otherPlayers(p).size()) {
				if(p.getGame().otherPlayers(p).get(i).getVictoryCards().size()!=0){
					p.getGame().otherPlayers(p).get(i).addDraw(p.getGame().otherPlayers(p).get(i).getVictoryCards().get(1));
					carte=p.getGame().otherPlayers(p).get(i).getVictoryCards().get(1).getName();
					p.getGame().otherPlayers(p).get(i).removeHand(carte);
				}
				i++;

				
				
		}
	} 
}
	
