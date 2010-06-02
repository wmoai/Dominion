package old_game;

import java.util.HashMap;
import java.util.Map;

import util.FieldCardStack;


public class Field {

    public Map<Integer, FieldCardStack> cards;

    public Field() {
        cards = new HashMap<Integer, FieldCardStack>();

        cards.put(Rule.COPPER, new FieldCardStack(Rule.COPPER));
        cards.put(Rule.SHILVER, new FieldCardStack(Rule.SHILVER));
        cards.put(Rule.GOLD, new FieldCardStack(Rule.GOLD));
        cards.put(Rule.ESTATE, new FieldCardStack(Rule.ESTATE));
        cards.put(Rule.DUCHY, new FieldCardStack(Rule.DUCHY));
        cards.put(Rule.PROVINCE, new FieldCardStack(Rule.PROVINCE));
        cards.put(Rule.CURSE, new FieldCardStack(Rule.CURSE));

    }


}
