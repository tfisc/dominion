package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
//complet
/**
 * Carte Marché (Market)
 * 
 * +1 Carte.
 * +1 Action.
 * +1 Achat.
 * +1 Pièce.
 */
public class Market extends ActionCard {
	
	String description;
	
	public Market(String name, int cost, String descr) {
		super(name,cost);
		this.description = descr;
	}
	
	public void play(Player p) {
		p.drawCard();
		p.incrementActions(1);
		p.incrementBuys(1);
		p.incrementMoney(1);
	}
}