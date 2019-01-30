package Examples;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class FirstClientResource {
	public static void main(String[] args) throws ResourceException, IOException, ParseException {
		// Create the client resource  
		ClientResource r = new ClientResource("http://localhost:8182/");  

		String response = r.get().getText();
		System.out.println("[HTTP] " + response);		
	}
}