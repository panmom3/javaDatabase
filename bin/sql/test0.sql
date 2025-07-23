select * from test1;

show databases;

show tables;

-- 테이블 구조보기
desc test1;

create table busan (
	idx int not null auto_increment,  /* idx 자동증가 설정*/
    name varchar(20) not null,
    age int,
	primary key(idx)
);

insert into test1 (name, age) values ('홍길동',30);

select * from busan;

insert into busan (name, age) values ('홍길동',30);
insert into busan values (default,'홍길동',40);
insert into busan values (default,'이기자',60);
insert into busan values (default,'오나라',40);
insert into busan values (default,'강동원',35);
insert into busan values (default,'유재석',50);
insert into busan values (default,'마동석',40);

-- 필드 추가(add column)
alter table busan add column job char(10);
desc busan;
-- 필드 속성 변경(modify column)
alter table busan modify column job char(15);
desc busan;

-- 필드명 변경(change column)
alter table busan change column job work varchar(20);
desc busan;

-- 필드 삭제(drop colomn)
alter table busan drop column work;

-- test1테이블에 성별필드(gender(char(2) default '여자') 추가
alter table test1 add column gender char(2) default '여자';
alter table test1 add column address varchar(10) default '서울';

insert into test1 values ('아톰',default,default,'',default,'청주');
insert into test1 values ('비통',45,'2022-1-1','회사원','남자','청주');
insert into test1 values ('씨톰',23,default,'자영업','남자','청주');
insert into test1 values ('이톰',65,'1900-3-1','의사','여자','부산');
insert into test1 values ('강톰',22,default,'아이돌','남자','청주');
insert into test1 values ('홍나순',default,default,'',default,'제주');
insert into test1 values ('나순식',default,default,'',default,'인천');
insert into test1 values ('순식나',default,default,'',default,'제주');
insert into test1 values ('강순식나',40,default,'',default,'제주');

select * from test1 where name = '홍길동';
select * from test1 where gender = '남자';   /*성별이 남자인 자료만 출력*/
select * from test1 where age < 30;
select * from test1 where age >= 30 and age < 40; /*나이가 30~40미만 자료만 출력*/
select * from test1 where address = '청주';
select * from test1 where job = '회사원';
select * from test1 where job = '회사원' or job = '백수';
select * from test1 where job = '회사원' and age < 30;
select * from test1 where gender = '여자' and address = '서울';
select * from test1 where birthday < '2000-1-1';
select * from test1 where birthday >= '2025-1-1' and birthday <= '2025-12-31';
select * from test1 where job = '회사원' and gender = '남자';
select * from test1 where name like '이%';      /*'이'로 시작하는사람 찾기*/
select * from test1 where name like '%톰';
select distinct * from test1 where name like '%톰';   /*DISTINCT: 중복되는 행을 제외하고, 고유한 결과만 반환*/
select * from test1 where name like '%나%' and address = '인천';  /*'나'가 포함된 이름 모두 찾음*/
select * from test1 where age >= 30 and age < 40;
select * from test1 where age between 30 and 39;     /*30대 범위 출력*/
select * from test1 where address = '청주' or address = '제주';
select * from test1 where address in('청주','제주');    /*'청주'와 '제주' 필드 출력*/

select name as 이름,age as 나이,address as 주소 from test1 where address in('청주','제주');  /*as 별명짓기*/

-- update 테이블 set 필드명='변경할값' where 조건식;
-- 이기자의 주소를 '부산'으로 변경
update test1 set address='부산' where name = '이기자';

-- 나이가 20대 서울인 자료?
select * from test1 where age between 20 and 29 and address = '서울';

-- 나이가 20대 서울인 자료에 대하여 성별을 '남자'로 변경?
update test1 set gender = '남자' where age between 20 and 29 and address = '서울';

-- 나이가 20대 서울인 자료에 대하여 나이를 1살씩 추가한다?
update test1 set age = age+1 where age between 20 and 29 and address = '서울';

-- 서울에 사는 직업이 '장군'??
select * from test1 where address = '서울' and job = '장군';

-- 서울에 사는 직업이 '장군'인 자료를 삭제하세요??
delete from test1 where address = '서울' and job = '장군';

rename table test2 to test1;

show tables;

select * from test1;

-- 성명 오름차순 정렬?
select * from test1 order by name;

-- 나이 내림차순 정렬?
select * from test1 order by age desc;

-- 성별 오름차순 정렬?
select * from test1 order by gender;

-- 성별 오름차순, 성별이 같으면 나이가 많은 사람순 정렬?
select * from test1 order by gender, age desc;

-- 서울에 사는 사람 5명만 보여줘
select * from test1 where address = '서울' limit 5;