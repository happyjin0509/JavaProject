create database letter;
use letter;

-- 회원
CREATE TABLE member (
	member_id VARCHAR(20) NOT NULL, -- id
	password  VARCHAR(20) NOT NULL, -- 비밀번호
	name      VARCHAR(20) NOT NULL, -- 이름
	email     VARCHAR(20) NOT NULL, -- 이메일
	birthday  DATE        NULL      -- 생일
);

-- 회원
ALTER TABLE member
	ADD CONSTRAINT PK_member -- 회원 기본키
		PRIMARY KEY (
			member_id -- id
		);

-- 편지
CREATE TABLE letter (
	letter_id INT primary key auto_increment, -- id
	title     VARCHAR(100) NOT NULL, -- 제목
	nickname  VARCHAR(20)  NOT NULL, -- 별명
	content   TEXT         NOT NULL, -- 내용
	regdate   datetime     NOT NULL, -- 작성일
	photo     VARCHAR(100) NULL,      -- 사진
    member_id	VARCHAR(20) not null
);
drop table letter;

ALTER TABLE letter
	ADD CONSTRAINT FK_client_TO_member 
		FOREIGN KEY (
			member_id 
		)
		REFERENCES member ( 
			member_id 
		);

insert into member values('aa', 'aa', 'aa', 'aa', '2000-03-01');
insert into member values('bb', 'bb', 'bb', 'bb', '1997-08-03');

select * from member;
delete from member where name = 'bb';

insert into letter(title,nickname,content,regdate,photo,member_id) 
-- values('aaa', 'ja', 'aaaaaaa', now(), '0.jpg', 'aa');
values('bbb', 'haha', 'aaaaaaa', now(), '0.jpg', 'aa');
select * from letter;

commit;    
