package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Ã‰cartez une carte TrÃ©sor de votre main. Recevez une carte TrÃ©sor coÃ»tant jusqu'Ã  3 PiÃ¨ces de plus ; ajoutez cette carte Ã  votre main.
 */
public class Mine extends ActionCard {
	
	String description;
	
	public Mine() {
		super("Mine",5);
		this.description="Trash a Treasure card from your hand. Gain a Treasure card costing up to 3 more; put i into your hand.";
	}
	
	public void play(Player p){
		int i=1, j=1;
		boolean stop=false; //pour stopper la boucle quand la carte trésor est retirée
		Card cardSelect; //carte sélectionée
		List<CardType> l = new ArrayList<CardType>(); //liste des types de la carte sélectionnée
		
		while(i<=p.cardsInHand().size()) {
			cardSelect= p.cardsInHand().get(i);
			while(j<=cardSelect.getTypes().size()&&stop==false) {
				if(cardSelect.getTypes().get(j)==CardType.Treasure) {
					(p.cardsInHand()).remove(cardSelect); //supprime de la main du joueur
					cardSelect.addTrashedCards; //rajoute dans les cartes retirées
					stop=true;
				}
				j++;
			}
			i++;
		}
		//continuer pour la deuxième action  et la troisième
	}
}