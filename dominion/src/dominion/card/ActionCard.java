package dominion.card;
import java.util.*;

import dominion.*;
//FAIT
/**
 * Les cartes Action
 */
public abstract class ActionCard extends Card {
	
	CardType type;


public ActionCard(String name, int cost){
 super(name,cost);
 type=CardType.Action;

}


public List<CardType> getTypes() {
	List<CardType> liste = super.getTypes();
	liste.add(type);
	return liste;
	
}
}