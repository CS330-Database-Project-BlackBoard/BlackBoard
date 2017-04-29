package interfaces;

import pojos.Dashboard;
import pojos.User;

public interface DashboardDao {
	public Dashboard getDashboard(User user);
	
}
