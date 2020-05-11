package com.human.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class StudentTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<Student>();
		
		for(int i=0;i<students.size();i++) {
			System.out.println(students.get(i));
		}
		System.out.println("----------------------");
		System.out.println("�������� ������ ����");
		Collections.sort(students);
		for(Student s:students) {
			System.out.println(s);
		}
		Collections.sort(students, new EngDesc());
		System.out.println("----------------------");
		System.out.println("�������� ������ ����");
		for(Student s:students) {
			System.out.println(s);
		}
		
		Collections.sort(students, new MathDesc());
		System.out.println("----------------------");
		System.out.println("�������� ������ ����");
		for(Student s:students) {
			System.out.println(s);
		}
		
		Collections.sort(students, new AveDesc());
		System.out.println("----------------------");
		System.out.println("������� ������ ����");
		for(Student s:students) {
			System.out.println(s);
		}
	}

}
