package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {
	private String description;
	
	public Bureaucrat() {
		super("Bureaucrat",4);
		description="Tous vos adversaires dévoilent une carte Victoire et la placent "
				+ "sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire)";
	}
		public void play (Player p) {
			int i=0;
			int j=0;
			int k=0;
			boolean trouve=false;
			p.addDiscard(p.getGame().removeFromSupply("Silver"));
			
			while(i<p.getGame().otherPlayers(p).size()) {
				trouve=false;
				j=0;
				while(j<p.getGame().otherPlayers(p).get(i).cardsInHand().size() && trouve==false)
				{
				
					k=0;
					while(k<p.getGame().otherPlayers(p).get(i).cardsInHand().get(j).getTypes().size() && trouve==false)
					{
					if(p.getGame().otherPlayers(p).get(i).cardsInHand().get(j).getTypes().get(k)==CardType.Victory)
					{
						p.getGame().otherPlayers(p).get(i).addDiscard(p.getGame().otherPlayers(p).get(i).cardsInHand().get(j));
						p.getGame().otherPlayers(p).get(i).cardsInHand().remove(j);
						trouve=true;
					}
					k++;
					}
					j++;
				}
				}
			}
			
		}
	
