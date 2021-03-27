package com.zzu.he.service;

import java.util.List;

import com.zzu.he.entity.Admin;

public interface AdminService {
	public List<Admin> findAdmin(String account, String psw);
}
