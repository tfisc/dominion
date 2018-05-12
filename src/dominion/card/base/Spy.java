package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;
//pas complet
/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dÃ©voilent la premiÃ¨re carte de leur deck. Vous dÃ©cidez ensuite si chaque carte dÃ©voilÃ©e est dÃ©faussÃ©e ou replacÃ©e sur son deck.
 */
public class Spy extends AttackCard {
	
	String description;
	
	public Spy() {
		super("Spy",4);
		this.description="+1 Card, +1 Action ; Each player(including you) reveals the top card of his deck and either discards it or puls it back, your choice.";
	}
	
	public void play(Player p) {
		
		String cardActionChoiceName;
		Card cardActionChoice;
		boolean stop=false;
		int i=0;
		
		//+1 Carte
		p.addHand(p.drawCard());
		
		//+1 Action
		while(stop!=true){
			
			cardActionChoiceName=p.chooseCard("Choose one action card.", p.getGame().availableSupplyCards(),false);
			cardActionChoice=p.getGame().availableSupplyCards().getCard(cardActionChoiceName);
			
			while(i<=cardActionChoice.getTypes().size()){
				
				if(cardActionChoice.getTypes().get(i)==CardType.Action){
					p.addHand(cardActionChoice);
					stop=true;
				}
				else{
					cardActionChoiceName=p.chooseCard("Choose one ACTION card.", p.getGame().availableSupplyCards(),false);
					cardActionChoice=p.getGame().availableSupplyCards().getCard(cardActionChoiceName);
				}
				
				i++;	
			}
		}
		
		i=0;
		Card c; //carte dévoilée
		Player p2; //joueur sélectionné
		String reponse=""; //choix du joueur
		List<Player> l = new ArrayList <Player>(); //nouvelle listes de joueurs
		List<String> liste=new ArrayList<String>();//liste de cartes pouvant être défaussée
		
		
		//remplis la liste de joueurs avec les joueurs adverses et nous même
		l=p.getGame().otherPlayers(p);
		while(i<=l.size()) {
			l.add(p.getGame().otherPlayers(p).get(i));
			i++;
		}
		l.add(p);
		
		//Tous les joueurs
		while(i<=l.size()) {
			
			//le joueur dévoile la première carte de sa pioche
			p2=l.get(i);
			c=p2.drawCard();
			
			//si il y a déjà la carte du joueur précédent dans la liste, la supprimer
			if(liste.size()>0) {
				liste.remove(1);
			}
			
			//rajouter la carte dévoilée du joueur dans la liste
			liste.add(c.getName());
			
			//demande au joueur p de choisir si la carte sera défaussée ou non
			reponse = p.choose("Tapez le nom de la carte si vous souhaitez qu'elle soit défaussée, sinon tapez sur entrée", liste , false);
			if(reponse!="") {
				p2.addDiscard(c);
			}
			else {
				p2.addDraw(c);
			}
			i++;
		}
	}
		
}
