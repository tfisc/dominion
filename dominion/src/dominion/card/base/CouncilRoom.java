package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Chambre du conseil (Council Room)
 * 
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends ActionCard {
	private String description;
	
	public CouncilRoom(){
		super("Coucil Room",5);
		description="+4 cards, +1 buy,Each other player draws a card";
	}
	public void play(Player p) {
		List<Player> joueurs=new ArrayList<Player>();
		p.incrementBuys(1);
		p.addHand(p.drawCard());
		p.addHand(p.drawCard());
		p.addHand(p.drawCard());
		p.addHand(p.drawCard());
		joueurs=p.getGame().otherPlayers(p);
		for(int i=0;i<joueurs.size();i++){
		joueurs.get(i).addHand(joueurs.get(i).drawCard());
		joueurs.get(i).removeDraw(joueurs.get(i).cardsInHand().get(p.cardsInHand().size()-1).getName());
		}
	}
}