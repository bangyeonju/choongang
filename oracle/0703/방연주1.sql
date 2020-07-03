  show serveroutput
  set serveroutput on

declare
begin
 for i in 1..10 loop
  dbms_output.put_line(i);
 end loop;
 end;
 
 
 declare 
 vsum number :=0;
 begin
 for i in 1..10 loop
   vsum := i+vsum;
 end loop;
   dbms_output.put_line('합계:' || vsum); 
 end;
       
 
 declare 
 begin
--for문안에서 변수선언안해도된다. 
 for i in 1..100 loop 
 if mod(i,5)=0 and mod(i,7)=0 then
 dbms_output.put_line(i);
 end if;
 end loop;
 end;
 
declare
begin
 for i in 1..10 loop
  dbms_output.put_line(i);
 end loop;
 end;
 
 declare 
 begin 
  for i in 1..100 loop
    if mod(i,3)=0 and mod(i,7)=0 then
    dbms_output.put_line(i);
    end if;
  end loop;
  end;
  
declare
begin

 for i in reverse 1..9 loop
  dbms_output.put_line(3||'*'||i||'='||3*i);
  
 end loop;
 
 end;
  
  select * from emp;
  
  
  
declare 
begin
for i in (select empno,ename from emp) loop
  dbms_output.put_line(i.empno || ',' || i.ename);
end loop;
end;


declare
vmax emp.empno%type;

begin
select max(empno) 
into vmax
from emp;
for i in 1..3 loop

 vmax:= vmax+1;
   insert into emp values(vmax,'하니',30,3000);

end loop;
end;

declare 
--  i number := 0;
  i number default 0;
  begin
  while i<9 loop
  exit when i=5;
  DBMS_OUTPUT.PUT_LINE(i);
  i := i+1;
  end loop;
  end;

declare
  i number :=1;
  j number :=1;
begin
    loop
      j := 1;
      loop
        dbms_output.put_line(i||'/'||j);      
        j := j+1;
        exit when j =3;
      end loop;
      i := i+1;
      exit when i=4;
    end loop;
end;

declare
begin
  for i in 1..3 loop
    for j in 1..2 loop
      dbms_output.put_line(i||'/'||j);
    end loop;
  end loop;
end;

declare
   i number :=1;
   j number :=1;
begin
for i in 2..9 loop
 dbms_output.put_line(i||'단');
    for j in 1..9 loop
      dbms_output.put_line(i||'*'||j||'='||i*j);
    end loop;
     dbms_output.put_line('');
  end loop;
end;

--public int test(){
--  int x=100,y=200;
--  return x+y;
--}



create or replace function test
return number as
  x number;
  y number;
begin
  x:=100;
  y:=200;
  return x+y;
end;

select test from dual;
--------------------------------------------------------------------------
select count(*) from members;

create or replace function test2
return number as
--선언
cnt number;
begin
  select count(*) 
  into cnt
  from members;
  return cnt;
end test2;

select test2 from dual;
--------------------------------------------------------------------------------
create or replace function test3(a number,b number)
return number as
--선언
begin
return a*b;
--return a*b; 첫번째만난 return만 ..
end;
select test3('가','나') from dual;--300



create or replace function tax(vsal members.salary%type)
return number as

begin
if vsal >= 1000 then
  return vsal * 0.1;
  elsif vsal >=500  then
   return vsal * 0.05;
  else
   return vsal * 0.03;
  end if;

end;

select id,name,salary,tax(salary) from members;
create or replace function deptname(vdno emp.deptno%type)
return  as
  vdname varchar2(10);
begin
if vdno=10 then

elsif vdno=20 then

elsif vdno=30 then

else
  
end if;
end;


select * from emp;
select empno,ename,deptno,deptname(deptno) from emp;

