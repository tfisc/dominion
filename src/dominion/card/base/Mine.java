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
		int i=1, j=1;
		boolean stop=false; //pour stopper la boucle quand la carte tr�sor est retir�e
		Card cardSelect; //carte s�lection�e
		List<CardType> l = new ArrayList<CardType>(); //liste des types de la carte s�lectionn�e
		
		while(i<=p.cardsInHand().size()) {
			cardSelect= p.cardsInHand().get(i);
			while(j<=cardSelect.getTypes().size()&&stop==false) {
				if(cardSelect.getTypes().get(j)==CardType.Treasure) {
					(p.cardsInHand()).remove(cardSelect); //supprime de la main du joueur
					p.getGame().addTrashedCards(cardSelect); //rajoute dans les cartes retir�es
					stop=true;
				}
				j++;
			}
			i++;
		}
		//continuer pour la deuxi�me action  et la troisi�me
	}
}