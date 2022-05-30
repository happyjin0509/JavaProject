package article.model;

import java.sql.Date;

public class Article {

	private int letter_id;
	private String title; // 제목
	private String nickname; // 별명
	private String content; // 내용
	private Date regdate; //작성일
	private String photo;  //사진 경로
	private int readCount; //조회수
	private String member_id;
	
	public Article() {}
	
	public Article(String title, String nickname, String content, Date regdate, String photo, String member_id) {
		super();
		this.title = title;
		this.nickname = nickname;
		this.content = content;
		this.regdate = regdate;
		this.photo = photo;
		this.member_id = member_id;
	}
	public Article(int letter_id, String title, String nickname, String content, Date regdate, String photo,
			int readCount, String member_id) {
		super();
		this.letter_id = letter_id;
		this.title = title;
		this.nickname = nickname;
		this.content = content;
		this.regdate = regdate;
		this.photo = photo;
		this.readCount = readCount;
		this.member_id = member_id;
	}

	public int getLetter_id() {
		return letter_id;
	}

	public void setLetter_id(int letter_id) {
		this.letter_id = letter_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "Article [letter_id=" + letter_id + ", title=" + title + ", nickname=" + nickname + ", content="
				+ content + ", regdate=" + regdate + ", photo=" + photo + ", readCount=" + readCount + ", member_id="
				+ member_id + "]";
	} 
	
	


}
