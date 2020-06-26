select * from members; 

select * from members where ID<=5;

--salary가 500이상인 레코드 조회
select * from members where SALARY >= 500; --주석


--salary가 500이상인 id, name ,salary 조회
select id, name , salary from members where salary>=500;
select * from members;

--생일이 90-1-1이후인 레코드 조회
select * from members where birth >= '90-1-1';

--이름이 제시카 인 레코드 조회
select * from members where name = '제시카';

--이름이 제시카가 아닌 인 레코드 조회
select * from members where name <>'제시카';
