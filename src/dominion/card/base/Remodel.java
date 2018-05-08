package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
//pas complet
/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {
	
	String description;
	
	public Remodel() {
		super("Remodel",4);
		this.description="Trash a card from your hand. Gain a card costing up to 2 more than the trashed card.";
	}
	
	public void play(Player p, Game g) {
	}
}