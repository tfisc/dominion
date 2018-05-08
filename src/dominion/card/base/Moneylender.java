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
		super("MoneyLender",4);
		this.description="Trash a Copper card from your hand. If you do, +3";
	}
	
	public void play(Player p, Game g) {
	}
}