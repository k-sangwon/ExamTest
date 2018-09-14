package org.study.manager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.study.manager.model.Member;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	private boolean isInit = false;
	
	private static final String namespace="org.study.mapper.ManagerMapper";
	@Autowired
	SqlSession session;
	
	@Override
	public void insertMember(Member member) throws Exception{
		if (isInit == false) {
			init();
		}
		
		session.insert(namespace + ".insertMember", member);
	}
	
	public List<Member> list() {
		return session.selectList(namespace+".list");
	}

	@Override
	public void init() {
	
		
		isInit = true;
	}
/*
	@Override
	public boolean existMemberTable() {
		int count = session.selectOne(namespace + ".existMemberTable");
		
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void createMemberTable() {
		session.update(namespace + ".createMemberTable");
	}
*/
	@Override
	public boolean existMemberId(String id) {
		int count = session.selectOne(namespace + ".existMemberId", id);
		
		if (count == 0) {
			return false;
		} else {
			return true;
		}
		  
	}
	@Override
	public void delete(String id) {
		session.delete(namespace+".delete", id);
	}

}