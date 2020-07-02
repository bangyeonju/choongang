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




