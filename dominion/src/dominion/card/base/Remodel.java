package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
//pas complet
/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {
	
	String description;
	
	public Remodel() {
		super("Remodel",4);
		this.description="Trash a card from your hand. Gain a card costing up to 2 more than the trashed card.";
	}
	
	public void play(Player p) {
		
		String cardChoiceName;
		Card cardChoice, cardSave;
		boolean stop=false;
		
		
		//Ecarte une carte de la main du joueur
		cardChoiceName=p.chooseCard("Choose one card in your hand", p.cardsInHand(),false);
		cardChoice = (p.cardsInHand()).getCard(cardChoiceName);
		cardSave=cardChoice;
		
		
		//Tant que le joueur n'a pas choisi de carte qui vaut 2 îèces de plus ou moins dans la réserve, réaffiche la demande et sinon rajoute la carte choisie dans la main
		while(stop!=true){
		
		cardChoiceName=p.chooseCard("Choose one card in supply stacks which cost 2 more pieces", p.getGame().availableSupplyCards(), false);
		
		if(cardChoice.getCost() <= cardSave.getCost()+2){
			p.addHand(cardChoice);
			stop=true;		
		}
		
		}
	}
}