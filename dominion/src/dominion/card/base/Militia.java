package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
/**
 * Carte Milice (Militia)
 * 
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {
	
	String description;
	
	public Militia() {
		super("Militia",4);
		this.description="Each other player discards down to 3 cards in his hand";
	}
	
	public void play(Player p) {	
		
		//+ 2 pi�ces
		List<Player> l = new ArrayList <Player>();
		int i=0;
		
		p.incrementMoney(2);
				
		l=p.getGame().otherPlayers(p);
		
		//d�fausse les adversaires
		i=0;
		
		while(i<l.size()) { //tant que la liste de joueurs n'est pas finie
			Player p2; //joueur adverse s�lectionn�
			String cardChoice;
			Card cardRemove;
			cardChoice="";

			p2=l.get(i);
			
			while(p2.cardsInHand().size()>3) { //tant que le nombre de cartes en main du joueur est diff�rent de 3
				cardChoice=p2.chooseCard("Choose several cards until you have tree cards left in your hand.", p2.cardsInHand(),false);
				cardRemove=(p2.cardsInHand()).getCard(cardChoice);//r�cup�re le nom de la carte en main choisie par le joueur
				p2.addDiscard(cardRemove); //rajoute la carte retir�e de la main du joueur dans la d�fausse du joueur gr�ce � la m�thode addDiscard(� �crire)
				p2.removeHand(cardChoice); //supprimme la carte choisie de la main du joueur et la r�cup�re dans la variable cardRemove
			}		
			i++;
		}
		
	}
}