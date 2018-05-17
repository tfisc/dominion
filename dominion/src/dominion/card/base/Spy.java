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
 * Tous les joueurs (vous aussi) dÃ©voilent la premiÃ¨re carte de leur deck. Vous dÃ©cidez ensuite si chaque carte dÃ©voilÃ©e est dÃ©faussÃ©e ou replacÃ©e sur son deck.
 */
public class Spy extends AttackCard {
	
	String description;
	
	public Spy() {
		super("Spy",4);
		this.description="+1 Card, +1 Action ; Each player(including you) reveals the top card of his deck and either discards it or puls it back, your choice.";
	}
	
	public void play(Player p) {
		
	/*	String reponse="init";
		Card cardActionChoice;
		boolean stop=false;
		int i=0;
		
		//+1 Carte
		p.addHand(p.drawCard());
		
		//+1 Action
		p.incrementActions(1);
		
		reponse=p.*/
		
		
		
	}
		
}
