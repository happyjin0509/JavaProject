package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import jdbc.JdbcUtil;

public class ArticleDao {

	public int insert(Connection conn, Article article) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into letter "
					+ "(title,content,nickname,regdate, photo, member_id) "
					+ "values (?,?,?,now(),?,?)");
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getNickname());
			pstmt.setString(4, article.getPhoto());
			pstmt.setString(5, article.getMember_id());
			
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				//같은 세션에서 추가된 마지막 데이터의 auto-increment 컬럼값을 가져오는 쿼리
				rs = stmt.executeQuery("select last_insert_id() from letter");
				
				if (rs.next()) {
					//System.out.println("last_inserted_id>>>>>> " + rs.getInt("number"));
					System.out.println("6." + this.getClass() + ">>> last_inserted_id>>>>>> " + rs.getInt(1));
					Integer newNo = rs.getInt(1);
					/*
					 * return new Article(newNo, article.getWriter(), article.getTitle(),
					 * article.getRegDate(), article.getModifiedDate(), 0);
					 */
					return newNo;
				}
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	//Date 타입 일시를 받아서 Timestamp 타입으로 만들어 반환. db에 저장하기 위해
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from letter");
			System.out.println("6. " + this.getClass() + " >>>>> DB 조회: 전체 개수");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Article> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from letter order by regdate desc limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Article> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertArticle(rs));
			}
			System.out.println("9. " + this.getClass() + ">>>> listArticle >>>>> " + result);
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Article convertArticle(ResultSet rs) throws SQLException {
		Article article = new Article();
			article.setLetter_id(rs.getInt("letter_id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setNickname(rs.getString("nickname"));
			article.setPhoto(rs.getString("photo"));
			article.setRegdate(rs.getDate("regdate"));
			article.setReadCount(rs.getInt("read_count"));
			article.setMember_id(rs.getString("member_id"));
		
		return article;
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	public Article selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from article where article_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Article article = null;
			if (rs.next()) {
				article = convertArticle(rs);
			}
			return article;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update article set read_cnt = read_cnt + 1 "+
						"where article_no = ?")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	public int update(Connection conn, int no, String title) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update article set title = ?, moddate = now() "+
						"where article_no = ?")) {
			pstmt.setString(1, title);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
	
	public int delete(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"delete from article where article_no = ?")) {
			pstmt.setInt(1, no);
			
			return pstmt.executeUpdate();
		}
		
	}
}
