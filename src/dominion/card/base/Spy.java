package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
//pas complet
/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {
	
	String description;
	
	public Spy() {
		super("Spy",4);
		this.description="+1 Card, +1 Action ; Each player(including you) reveals the top card of his deck and either discards it or puls it back, your choice.";
	}
	
	public void play(Player p,Game g) {
		p.drawCard(1);
		p.incrementActions(1);	
	}
}