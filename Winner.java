package oving8;

public class Winner implements Comparable<Winner> {
		private String name;
		private int score;

	public Winner(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return name + ": " + score;
	}

	@Override
	public int compareTo(Winner o) {
		return this.score - o.getScore();
	}

}
