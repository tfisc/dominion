package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
// pas complet
/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {
	
	String description;
	
	public ThroneRoom() {
		super("Throne Room",4);
		this.description="Choose an Action card in your hand. Play it twice.";
	}
	
	public void play(Player p) {
		String reponse;
		CardList actionCardsInHand=new CardList();
		for(int i=0;i<p.cardsInHand().size();i++) {
			for(int j=0;j<p.cardsInHand().get(i).getTypes().size();i++) {
				if(p.cardsInHand().get(i).getTypes().get(j)==CardType.Action) {
					actionCardsInHand.add(p.cardsInHand().get(i));
				}
			}
		}
	reponse=p.chooseCard("Choisissez une carte à jouer deux fois", actionCardsInHand, false);
	p.playCard(reponse);
	p.playCard(reponse);
	
	}
}