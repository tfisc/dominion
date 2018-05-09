package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {
	private String description;
	
	public Library(){
		super("Library",5);
		description="Draw until you have 7 Cards in hand.You may set aside any actions card drawn this way, as you draw them;discard the set aside cards after you finish drawning";
	}
	
	public void play(Player p) {
		List<String> choices=new ArrayList<String>();
		choices.add("Oui");
		choices.add("Non");
		int i=0;
		String reponse=""
		Card c; 
		CardList hand = new CardList();
		 while(p.cardsInHand().size()<7){
			 c=p.drawCard();
			 while(i<c.getTypes().size()){
				 if(c.getTypes().get(i)==CardType.Action){
					 reponse=p.choose("Do you want to add this card to your discard ?", choices, false);
				 }
			 }
			 
		 }
	}
}