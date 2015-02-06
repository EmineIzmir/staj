package sikayetVar;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends TimerTask {
	private ArrayList<Complaint> mergeObj = new ArrayList<Complaint>();

	public Main() {
		// timer is 5 minutes
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(this, new Date(), 300000);
	}

	public void run() {
		try {
			new ProcessesForParsing().addComplaintToJson(mergeObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		       new Main();		   
	}
}
