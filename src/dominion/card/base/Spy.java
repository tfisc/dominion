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
	
	public void play(Player p) {
		
		String cardActionChoiceName;
		Card cardActionChoice;
		boolean stop=false;
		int i=0;
		
		//+1 Carte
		p.addHand(p.drawCard());
		
		//+1 Action
		while(stop!=true){
			
			cardActionChoiceName=p.chooseCard("Choose one action card.", p.getGame().availableSupplyCards(),false);
			cardActionChoice=p.getGame().availableSupplyCards().getCard(cardActionChoiceName);
			
			while(i<=cardActionChoice.getTypes().size()){
				
				if(cardActionChoice.getTypes().get(i)==CardType.Action){
					p.addHand(cardActionChoice);
					stop=true;
				}
				else{
					cardActionChoiceName=p.chooseCard("Choose one ACTION card.", p.getGame().availableSupplyCards(),false);
					cardActionChoice=p.getGame().availableSupplyCards().getCard(cardActionChoiceName);
				}
				
				i++;	
			}
		}
		
		//tous les joueurs dévoilent la première carte de leur pioche à faire
	}
		
}