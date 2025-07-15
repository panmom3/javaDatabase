show tables;

create table hoewon (
	idx int not null auto_increment primary key,
	name varchar(20) not null,
	age int default 20,
	gender char(2) default '여자',
	address varchar(30)
);

desc hoewon;

insert into hoewon values(default,'홍길동',25,'남자','서울');
insert into hoewon values(default,'이세희',30,'여자','서울');
insert into hoewon values(default,'이나영',45,'여자','인천');
insert into hoewon values(default,'강하늘',23,default,'서울');
insert into hoewon values(default,'원빈',40,'남자','서울');
insert into hoewon values(default,'강동원',45,'남자','부산');
insert into hoewon values(default,'김연아',35,'여자','서울');
insert into hoewon values(default,'고인돌',50,'남자','강릉');
insert into hoewon values(default,'대나무',40,'남자','서울');
insert into hoewon values(default,'소나무',35,'여자','제주');

select * from hoewon;

select * from hoewon where name = '홍길동';

delete from hoewon;
drop table hoewon;