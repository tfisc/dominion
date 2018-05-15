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
		Player p2;
		Card c1, c2;
		String c="";
		int i =0;
		int j=0;
		boolean tresor=false;
		
		//liste de tous les joueurs adverses
		l=p.getGame().otherPlayers(p);
		while(i<=l.size()) {
			l.add(p.getGame().otherPlayers(p).get(i));
			i++;
		}
		
		//tant que tous les joueurs adverses n'ont pas été pris en compte
		while(i<=l.size()) {
			p2=l.get(i);
			c1=p2.drawCard(); //le joueur adverse dévoile une première carte
			c2=p2.drawCard(); //le joueur adverse dévoile une deuxième carte
			
			if(liste.size()>1) { //si la liste de carte est déjà remplie, la mettre à vide
				liste.remove(1);
				liste.remove(0);
			}
			if(liste.size()==1) {  //si la liste de carte est déjà remplie, la mettre à vide
				liste.remove(0);
			}
			
			//Tant qu'on a pas analysé tous les types de la carte 1
			while(j<c1.getTypes().size())
			{
				if(c1.getTypes().get(j)==CardType.Treasure){ //si la carte est un tresor, on la rajoute à la liste 
					liste.add(c1.getName());
					tresor=true;
				}
				j++;			
			}
			
			if (tresor==false) {		//sinon on la défausse			
				p2.addDiscard(c1);
			}
			
			j=0;
			
			while(j<c2.getTypes().size()) //pareil pour la carte 2
			{
				if(c2.getTypes().get(j)==CardType.Treasure)
				{
					liste.add(c2.getName());
					tresor=true;
				}
								
				j++;			
			}
			
			if (tresor==false) {					
				p2.addDiscard(c2);
			}
			
			if(liste.size()>1) { //si les deux cartes dévoilées sont des trésors, demande au joueur laquelle il souhaite retirer
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
			
			else if(liste.size()==1) { //si qu'une carte trésor, celle ci est directement retirée
					listeChoix.add(liste.get(0));
				}
			
			i++;
	}
		
		boolean stop=false;
		
		while(stop==false) { //tant que la liste de choix de cartes n'est pas vide ou que le joueur souhaite en retirer encore, donner le choix
		
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
