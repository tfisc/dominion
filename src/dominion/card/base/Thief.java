package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
//pas complet
/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dÃ©voilent les 2 premiÃ¨res cartes de leur deck. S'ils dÃ©voilent des cartes TrÃ©sor, ils en Ã©cartent 1 de votre choix. Parmi ces cartes TrÃ©sor Ã©cartÃ©es, recevez celles de votre choix. Les autres cartes dÃ©voilÃ©es sont dÃ©faussÃ©es.
 */
public class Thief extends AttackCard {
	
	String description;
	
	public Thief() {
		super("Thief",4);
		this.description="Each other player reveals the top 2 cards of his deck. If they revealed any Treasure cards, they trash one of them that you choose. You may gain any or all of these trashed cards. They discard the other tevealed cards.";
	}
	
	public void play(Player p) {
		
		List<Player> l = new ArrayList <Player>();
		List<String> liste=new ArrayList<String>();
		List<String> listeChoix=new ArrayList<String>();
		String reponse=""; 
		Player p2;
		Card c1, c2;
		String c="";
		int i =0;
		int j=0;
		boolean tresor=false;
		
		l=p.getGame().otherPlayers(p);
		while(i<=l.size()) {
			l.add(p.getGame().otherPlayers(p).get(i));
			i++;
		}
		
		while(i<=l.size()) {
			p2=l.get(i);
			c1=p2.drawCard();
			c2=p2.drawCard();
			
			if(liste.size()>0) {
				liste.remove(1);
			}
			
			while(j<c1.getTypes().size())
			{
				if(c1.getTypes().get(j)==CardType.Treasure)
				{
					liste.add(c1.getName());
				}
				if (tresor==false) {
					
					p2.addDiscard(c1);
				}
				
				j++;
			
			}
			
			j=0;
			
			while(j<c2.getTypes().size())
			{
				if(c2.getTypes().get(j)==CardType.Treasure)
				{
					liste.add(c2.getName());
				}
				if (tresor==false) {
					
					p2.addDiscard(c2);
				}
				
				j++;			
			}
			
			if(liste.size()>1) {
				c = p.choose("Tapez le nom de la carte que vous souhaitez retirer", liste, false);
				if(c == c1.getName()) {
					p2.addDiscard(c2);
					listeChoix.add(c);
				}
				else {
					p2.addDiscard(c1);
					listeChoix.add(c);
				}
			}
			
			else if(liste.size()==1) {
					listeChoix.add(liste.get(0));
				}
			
			i++;
	}
		
		boolean stop=false;
		
		while(stop==false) {
		
		c = p.choose("Choisissez une des cartes que vous souhaitez garder sinon appuyez sur entrée", listeChoix, false);
		if(c=="") {
			stop=true;
		}
		p.addDiscard(p.cardsInHand().getCard(c));
		listeChoix.remove(c);
		
		if(listeChoix.size()==0) {
			stop=true;
		}
		}	
			
	}
}
