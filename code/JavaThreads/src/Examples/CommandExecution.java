package Examples;
import java.io.*;
public class CommandExecution {

	public static void main(String args[]) throws IOException, InterruptedException {
		String line;
		Process p;

		//p = Runtime.getRuntime().exec("/bin/ls -al /");
		p = (new ProcessBuilder("/bin/ls", "-al", "/")).start();

		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
		p.waitFor();
	}
}