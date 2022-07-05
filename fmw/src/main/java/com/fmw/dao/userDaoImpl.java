package com.fmw.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fmw.dto.userVO;

@Repository
public class userDaoImpl implements userDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedparameterjdbctemplate;

	@Override
	public List<userVO> selectUserList() {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sw_user ");

		RowMapper<userVO> mapper = new BeanPropertyRowMapper<userVO>(userVO.class);
		return namedparameterjdbctemplate.query(sql.toString(), mapper);
	}

}
