package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Atelier (Workshop)
 * 
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends ActionCard {
	
	private String description;
	
	public Workshop() {
		super("Workshop",3);
		description="Gain a card costing up to 4.";
	}
	public void play(Player p) {
	 String reponse;
		CardList gagnable=new CardList();
	 for(int i=0;i<p.getGame().availableSupplyCards().size();i++) {
		 if(p.getGame().availableSupplyCards().get(i).getCost()<=4) {
			 gagnable.add(p.getGame().availableSupplyCards().get(i));
		 }
		 
	 }
	 
	 reponse=p.chooseCard("choisissez une carte de cette liste à ajouter à votre deck", gagnable, false);
	 p.gain(reponse);
	}

}