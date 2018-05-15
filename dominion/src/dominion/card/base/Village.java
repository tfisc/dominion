package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;
//FAIT
/**
 * Carte Village
 * 
 * +1 Carte.
 * +2 Actions.
 */
public class Village extends ActionCard {
	
	String description;
	
	public Village(){
		
		super("Village",2);
		this.description="+1 Card,+2 Actions";
	}

	public void play(Player p)
	{
		p.incrementActions(2);
		p.drawCard();
	}




}

