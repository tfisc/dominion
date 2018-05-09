package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;
//pas complet
/**
 * Carte Douves (Moat)
 * 
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends ReactionCard {
	
	public Moat() {
		super("Moat",2);
		this.description="When another player plays an Attack card, you may reveal this from your hand. If you do, you are unaffected by that Attack.";
	}
	
	public void play(Player p) {
		p.drawCard();
		p.drawCard();
		
		
	}
}