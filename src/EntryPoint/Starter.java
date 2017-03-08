package EntryPoint;

import Issues.IIssueTemplate;
import Issues.Q160;
import Issues.Q190;
import Issues.Q400;
import Issues.Q475;

public class Starter {

	public static void main(String[] args) {
		
		IIssueTemplate q = new Q475();
		q.go();
		System.out.println("Hello world");

	}

}
