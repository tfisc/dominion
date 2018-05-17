package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
//pas complet
/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {
	
	String description;
	
	public Moneylender() {
		super("Moneylender",4);
		this.description="Trash a Copper card from your hand. If you do, +3";
	}
	
	public void play(Player p) {
		
		int i = 0;
		boolean ok=false;
		
		while(i<p.getTreasureCards().size() && ok==false){
			if(p.getTreasureCards().get(i).getName().equals("Copper")){ //si la carte est une carte cuivre
				p.removeHand(p.getTreasureCards().get(i).getName()); //supprime la carte sélectionnée de la main du joueur
				p.incrementMoney(3); //rajoute 3 pièces au joueur
				ok = true;
			}
			
			i++;
		}
	}
}