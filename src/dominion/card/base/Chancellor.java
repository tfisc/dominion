package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck.
 */
public class Chancellor extends ActionCard {
	private String description;
	
	public Chancellor() {
		super("Chancellor",2);
		description="+2 moneys, you may immediatly put your deck into your discard pile";
	}
	public void play(Player p) {
		p.incrementMoney(2);
		while(p.cardsInDraw().size()>0) {
			p.addDiscard(p.drawCard());
		}
	}
}