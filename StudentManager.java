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
		System.out.println("원하는 아이디 입력>>");
		String id=sc.nextLine();
		if(isId(id)) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		System.out.println("원하는 비밀번호 입력>>");
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
		System.out.println("국어 점수 입력>>");
		int kor=Integer.parseInt(sc.nextLine());
		System.out.println("영어 점수 입력>>");
		int eng=Integer.parseInt(sc.nextLine());
		System.out.println("수학 점수 입력>>");
		int math=Integer.parseInt(sc.nextLine());
		students.add(new Student(kor,eng,math));
	}
}
