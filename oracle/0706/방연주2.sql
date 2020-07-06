select * from members;
declare 
 vdept varchar2(10);
vaddr members.addr%type;
 vgender members.gender%type;
 vcount number;
begin
select dept, addr, gender,count(*)
into vdept, vaddr, vgender, vcount
from members
where dept='������' and addr ='����' and gender='����'
group by dept,addr,gender;
dbms_output.put_line(vdept||','||vaddr||','||vgender||','||vcount);
end;

declare 
begin
 for i in (select id,name,birth from members where birth>='90-1-1'and birth<='99-12-31') loop
  dbms_output.put_line(i.id||','||i.name||','||i.birth);
  end loop;
end;


select * from book;
declare
vinput number := '&no';
vday BOOK.DAY%type;
vprice BOOK.PRICE%type;
vno book.price%type;
vsalary book.price%type;
begin
select no, day,price
into vno,vday,vprice
from book
where no=vinput;
vsalary := vprice;
if vinput=vno then
  if vday <'89-12-31' and vday>'80-01-01' then
  vprice := vprice - vprice * 0.2;
 elsif vday <'99-12-31' and vday>'90-01-01' then
 vprice := vprice - vprice * 0.1;
  else
  vprice := vprice - vprice * 0.05;
 end if;
 end if;
  dbms_output.put_line(vday || ','||vsalary||'=>' ||vprice);
end;


select * from book;
create or replace procedure update_price(vno number)
as 
vpub varchar2(20);
begin 
select publisher
into vpub
from book
 where no = vno;
 if vpub='���е���' then
  update book set price = price +100 where no = vno;
 elsif vpub='â�۰� ����'then
 update book set price = price +200 where no = vno;
 elsif vpub='���а� ����' then
 update book set price = price +300 where no = vno;
 end if;
end;
execute update_price(4);
select * from book;

declare
begin
for i in 1..5 loop
  for j in 1..i  loop
  dbms_output.put('*');
  end loop;
  dbms_output.put_line('');
end loop;
end;

select * from members;

create or replace function old_birth
return date as
--����
vmin date;

begin 
  select min(birth)
  into vmin
  from members;
  return vmin;
end;

select old_birth from dual;

-- Ŀ�� : ������� ����Ű�� ������ ����

select * from emp;
declare 
cursor sel_cursor is
  select empno,ename
  from emp; -- Ŀ�� ����
  vempno emp.empno%type;
  vename emp.ename%type;
begin
  open sel_cursor; -- Ŀ�� ����
  loop
  fetch sel_cursor into vempno, vename;
  exit when sel_cursor%notfound;
  dbms_output.put_line(vempno||','|| vename);
  end loop;
  --����
  close sel_cursor;

end;
select * from emp;



declare 
 vemp emp%rowtype;
 
cursor sel_cursor is
  select *
  from emp; -- Ŀ�� ����
begin
  for vemp in sel_cursor loop
  exit when sel_cursor%notfound;
    dbms_output.put_line(vemp.empno||','||vemp.ename);
 end loop;
   end;








declare
 i number := 0;
begin
  i := 10/0;
  dbms_output.put_line('succuess');
  exception when others then
  dbms_output.put_line('�����߻�');
end;

declare 
vename emp.ename%type;
begin
  select ename
  into vename
  from emp
   where ename like '��%';
   dbms_output.put_line(vename);
  exception 
  when no_data_found then
  dbms_output.put_line('�ش����� ��������.');
  when too_many_rows then
  dbms_output.put_line('�ش����� 2�� �̻��Ԥ���.');
end;


