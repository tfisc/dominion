package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chapelle (Chapel)
 * 
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends ActionCard {
	private String description;
	
	public Chapel() {
		super("Chapel",2);
		description="Trash up to 4 cards from your hand";
	}
	public void play(Player p) {
		int i=0;
		String reponse="init";
		while(i<4 && reponse !="") {
			reponse=p.chooseCard("Taper le nom de la carte à défauser, sinon appuyez sur entrer", p.cardsInHand(), true);
			if(reponse !="") {
				p.removeHand(reponse);
				i++;
		}
			
		}
	}
}