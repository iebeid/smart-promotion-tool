package com.xpress.spt.ws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.security.annotation.Secured;

import com.xpress.spt.bean.SptUsers;
import com.xpress.spt.service.UserManagementServiceImpl;
import com.xpress.spt.util.Utils;

@Secured ({"ROLE_USER"})
@WebService(endpointInterface = "com.xpress.spt.ws.UserManagementServiceWs")
public class UserManagementServiceWsImpl implements UserManagementServiceWs {

	


	public void deleteUser(SptUsers entity) {
		UserManagementServiceImpl.getFromApplicationContext(Utils.getContext()).delete(entity);
	}

	public List<SptUsers> findAllUsers() {
		return UserManagementServiceImpl.getFromApplicationContext(Utils.getContext()).findAll();
	}

	public SptUsers findUserById(Long id) {
		return UserManagementServiceImpl.getFromApplicationContext(Utils.getContext()).findById(id);
	}

	public List<SptUsers> findByUsername(Object username) {
		return UserManagementServiceImpl.getFromApplicationContext(Utils.getContext()).findByUsername(username);
	}

	public SptUsers updateUser(SptUsers entity) {
		return UserManagementServiceImpl.getFromApplicationContext(Utils.getContext()).update(entity);
	}
	
	public List<SptUsers> searchByUsername(String username){
		return UserManagementServiceImpl.getFromApplicationContext(Utils.getContext()).searchByUsername(username);
	}
	
	public void createUser(SptUsers user){
		UserManagementServiceImpl.getFromApplicationContext(Utils.getContext()).save(user);
	}

}
