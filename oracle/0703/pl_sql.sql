show serveroutput
set serveroutput on

declare
  x number;
begin
  x := 100;  
  dbms_output.put('��=');
  dbms_output.put_line(x);  
  dbms_output.put_line('��=' || x);
end;


declare
 x number;
 y number;
 z number;
 name varchar2(10);
begin
  name:='����';
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
insert into emp values(8000,'����',10,1000);
insert into emp values(8001,'���',20,2000);
commit;
select * from emp;

drop table dept;
create table dept(
	deptno number primary key,
	dname varchar2(10)
);
insert into dept values(10,'ȫ����');
insert into dept values(20,'�λ��');
insert into dept values(30,'������');
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
  dbms_output.put_line('�ְ� �޿�:' || vmax);
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

-- �μ��� ����� 1000�̻��� ���ڵ� ��������
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
--  ���� ū empno�����ͼ� +1 ������ insert �ϱ�
  select max(empno) 
  into vmax
  from emp;
  
  insert into emp
  values(vmax+1,vename,vdeptno,vsalary);
end;
commit;


-----------------------------------------
--empno �Է¹޾� ����
select * from emp;
declare
  vinput number := '&��ȣ';
begin
  delete from emp where empno=vinput;
end;
rollback;
-----------------------------------------
--4���� �Է�,�����ȣ�� �������� ������ 3���� ����
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
    result :='�� ���� ��';   
  end if;
  dbms_output.put_line(result);
end;

-------------------------------------
select * from emp;
--�����ȣ �Է� : 8002
--10:�λ��
--20:������
--30:������
--�¿��� �������Դϴ�.

declare
  vinput number := '&no'; 
  vename varchar2(10);
  vdeptno number;
  vdname varchar2(10);
begin
  select ename, deptno -- �¿�, 30
  into vename, vdeptno
  from emp
  where empno = vinput;
--  dbms_output.put_line(vename ||',' || vdeptno); --�¿�, 30
  
  if vdeptno = 10 then
    vdname := '�λ��';
  elsif vdeptno = 20 then
    vdname := '������';
  elsif vdeptno = 30 then
    vdname := '������';  
  end if;
  dbms_output.put_line(vename ||',' || vdname);
end;

-----------------------------------------------------

--ID�� �Է��ؼ� salary ��������
-->=1000 vtax(����) : salary�� 10%
--500~999 salary:5%
--300~499 salary:3%
--�� ���� salary:1%
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
  when 10 then vdname :='������';
  when 20 then vdname :='ȫ����';
  when 30 then vdname :='�ѹ���';
  else vdname :='�߸��Է�';
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
  when 10 then '������'
  when 20 then 'ȫ����'
  when 30 then '�ѹ���'
  else '�߸��Է�'
  end;
  dbms_output.put_line(vdname);
end;

-----------------------------------
select * from emp;
--�����ȣ �Է¹޾� �̸�,salary �������� ������ ��� ���

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
  dbms_output.put_line('loop ��');
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
--1~10 ���� �հ�

declare
  vsum number := 0;
begin
  for i in 1..10 loop
    vsum := vsum + i;
  end loop;
  dbms_output.put_line('�հ�:' || vsum);
end;

--------------------------------------------------

--1~100������ �� �� 5�� ����̸鼭 7�� ����� �� ���
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
    insert into emp values(vmax,'�ϴ�',30,3000);
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

--for loop ���

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
    dbms_output.put_line('***' || i || '��***');
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
--����

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

--drop table ���̺��;
--drop function �Լ���;

create or replace function deptname(vdeptno emp.deptno%type)
return varchar2 as
begin
--  if vdeptno=10 then
--    return 'ȫ����';
--  elsif vdeptno=20 then
--    return '�λ��';
--  elsif vdeptno=30 then
--    return '������';
--  else
--    return '�ѹ���';
--  end if;
  case(vdeptno)
  when 10 then return 'ȫ����';
  when 20 then return '�λ��'; 
  when 30 then return '������';
  else return '�ѹ���';
  end case;
end;
select empno, ename, deptno, deptname(deptno) from emp;

--10 : ȫ����
--20 : �λ��
--30 : ������
--�� ���� ��ȣ : �ѹ���
--
--8000 ���� 10 ȫ����
--8001 ��� 20 �λ��

----------------------------------------------------
--function : �����Ѵ�.
--procedure : ���� ���Ѵ�.

select * from members;
create or replace procedure raise_salary(vid number)
is
begin
  update members set salary = salary * 1.1 where id = vid;
end;

--select raise_salary from dual;
execute raise_salary(3);
rollback;






