package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {
	private String description;
	
	public Adventurer() {
		super("Adventurer",6);
		description="Reveal cards from your deck until 2 tresures cards have been revealed. Add these treasure cards to your hand and discard others";
	}
	public void play(Player p) {
		int i=0;
		int j=0;
		boolean tresor=false;
		Card c;
		while(i<2) {
			tresor=false;
			j=0;
			c=p.drawCard();
			while(j<c.getTypes().size() && tresor==false)
			{
				if(c.getTypes().get(j)==CardType.Treasure)
				{
					p.addHand(c);
					tresor=true;
					i++;
				}
			j++;
			}
				if (tresor==false) {
					
					p.gain(c);
			
		}
	}
	}
			
}