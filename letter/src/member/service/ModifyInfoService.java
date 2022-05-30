package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ModifyInfoService {

	private MemberDao memberDao = new MemberDao();

	public Member myPage(String id) {
		Connection conn = null;
		Member member = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			member = memberDao.selectById(conn, id);
			if (member == null) {
				throw new MemberNotFoundException();
			}
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return member;
	}

	public void modifyInfo(Member member) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			memberDao.update(conn, member);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
