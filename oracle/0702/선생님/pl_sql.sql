show serveroutput
set serveroutput on

declare
  x number;
begin
  x := 100;  
  dbms_output.put('값=');
  dbms_output.put_line(x);  
  dbms_output.put_line('값=' || x);
end;


declare
 x number;
 y number;
 z number;
 name varchar2(10);
begin
  name:='윤아';
  x:=100;
  y:=50;
  z:=x+y;
  dbms_output.put(x);
  dbms_output.put(y);
  dbms_output.put_line(z);
  dbms_output.put_line(x || '+' || y || '=' || z);
  dbms_output.put_line(name);
end;

drop table emp;
create table emp(
	empno number,
	ename varchar2(10),
	deptno number,
  salary number -- 
);
insert into emp values(8000,'윤아',10,1000);
insert into emp values(8001,'명수',20,2000);
commit;
select * from emp;

drop table dept;
create table dept(
	deptno number primary key,
	dname varchar2(10)
);
insert into dept values(10,'홍보부');
insert into dept values(20,'인사부');
insert into dept values(30,'연구부');
commit;
select * from dept;

---------------------------------------------------

declare
  vename varchar2(10);
  vsalary number;
begin
  select ename,salary
  into vename, vsalary
  from emp
  where empno = 8000;
  
  dbms_output.put_line(vename);
  dbms_output.put_line(vsalary);
end;
-----------

declare
vid members.id%type;
vname members.name%type; 
vsalary members.salary%type; 
vbirth members.birth%type;

begin
  select id, name, salary, birth
  into vid, vname,vsalary, vbirth
  from members
  where id=12;
  dbms_output.put_line(vid);
  dbms_output.put_line(vname);
  dbms_output.put_line(vsalary);
  dbms_output.put_line(vbirth);
  
end;

----------------------------------------------
declare
 vmax members.salary%type;
begin
  select max(salary)
  into vmax
  from members;
  dbms_output.put_line('최고 급여:' || vmax);
end;

-------------------------------------------

select * from emp;
select ename,dname
from emp, dept
where emp.DEPTNO = dept.deptno;

declare
vename emp.ename%type;
vdname dept.dname%type;
begin
  select ename,dname
  into vename,vdname
  from emp, dept
  where emp.DEPTNO = dept.deptno and emp.EMPNO=8000;
  dbms_output.put_line(vename || ',' || vdname);
end;

-------------------------------------------------

select dept, avg(salary)
from members
group by dept;

-- 부서별 평균이 1000이상인 레코드 가져오기
declare
vdept members.dept%type;
vavg  members.salary%type;
begin
  select dept, avg(salary)
  into vdept,vavg
  from members
  group by dept
  having avg(salary) >= 1000;
  
  dbms_output.put_line(vdept || ',' || vavg);
end;

-----------------------------------------------------------
select * from emp;
declare
  vno number := '&no';
  vename varchar2(10) := '&ename';
  vdeptno number := '&deptno' ;
  vsalary number := '&salary';
begin
  insert into emp
  values(vno,vename,vdeptno,vsalary);
end;
commit;
------------------------------------------------

select * from emp;
declare
  vno number ;
  vename varchar2(10) := '&ename';
  vdeptno number := '&deptno' ;
  vsalary number := '&salary';
  vmax emp.empno%type;
begin
--  가장 큰 empno가져와서 +1 값으로 insert 하기
  select max(empno) 
  into vmax
  from emp;
  
  insert into emp
  values(vmax+1,vename,vdeptno,vsalary);
end;
commit;


-----------------------------------------
--empno 입력받아 삭제
select * from emp;
declare
  vinput number := '&번호';
begin
  delete from emp where empno=vinput;
end;
rollback;
-----------------------------------------
--4가지 입력,사원번호를 조건으로 나머지 3가지 수정
select * from emp;
declare
  vno number := '&no';
  vename varchar2(10) := '&ename';
  vdeptno number := '&deptno' ;
  vsalary number := '&salary';
begin
  update emp set ename=vename, deptno=vdeptno, salary=vsalary 
  where empno=vno;
end;
commit;

--------------------------------------

declare
  x number := 20;
  result varchar2(20);
begin
  if x=1 then
    result := 'one';
  elsif x = 2 then
    result := 'two';
  else
    result :='그 밖의 수';   
  end if;
  dbms_output.put_line(result);
end;

-------------------------------------
select * from emp;
--사원번호 입력 : 8002
--10:인사부
--20:연구부
--30:영업부
--태연은 영업부입니다.

declare
  vinput number := '&no'; 
  vename varchar2(10);
  vdeptno number;
  vdname varchar2(10);
begin
  select ename, deptno -- 태연, 30
  into vename, vdeptno
  from emp
  where empno = vinput;
--  dbms_output.put_line(vename ||',' || vdeptno); --태연, 30
  
  if vdeptno = 10 then
    vdname := '인사부';
  elsif vdeptno = 20 then
    vdname := '연구부';
  elsif vdeptno = 30 then
    vdname := '영업부';  
  end if;
  dbms_output.put_line(vename ||',' || vdname);
end;

-----------------------------------------------------

--ID를 입력해서 salary 가져오기
-->=1000 vtax(세금) : salary의 10%
--500~999 salary:5%
--300~499 salary:3%
--그 이하 salary:1%
--
--Id:3 salary:2050 vtax:205

declare
  vinput number := '&no';
  vtax number;
  vid members.id%type;
  vsalary members.salary%type;
begin
  select id, salary
  into vid, vsalary
  from members
  where id = vinput;
  
  if vsalary>=1000 then
    vtax := vsalary * 0.1;
  elsif vsalary>=500 then
    vtax := vsalary * 0.05;
  elsif vsalary>=300 then
    vtax := vsalary * 0.03;
  else
    vtax := vsalary * 0.01;
  end if;
  dbms_output.put_line(vid || ',' ||  vsalary|| ',' ||  vtax);
end;

--------------------------------------------------------
declare
  vdeptno number := '&no';
  vdname varchar2(20);
begin
 case(vdeptno)
  when 10 then vdname :='연구부';
  when 20 then vdname :='홍보부';
  when 30 then vdname :='총무부';
  else vdname :='잘못입력';
  end case;
  dbms_output.put_line(vdname);
end;
-------------------------------------------------

declare
  vdeptno number := '&no';
  vdname varchar2(20);
begin
vdname :=
 case(vdeptno)
  when 10 then '연구부'
  when 20 then '홍보부'
  when 30 then '총무부'
  else '잘못입력'
  end;
  dbms_output.put_line(vdname);
end;




