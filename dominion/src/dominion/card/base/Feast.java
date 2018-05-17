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
		 CardList gagnable=new CardList();
		 String reponse="init";
		 for(int i=0;i<p.getGame().availableSupplyCards().size();i++){
			 if(p.getGame().availableSupplyCards().get(i).getCost()<=5){
				 gagnable.add(p.getGame().availableSupplyCards().get(i));
			 }
			 
		 }
		 
		 reponse=p.chooseCard("Choose a card to trash", p.cardsInHand(), false);
		 p.removeHand(reponse);
		 
		 
		
		 reponse=p.chooseCard("Gain a card costing up to 5 pieces", gagnable, false);
	
		 p.gain(reponse);
		 }
	 }
