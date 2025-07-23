show tables;

desc test1;

select * from test1;

create table test2 (
	idx int not null auto_increment primary key,   /* 기본키 */
	name varchar(20) null,										     /* 성명 */
	age int																				/* 나이 */
);

drop table test2;
