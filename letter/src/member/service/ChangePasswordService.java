package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePasswordService {

	private MemberDao memberDao = new MemberDao();
	
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			//커넥션 풀에서 커넥션 하나를 받음
			conn = ConnectionProvider.getConnection();
			//자동 커밋을 중지시킴
			conn.setAutoCommit(false);
			//memberDao의 selectById 메소드(id를 사용해서 해당 회원 정보를 추출: select * from member where id = userId)를
			//실행하고 결과로 Member 객체를 반환 받음
			Member member = memberDao.selectById(conn, userId);
//			dao에서 return 받은 결과가 null이면(매개변수로 받은 userId를 id로 갖는 회원이 없다)
			if (member == null) {
				//MemberNotFoundException이라는 사용자 정의 익셉션을 발생시킴
				throw new MemberNotFoundException();
			}
			//Member 객체의 matchPassword 메소드를 실행하여 매개변수로 받은 비번과 객체의 필드에 저장된 비번을 비교하여 결과로 불리언값을 받는다.
			if (!member.matchPassword(curPwd)) { //현재 암호와 db에 저장된 암호가 같지 않은 겨우
				//InvalidPasswordException을 발생시킴
				throw new InvalidPasswordException();
			}
			//Member 객체의 changePassword 메소드 호출: 객체의 비번을 새 비번으로 덮어씀
			member.changePassword(newPwd);
			//memberDao의 update 메소드 호출: 새로운 비번 들고가서 DB에 적용 - 회원정보 수정 
			memberDao.update(conn, member);
			//변경사항 최종 적용
			conn.commit();
		} catch (SQLException e) {
			//JdbcUtil 클래스의 rollback 메소드 호출 - DML 작업 오류 발생시 롤백 실행
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			//
			JdbcUtil.close(conn);
		}
	}
}
