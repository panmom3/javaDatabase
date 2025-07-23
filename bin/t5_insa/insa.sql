show tables;

create table insa (
	idx int not null auto_increment primary key,
	name varchar(20) not null,
	age int default 20,
	gender char(2) default '여자',
	ipsail datetime default now()
);

desc insa;

insert into insa values (default, '홍길동', default, '남자', default);
insert into insa values (default, '김말숙', 30, default, '2020-5-10');
insert into insa values (default, '오하늘', default, '여자', default);

select * from insa;