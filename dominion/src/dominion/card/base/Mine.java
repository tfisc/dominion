package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {
	
	String description;
	
	public Mine() {
		super("Mine",5);
		this.description="Trash a Treasure card from your hand. Gain a Treasure card costing up to 3 more; put i into your hand.";
	}
	
	public void play(Player p){
	CardList gagnable=new CardList();
	Card supprime;
	String reponse="init";
	reponse=p.chooseCard("Ecartez une carte trésor de votre main", p.getTreasureCards(), false);
	supprime=p.getTreasureCards().getCard(reponse);
	p.removeHand(reponse);
	
	for(int i=0;i<p.getGame().availableSupplyCards().size();i++){
		if(p.getGame().availableSupplyCards().get(i).getTypes().get(0)==CardType.Treasure && p.getGame().availableSupplyCards().get(i).getCost()<=supprime.getCost()+3){
			gagnable.add(p.getGame().availableSupplyCards().get(i));
		}
	}
	
	reponse=p.chooseCard("Choisissez une carte trésor à ajouter à votre main", gagnable, false);
	p.addHand(p.getGame().removeFromSupply(reponse));
		
	}
}