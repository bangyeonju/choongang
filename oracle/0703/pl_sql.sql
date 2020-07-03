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

-----------------------------------
select * from emp;
--사원번호 입력받아 이름,salary 가져오고 변수에 담아 출력

declare
  vinput number := '&no';
  vename emp.ename%type;
  vsalary emp.salary%type;
begin
  select ename,salary
  into vename, vsalary
  from emp
  where empno=vinput;
  dbms_output.put_line(vename || ',' || vsalary);
end;

--------------------------------------------------------

declare
  i number;
begin
  i := 1;
  loop
    dbms_output.put_line('i=' || i);
    exit when i>=10;
    i := i+1;
  end loop;
  dbms_output.put_line('loop 밖');
end;

------------------------------------------------

declare

begin
  for i in 1..10 loop
    dbms_output.put_line(i);
  end loop;
end;

-------
declare

begin
  for i in reverse 1..9 loop
    dbms_output.put_line(3 || '*' || i || '=' || 3*i);
  end loop;
end;

----------------------
--1~10 까지 합계

declare
  vsum number := 0;
begin
  for i in 1..10 loop
    vsum := vsum + i;
  end loop;
  dbms_output.put_line('합계:' || vsum);
end;

--------------------------------------------------

--1~100사이의 수 중 5의 배수이면서 7의 배수인 수 출력
declare 

begin
  for i in 1..100 loop
    if mod(i,5)=0 and mod(i,7)=0 then
      dbms_output.put_line(i);     
    end if;
  end loop;
end;

-------------------------------------------
select * from emp;
declare

begin
  for i in (select empno,ename from emp) loop
    dbms_output.put_line(i.empno || ',' || i.ename);
  end loop;
end;

-------------------------------------------------------
declare
  vmax EMP.EMPNO%type;
begin
  select max(empno)
  into vmax
  from emp;
  --8001
  for i in 1..3 loop
    vmax := vmax + 1 ;
    insert into emp values(vmax,'하니',30,3000);
  end loop;
end;
select * from emp;
commit;

---------------------------------------
declare
  i number default 0;
begin
  while i<9 loop
    exit when i=5;
    dbms_output.put_line(i);
    i := i + 1;
  end loop;
end;

----------------------------------------------
declare 
  i number := 1;
  j number := 1;
begin
  loop
    j := 1;
    loop
      dbms_output.put_line(i || '/' || j);
      j := j+1;
      exit when j=3;
    end loop; 
  
    i := i+1;
    exit when i=4;
  end loop;
end;


--1/1
--1/2
--2/1
--2/2
--3/1
--3/2

--for loop 사용

declare
  i number := 1;
  j number := 1;
begin
  for i in 1..3 loop
    for j in 1..2 loop
      dbms_output.put_line(i || '/' || j);
    end loop;
  end loop;
end;


--2*1=2
--  :
--9*9=81

declare
  i number := 1;
  j number := 1;
begin
  for i in 2..9 loop
    dbms_output.put_line('***' || i || '단***');
    for j in 1..9 loop
      dbms_output.put_line(i || '*' || j || '=' || i*j);
    end loop;
    dbms_output.put_line('');
  end loop;
end;

----------------------------------------------------
--public int test(){
--  int x=100,y=200;
--  return x+y;
--}
--test()

create or replace function test
return number as
  x number;
  y number;
begin
  x := 100;
  y := 200;
  return x + y;
end;

select test from dual;

-----------------------------

select count(*) from members;

create or replace function test2
return number as
cnt number;

begin
  select count(*) 
  into cnt
  from members;
  return cnt;
end test2;

select test2 from dual; -- 12
------------------------------------
--public int test(int a, int b){
--  int x=100,y=200;
--  return x+y;
--}
--test(30,40)
create or replace function test3(a number, b number)
return number as
--선언

begin
  return a+b;
  return a*b;
end;

select test3(100,200) from dual; -- 300




-->=1000 10%
--500~999 5%
--<500 3%

create or replace function tax(
                              vsal members.salary%type
)
return number is
begin
  if vsal >= 1000 then
    return vsal * 0.1;
  elsif vsal >= 500 then
    return vsal * 0.05;
  else
    return vsal * 0.03;
  end if;
end ;


select id, name, salary, tax(salary) from members ;

---------------------------------------------------
select * from emp;

--drop table 테이블명;
--drop function 함수명;

create or replace function deptname(vdeptno emp.deptno%type)
return varchar2 as
begin
--  if vdeptno=10 then
--    return '홍보부';
--  elsif vdeptno=20 then
--    return '인사부';
--  elsif vdeptno=30 then
--    return '연구부';
--  else
--    return '총무부';
--  end if;
  case(vdeptno)
  when 10 then return '홍보부';
  when 20 then return '인사부'; 
  when 30 then return '연구부';
  else return '총무부';
  end case;
end;
select empno, ename, deptno, deptname(deptno) from emp;

--10 : 홍보부
--20 : 인사부
--30 : 연구부
--그 밖의 번호 : 총무부
--
--8000 윤아 10 홍보부
--8001 명수 20 인사부

----------------------------------------------------
--function : 리턴한다.
--procedure : 리턴 안한다.

select * from members;
create or replace procedure raise_salary(vid number)
is
begin
  update members set salary = salary * 1.1 where id = vid;
end;

--select raise_salary from dual;
execute raise_salary(3);
rollback;






