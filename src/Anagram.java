public class Anagram {
	public static void main(String[] args) {
		StringBuilder problem = new StringBuilder("abcd");
		anagram(problem, "");
	}

	static void anagram(StringBuilder problem, String solution) {

		if (problem.length() < 1) {
			System.out.println(solution);
			return;
		}
		for (int i = 0; i < problem.length(); i++) {
			StringBuilder newProblem = new StringBuilder(problem);
			anagram(newProblem.deleteCharAt(i), solution + problem.charAt(i));
		}
	}
}
