package Gestionale;

import java.util.ArrayList;

public class Company {
	protected ArrayList<WorkRoom> lwr;
	
	public Company() {
		lwr = new ArrayList<WorkRoom>();
	}
	
	public void addWorkRoom(WorkRoom wr) {
		lwr.add(wr);
	}
	
	public void removeWorkRoom(WorkRoom wr) {
		lwr.remove(wr);
	}
	
	public WorkRoom searchWorkRoom(String ID) {
		for (WorkRoom wr : lwr) {
			if (wr.getID().equals(ID))
				return wr;
		}
		return null;
	}
	

}
