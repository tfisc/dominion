package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
/**
 * Carte Milice (Militia)
 * 
 * 2 PiÃ¨ces.
 * Tous vos adversaires dÃ©faussent leurs cartes de faÃ§on Ã  n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {
	
	String description;
	
	public Militia() {
		super("Militia",4);
		this.description="Each other player discards down to 3 cards in his hand";
	}
	
	public void play(Player p, Game g) {	
		
		//+ 2 pièces
		List<Player> l = new ArrayList <Player>();
		int i=1;
		
		p.incrementBuys(2);
				
		l=g.otherPlayers(p);
		while(i<=l.size()) {
			l.add(g.otherPlayers(p).get(i));
			i++;
		}
		
		//défausse les adversaires
		i=1;
		
		while(i<l.size()) { //tant que la liste de joueurs n'est pas finie
			Player p2; //joueur adverse sélectionné
			String cardChoice;
			Card cardRemove;
			int j=1;
			cardChoice="";

			p2=l.get(i);
			
			while((p2.cardsInHand()).size()>3) { //tant que le nombre de cartes en main du joueur est différent de 3
				cardChoice=p2.chooseCard("Choose several cards until you have tree cards left in your hand.", p2.cardsInHand(),false);
				cardRemove=(p2.cardsInHand()).getCard(cardChoice);//récupère le nom de la carte en main choisie par le joueur
				(p2.cardsInHand()).remove(cardRemove); //supprimme la carte choisie de la main du joueur et la récupère dans la variable cardRemove
				p2.addDiscard(cardRemove); //rajoute la carte retirée de la main du joueur dans la défausse du joueur grâce à la méthode addDiscard(à écrire)
			}		
			i++;
		}
		
	}
}