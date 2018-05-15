package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bûcheron (Woodcutter)
 * 
 * +1 Achat.
 * +2 Pièces.
 */
public class Woodcutter extends ActionCard {
	private String description;
	
	public Woodcutter() {
		super("Woodcutter",3);
		description="+1 buys, +2 pieces";
	}
	
	public void play(Player p) {
		p.incrementBuys(1);
		p.incrementMoney(2);
	}
}