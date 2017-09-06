package ua.nure.nikonova.bloodbank.dao;

import java.util.List;

import ua.nure.nikonova.bloodbank.model.Admin;

public class AdminDAO {
public List<Admin> getAllAdmin() {
	return MySqlConnector.selectAllAdmins() ;
	
}

public Admin getAdminByLogin(String login) {
	return MySqlConnector.selectAdminByLogin(login) ;
	
}
}
