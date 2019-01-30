package Examples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class JDBCServerResource extends ServerResource {  
	DBManager db;
	
	public JDBCServerResource() {
		super();
		try {
			db = new DBManager();
			db.verify();
		} catch (ClassNotFoundException e) {
			System.out.println("Missign lib...");
		} catch (SQLException e) {
			System.out.println("SQL error...");
		}
	}
	
	private void log_query() throws SQLException {
		String query = getReference().getPath();
		String q_log = "INSERT INTO \"log\" (\"query\") VALUES ('" + query + "');";
		System.out.println(q_log);
		db.executeUpdate(q_log);
	}
	
	private String resultset_to_json(ResultSet rs) throws SQLException {
		JSONArray jarr = new JSONArray();
		while (rs.next()){
			HashMap<String, String> row = new HashMap<String, String>();
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) 
				row.put(rs.getMetaData().getColumnName(i), String.valueOf(rs.getObject(i)));
			jarr.add(new JSONObject(row));
		}
		return jarr.toString();
	}
	
	public String getMortadella_by_lenght() throws SQLException {
		String min = getQuery().getValues("min");
		String max = getQuery().getValues("max");
		
		String q = String.format("SELECT * FROM mortadella WHERE lenght BETWEEN %s AND %s ORDER BY lenght",
				min, max);
		System.out.println(q);
		log_query();
		ResultSet rs = db.executeQuery(q);
		return resultset_to_json(rs);
	}
	
	public String getMortadella_by_quality() throws SQLException {
		String surname = getQuery().getValues("surname");
		String q = "SELECT * FROM students " +
				"WHERE surname = " + "'" + surname + "'" + " ORDER BY name";
		System.out.println(q);
		log_query();
		ResultSet rs = db.executeQuery(q);
		return resultset_to_json(rs);
	}

	@Get  
	public String handleConnection() {  
		String response = null;
		try {
			if (getReference().getLastSegment().equals("get_mortadella_by_lenght")) {
				// example: /1/get_mortadella_by_lenght?min=30&max=40
				response = getMortadella_by_lenght();
			} else if (getReference().getLastSegment().equals("get_mortadella_by_quality")) {
				// example: /1/get_mortadella_by_quality?quality=high
				response = getMortadella_by_quality();
			} else {
				//throw new ResourceException(new Status(Status.SERVER_ERROR_NOT_IMPLEMENTED, ""));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println("[ERROR]" + getReference());
		}
		return response;
	}

	public static void main(String[] args) throws Exception {  
		new Server(Protocol.HTTP, 8182, JDBCServerResource.class).start();  
	}

}  