package Turanga_Lila;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Random_Card_Extractor {
	
	public static class Card {
		public Card(String a, String b) {
			type = b;
			CardClass = a;
		}
		public String type;
		public String CardClass;
	}

	public static void main (String[] argc) {
		Random r = new Random();
		// int cardPos = 0;
		Card card;
		String[] CardClass = { "+", "@", "#", "$" };
		String[] CardTypes = { "2", "3", "4", "5", "6", "7", "8", "9", "0", "V", "Q", "K", "T" };
		List<Card> column = new LinkedList<Card>();
		for (int i = 0; i < 4; i++) 
			for (int j = 0; j < 13; j++)
				column.add(new Card(CardClass[i], CardTypes[j]));
		for (int i = 52; i > 0; i--) {
			card = column.remove(r.nextInt(i));
			System.out.println(card.CardClass +  card.type);
		}
	} 
}
