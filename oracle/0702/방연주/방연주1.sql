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
  name:= '윤아';
  x:=100;
  y:=50;
  z:=x+y;
  dbms_output.put(x);
  dbms_output.put(y);
  dbms_output.put_line(z);
  dbms_output.put_line(x||'+'||y||'='||z);
  dbms_output.put_line(name);
  end;
  
  drop table emp;

create table emp(
	empno number,
	ename varchar2(10),
	deptno number,
  salary number
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


declare
vename emp.ename%type;
vdname dept.dname%type;
begin
 select ename,dname
 into vename,vdname
 from emp ,dept 
where emp.deptno=dept.deptno and emp.empno=8000;
dbms_output.put_line(vename||','||vdname);
end;
 
 
 
 declare
 vdept  members.dept%type;
 vavg members.salary%type;
 begin
 select dept,avg(salary)
 into vdept,vavg
 from members
 group by dept
 having avg(salary)>=1000;
 
 dbms_output.put_line(vdept||','||vavg);
 end;
 

  


declare
vename varchar2(10);
vsalary number;
begin
select ename,salary
into vename, vsalary
from emp
where empno=8000;
  dbms_output.put_line(vename);
  dbms_output.put_line(vsalary);
end;
  

  
  declare
  vid members.id%type;
  vname members.name%type;
  vsalary members.salary%type;
  vbirth members.birth%type;
  
  begin
  select id,name,salary,birth
  into vid,vname,vsalary,vbirth
  from members
  where id=12;
  dbms_output.put_line(vid);
  dbms_output.put_line(vname);
  dbms_output.put_line(vsalary);
  dbms_output.put_line(vbirth);
  end;
  
  
  declare 
  vmax members.salary%type;  
  begin
  select max(salary)
  into vmax
  from members;
  dbms_output.put_line('최고급여:'|| vmax);
  end;
  select * from emp;
  declare
    vno number := '&n';
    vename varchar2(10):='&ename';
    vdeptno number := '&deptno';
    vsalary number := '&salary';
    
  begin
  insert into emp
  VALUES(vno,vename,vdeptno,vsalary);
  end;
  
  
  
  delete members
  where empno=2;
  
  
  
  
  
  
  commit;
  
  
  
  declare
    vno number := '&n';
    vename varchar2(10):='&ename';
    vdeptno number := '&deptno';
    vsalary number := '&salary';
    vmax emp.empno%type;
  begin
  select max(empno)
  into vmax
  from emp;
  
  insert into emp
  VALUES(vmax+1,vename,vdeptno,vsalary);
  end;
  
  select * from emp;
commit;  




declare
vinput NUMBER:='&no';
begin
delete from emp where empno=vinput;
end;
 
rollback;


declare
    vno number := '&n';
    vename varchar2(10):='&ename';
    vdeptno number := '&deptno';
    vsalary number := '&salary';
begin
update emp set ename=vename,DEPTNO=vdeptno,SALARY=vsalary
where empno=vno;
end;


declare
x number:=20;
result varchar2(20);
begin
if x=1 then
  result :='one';
  elsif x =2 then 
  result :='two';
  else
  result:='그 밖의 수';
end if;
  dbms_output.put_Line(result);
end;

select * from emp;
------------------------------------------------------------------------
declare
  vinput NUMBER := '&no';
  vename varchar2(10);
  vdeptno number;
  vdname varchar(10);
begin
select ename ,deptno
into vename, vdeptno
from emp
where empno=vinput;
--dbms_output.put_line(vename||','||vdeptno);

if vdeptno = 10 then
vdname:='인사부';
elsif vdeptno = 20 then
vdname:='연구부';
elsif  vdeptno = 30 then
vdname:='영업부';
end if;
dbms_output.put_line(vename||','||vdname);
end;

--아이디입력:3
--=> salary = ?
declare
vinput number := '&no';
vid  members.id%type;
vsalary members.salary%type;
vtax number;

begin
select id,salary 
into vid,vsalary
from members
where id=vinput;
if vsalary >=1000 then
vsalary := vsalary-vsalary*10;
elsif vsalary>=500 and vsalary<=999 then
vsalary := vsalary-vsalary*5;
elsif vsalary>=300 and vsalary<=499 then
vsalary := vsalary-vsalary*3;
else 
vsalary := vsalary-vsalary*1;

end if;
dbms_output.put_Line(vid);
dbms_output.put_Line(vsalary);
end; 












