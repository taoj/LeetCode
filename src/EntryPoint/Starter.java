package EntryPoint;

import Issues.IIssueTemplate;
import Issues.Q160;
import Issues.Q400;

public class Starter {

	public static void main(String[] args) {
		
		IIssueTemplate q = new Q400();
		q.go();
		System.out.println("Hello world");

	}

}
