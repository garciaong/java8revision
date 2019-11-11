package simply.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestSort {

	public static void main(String[] args) {
		/**
		 * Result 
		 * Original order Lacazette 
		 * Original order Vardy 
		 * Original order Aubameyang 
		 * Original order Morisson 
		 * Club,Rating order Lacazette 
		 * Club,Rating order Aubameyang 
		 * Club,Rating order Morisson 
		 * Club,Rating order Vardy
		 * Rating,Club reversed order Vardy 
		 * Rating,Club reversed order Morisson
		 * Rating,Club reversed order Aubameyang 
		 * Rating,Club reversed order Lacazette
		 */
		Player laca = new Player("Lacazette", 7, "Arsenal");
		Player auba = new Player("Aubameyang", 8, "Arsenal");
		Player vardy = new Player("Vardy", 9, "Leicester");
		Player mori = new Player("Morisson", 8, "Leicester");

		List<Player> players = new ArrayList<Player>();
		players.add(laca);
		players.add(vardy);
		players.add(auba);
		players.add(mori);

		players.stream().forEach(p -> System.out.println(String.format("Original order %s", p.getName())));
		players.sort((p1, p2) -> {
			if (p1.getClub().equals(p2.getClub())) {
				return p1.getRating() - p2.getRating();
			} else {
				return p1.getClub().compareTo(p2.getClub());
			}
		});
		players.stream().forEach(p -> System.out.println(String.format("Club,Rating order %s", p.getName())));
		Comparator<Player> playerFunc = (p1, p2) -> {
			if (p1.getRating() == p2.getRating()) {
				return p1.getClub().compareTo(p2.getClub());
			} else {
				return p1.getRating() - p2.getRating();
			}
		};
		players.sort(playerFunc.reversed());
		players.stream().forEach(p -> System.out.println(String.format("Rating,Club reversed order %s", p.getName())));
	}

	private static class Player {
		private String name;
		private int rating;
		private String club;

		public Player(String name, int rating, String club) {
			super();
			this.name = name;
			this.rating = rating;
			this.club = club;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getClub() {
			return club;
		}

		public void setClub(String club) {
			this.club = club;
		}
	}
}
