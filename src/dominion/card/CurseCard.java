package dominion.card;
import java.util.*;

import dominion.*;

/**
 * Les cartes Malédiction
 */
public abstract class CurseCard extends Card {


	CardType type;
	
	public CurseCard(String name, int cost){
		 super(name,cost);
		 type=CardType.Curse;

		}


		public List<CardType> getTypes() {
			List<CardType> liste = super.getTypes();
			liste.add(type);
			return liste;
			
		}
}