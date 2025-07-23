show tables;

create table burgerking (
  idx  int not null auto_increment primary key,	/* 고유번호 */
  part varchar(20) not null,		/* 상품분류 */
  product varchar(30) not null,	/* 상품명 */
  detail  varchar(50) not null,	/* 상품 간단설명 */
  content text,									/* 상품 상세설명 */
  calorie int default 0;				/* 칼로리 */
  image 	varchar(50) not null,	/* 상품이미지(2개, 큰이미지, 작은이미지(_s) */
  price		int not null					/* 상품 가격 */
);
