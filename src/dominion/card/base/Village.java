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
	
	public Village(String name, int cost, String descr){
		
		super(name,cost);
		this.description=descr;
	}

	public void play(Player p)
	{
		p.incrementActions(2);
		p.drawCard();
	}




}

