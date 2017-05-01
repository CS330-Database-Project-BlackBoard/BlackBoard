package interfaces;

import java.util.ArrayList;

import pojos.Manager;

public interface ManagerDao {
	
	public boolean createNewManager(Manager manager);
	public boolean updateRole(Manager manager);
	public boolean deleteManager(Manager manager);
	public ArrayList<Manager> getAllManagers();
	public Manager getManagerByID(int SchoolID);
}
