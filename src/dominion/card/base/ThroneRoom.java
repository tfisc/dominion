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
	
	public void play(Player p, Game g) {
	}
}