package com.xpress.spt.ws;

import java.util.List;

import javax.jws.WebService;

import com.xpress.spt.bean.SptUsers;

@WebService
public interface UserManagementServiceWs {

	public void deleteUser(SptUsers entity);
	public SptUsers updateUser(SptUsers entity);
	public SptUsers findUserById(Long id);
	public List<SptUsers> findByUsername(Object username);
	public List<SptUsers> findAllUsers();
	public List<SptUsers> searchByUsername(String username);
	public void createUser(SptUsers user);
	
}
