package dominion.card;
import java.util.*;

import dominion.*;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {
	
	CardType type;
	
	public VictoryCard(String name, int cost){
		 super(name,cost);
		 type=CardType.Victory;

		}


		public List<CardType> getTypes() {
			List<CardType> liste = super.getTypes();
			liste.add(type);
			return liste;
			
		}
	
}