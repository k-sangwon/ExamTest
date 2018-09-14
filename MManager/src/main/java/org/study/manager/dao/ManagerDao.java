package org.study.manager.dao;

import java.util.List;

import org.study.manager.model.Member;

public interface ManagerDao {

	public void init();
	
	public void insertMember(Member member) throws Exception;
	
	public List<Member> list() throws Exception;
/*	public boolean existMemberTable();
	
	public void createMemberTable();
*/
	public boolean existMemberId(String id);
	
	public void delete(String id);
}