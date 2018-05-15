package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {
	private String description;
	
	public Cellar() {
		super("Cellar",4);
		description="+1 Action, Discard as much cards as you want, draw one card for everyone you discard";
	}
		public void play (Player p) {
			String reponse="init";
					List<String> liste=new ArrayList<String>();
					liste.add(p.cardsInHand().toString());
			p.incrementActions(1);
			while(reponse !="") {
			
				reponse=p.choose("Taper le nom de la carte à défauser, sinon appuyez sur entrer", liste, true);
				if(reponse !="") {
					p.addDiscard(p.cardsInHand().getCard(reponse));
					p.removeHand(reponse);
					p.drawCard();
			}
		
			
		}
	}
}