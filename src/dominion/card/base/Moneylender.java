package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
//pas complet
/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {
	
	String description;
	
	public Moneylender() {
		super("MoneyLender",4);
		this.description="Trash a Copper card from your hand. If you do, +3";
	}
	
	public void play(Player p) {
		
		Card cardSelect;
		int i = 0;
		
		while(i<=p.getTreasureCards().size()){
			cardSelect=p.getTreasureCards().get(i); //récupère une carte dans la main du joueur
			if(cardSelect.getName()=="Copper"){ //si la carte est une carte cuivre
				p.cardsInHand().remove(cardSelect); //supprime la carte sélectionnée de la main du joueur
				p.getGame().addTrashedCards(cardSelect); //rajoute la carte supprimée dans le rébu
				p.incrementMoney(3); //rajoute 3 pièces au joueur
			}
			
			i++;
		}
	}
}