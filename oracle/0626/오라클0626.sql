select * from members; 

select * from members where ID<=5;

--salary�� 500�̻��� ���ڵ� ��ȸ
select * from members where SALARY >= 500; --�ּ�


--salary�� 500�̻��� id, name ,salary ��ȸ
select id, name , salary from members where salary>=500;
select * from members;

--������ 90-1-1������ ���ڵ� ��ȸ
select * from members where birth >= '90-1-1';

--�̸��� ����ī �� ���ڵ� ��ȸ
select * from members where name = '����ī';

--�̸��� ����ī�� �ƴ� �� ���ڵ� ��ȸ
select * from members where name <>'����ī';
