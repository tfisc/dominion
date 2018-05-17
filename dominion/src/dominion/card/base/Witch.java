package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Sorcière (Witch)
 * 
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends AttackCard {
	
	private String description;
	
	public Witch() {
		super("Witch",5);
		description="draw 2 cards, each others player gains a Curse card";
	}
	public void play(Player p) {
		Card c;
		p.addHand(p.drawCard());
		p.addHand(p.drawCard());
		c=p.getGame().getFromSupply("Curse");
		for(int i=0;i<p.otherPlayers().size();i++) {
			
			if(c!=null) {
				
				p.otherPlayers().get(i).addDiscard(c);
				p.otherPlayers().get(i).getGame().removeFromSupply("Curse");
			}
		}
	}
}