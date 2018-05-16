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
	
	public Market() {
		super("Market",5);
		this.description = "+1 Card,+1 Action,+1 Buy,+1 Money";
	}
	
	public void play(Player p) {
		p.addHand(p.drawCard());
		p.incrementActions(1);
		p.incrementBuys(1);
		p.incrementMoney(1);
	}
}