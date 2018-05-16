package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
//complet
/**
 * Carte Forgeron (Smithy)
 * 
 * +3 Cartes.
 */
public class Smithy extends ActionCard {
	
	String description;
	
	public Smithy() {
		super("Smithy",4);
		this.description="+3 Cards";
	}
	
	public void play(Player p) {
		
		p.addHand(p.drawCard());
		p.addHand(p.drawCard());
		p.addHand(p.drawCard());
		
	}
}