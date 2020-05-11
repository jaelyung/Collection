package com.human.ex;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	public static int totalCount=0;
	public ArrayList<Student> students = new ArrayList<Student>();
	public Student[] user=new Student[10];
	public int userCount=0;
	public int userCurrent=-1;
	
	public StudentManager() {
		totalCount++;
	}
	
	public void accountAdd() {
		Scanner sc=new Scanner(System.in);
		System.out.println("���ϴ� ���̵� �Է�>>");
		String id=sc.nextLine();
		if(isId(id)) {
			System.out.println("�ߺ��� ���̵��Դϴ�.");
			return;
		}
		System.out.println("���ϴ� ��й�ȣ �Է�>>");
		String pw=sc.nextLine();
		user[userCount++]=new Student(id,pw);
		
	}
	
	private boolean isId(String id) {
		boolean returnValue=false;
		for(int i=0;i<userCount;i++) {
			if(user[i].id.equals(id)) {
				returnValue=true;
			}
		}
		return returnValue;
	}
	
	public void inputScore() {
		Scanner sc=new Scanner(System.in);
		System.out.println("���� ���� �Է�>>");
		int kor=Integer.parseInt(sc.nextLine());
		System.out.println("���� ���� �Է�>>");
		int eng=Integer.parseInt(sc.nextLine());
		System.out.println("���� ���� �Է�>>");
		int math=Integer.parseInt(sc.nextLine());
		students.add(new Student(kor,eng,math));
	}
}
