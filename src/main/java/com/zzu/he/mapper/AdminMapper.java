package com.zzu.he.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zzu.he.entity.Admin;

@Mapper
public interface AdminMapper {
	public List<Admin> findAdmin(String account, String psw);
}
