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
		super("CoucilRoom",5);
		description="Each other player draws a card";
	}
	public void play(Player p) {
		List<Player> joueurs=new ArrayList<Player>();
		p.incrementBuys(1);
		p.drawCard();
		p.drawCard();
		p.drawCard();
		p.drawCard();
		joueurs=p.getGame().otherPlayers(p);
		for(int i=0;i<joueurs.size();i++){
		joueurs.get(i).drawCard();
		}
	}
}