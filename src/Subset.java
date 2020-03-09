
public class Subset {

	public static void main(String[] args) {
		String problem = "abcd";
		subset(problem, "");

	}

	static void subset(String problem, String solution) {
	if (problem.length()<1) {
		System.out.println("{" + solution + "}");
		return;
	}
		
		subset(problem.substring(1, problem.length()), solution + problem.charAt(0));
		subset(problem.substring(1, problem.length()), solution);
	}

}
