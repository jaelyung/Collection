package com.human.ex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class EngDesc implements Comparator<Student>{
	
	@Override
	public int compare(Student o1, Student o2) {
		int returnValue=0;
		if(o1.eng>o2.eng) {
			returnValue=-1;
		}else if(o1.eng<o2.eng) {
			returnValue=1;
		}else {
			returnValue=0;
		}
		return returnValue;
	}
	
}

class MathDesc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int returnValue=0;
		if(o1.math>o2.math) {
			returnValue=-1;	
		}else if(o1.math<o2.math) {
			returnValue=1;
		}else {
			returnValue=0;
		}
		return returnValue;
	}
	
}

class AveDesc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int returnValue=0;
		if(o1.ave()>o2.ave()) {
			returnValue=-1;	
		}else if(o1.ave()<o2.ave()) {
			returnValue=1;
		}else {
			returnValue=0;
		}
		return returnValue;
	}
	
}
public class Student implements Comparable<Student>{
	public String id;
	public String pw;
	public int kor,eng,math;
	
	public Student(String id, String pw) {
		this.id=id;
		this.pw=pw;
	}
	
	public Student(int kor, int eng, int math) {
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	public double ave() {
		return (kor+eng+math)/3;
	}
	
	@Override
	public int compareTo(Student other) {
		int returnValue=0;
		if(this.kor>other.kor) {
			returnValue=-1;
		}else if(this.kor<other.kor) {
			returnValue=1;
		}else {
			returnValue=0;
		}
		return returnValue;
	}
	
	
}
