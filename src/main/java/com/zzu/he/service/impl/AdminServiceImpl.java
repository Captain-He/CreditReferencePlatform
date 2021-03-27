package com.zzu.he.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzu.he.entity.Admin;
import com.zzu.he.mapper.AdminMapper;
import com.zzu.he.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper adminMapper;

	@Override
	public List<Admin> findAdmin(String account, String psw) {
		// TODO Auto-generated method stub
		return adminMapper.findAdmin(account, psw);
	}

}
