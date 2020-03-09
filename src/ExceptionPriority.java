import java.util.ArrayList;

public class ExceptionPriority {

	public static void main(String[] args) {

		ArrayList<Integer> al =  new ArrayList<>();
		al.add(2);
		al.add(3);
		ArrayList<Integer> temp = null;
		al=temp;
		try {
			System.out.println(al.size());
		}
		catch(NullPointerException ex) {
			System.out.println("2");
		}
		catch(Exception e) {
			System.out.println("1");
		}
		
	}

}
