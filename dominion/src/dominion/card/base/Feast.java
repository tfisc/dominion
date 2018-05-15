package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Festin (Feast)
 * 
 * Écartez cette carte.
 * Recevez une carte coûtant jusqu'à 5 Pièces.
 */
public class Feast extends ActionCard {
	 private String description;
	 
	 public Feast(){
		 super("Feast",4);
		 description="Trash this card,Gain a card costing up to 5 pieces";
	 }
	 
	 public void play(Player p) {
		 Card c;
		 String reponse="init";
		 p.getGame().addTrashedCards(this);
		 reponse=p.chooseCard("Gain a card costing up to 5 pieces", p.getGame().availableSupplyCards(), true);
		 p.gain(reponse);
	 }
}