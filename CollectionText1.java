package com.human.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Rectangle implements Comparable<Rectangle>{
	public double width, height;
	
	public double area() {
		return width*height;
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
//		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
//			return false;
//		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
//			return false;
		
		if(this.width*this.height==other.width*other.height) {
			return true;
		}else {
			return false;
		}
		//넓이가 같으면 같은 객체로 인식
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	//주석하고 출력하면 해시코드가 출력됨

	@Override
	public int compareTo(Rectangle other) {
		//넓이를 이용해서 정렬
		//-1==교환필요,  0==같음, 1==교환필요없음
		int returnValue=0;
		if(this.area()==other.area()) {
			returnValue=0;
		}else if(this.area()>other.area()){
			returnValue=-1;
		}else if(this.area()<other.area()) {
			returnValue=1;
		}
		//this와 other를 비교해서 this가 클때 -1이 리턴되면 내림차순 정렬
		//this와 other를 비교해서 this가 클때 1이 리턴되면 내림차순 정렬
		return returnValue;
	}
}

class RectangleWidthAsc implements Comparator<Rectangle> {

	@Override
	public int compare(Rectangle arg0, Rectangle arg1) {
		int returnValue=0;
		if(arg0.width>arg1.width) {
			returnValue=1;
		}else if(arg0.width<arg1.width) {
			returnValue=-1;
		}else {
			returnValue=0;
		}
		return returnValue;
	}
	
}
public class CollectionText1 {

	public static void main(String[] args) {
		//컬렉션을 사용하려면 equals랑 해시코드를 재정의 해야한다.
		
		//int String 잘 돌아감
		//우리가 만든 클래스의 문제점
		System.out.println(new Rectangle(10,20));
		
		ArrayList<Rectangle> arrList=new ArrayList<Rectangle>();
		arrList.add(new Rectangle(10,10));
		arrList.add(new Rectangle(11,11));
		arrList.add(new Rectangle(11,12));
		arrList.add(new Rectangle(12,12));
		arrList.add(new Rectangle(13,13));
		arrList.add(new Rectangle(14,14));
		arrList.add(new Rectangle(14,12));
		arrList.add(new Rectangle(13,20));
		for(int i=0;i<arrList.size();i++) {
			System.out.println(arrList.get(i));
		}
		arrList.remove(1);
		arrList.remove(new Rectangle(12,12));
//		arrList.remove(new Rectangle(12,11));
		//같은 (12,12)여도 주소가 달라서 삭제가 안됨
		//equals()메소드 추가해야함
		System.out.println("----------------------");
		for(int i=0;i<arrList.size();i++) {
			System.out.println(arrList.get(i));
		}
		System.out.println("----------------------");
		for(Rectangle r:arrList) {
			System.out.println(r);
		}
		System.out.println("----------------------");
		Rectangle rect = new Rectangle(15,15);
		arrList.add(rect);
		arrList.remove(rect);
		for(Rectangle r:arrList) {
			System.out.println(r);
		}
		
		//객체 정렬
		//compareTo  ,  compare
		//compareTo -->comparable 인터페이스 
		//매개변수 1개 : 자기자신 매개변수 비교
		//compare -->comparator 인터페이스
		//매개변수 2개: 매개변수 2개 비교
		//재정의해야 sort 구현 가능
		System.out.println("----------------------");
		Collections.sort(arrList);
		for(Rectangle r:arrList) {
			System.out.println(r);
		}
		//width로 혹은 height로 정렬할땐?
		//콤마 뒤 익명클래스
		//매번 메소드로 정렬할 수 없으니 메인클래스안에서 익명클래스로 정렬함
		Collections.sort(arrList, new Comparator<Rectangle>() {

			@Override
			public int compare(Rectangle arg0, Rectangle arg1) {
				int returnValue=0;
				if(arg0.width>arg1.width) {
					returnValue=-1;
				}else if(arg0.width<arg1.width) {
					returnValue=1;
				}else {
					returnValue=0;
				}
				return returnValue;
			}
			
		});
		System.out.println("----------------------");
		for(Rectangle r:arrList) {
			System.out.println(r);
		}
		System.out.println("----------------------");
//		Collections.sort(arrList, new RectangleWidthAsc());
		RectangleWidthAsc rAsc=new RectangleWidthAsc();
		Collections.sort(arrList,rAsc);
		for(Rectangle r:arrList) {
			System.out.println(r);
		}
		//람다식
		Collections.sort(arrList,(a,b)->{
			int returnValue=0;
			if(((Rectangle)a).height<((Rectangle)b).height) {
				returnValue=1;
			}else if(((Rectangle)a).height>((Rectangle)b).height) {
				returnValue=-1;
			}
			return returnValue;
		});
			System.out.println("---------------");
			for(Rectangle r:arrList) {
			System.out.println(r);
			}

//		Comparator<Rectangle> com = new Comparator<Rectangle>() {
//
//			@Override
//			public int compare(Rectangle o1, Rectangle o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		};
			
		//학생객체를 만들어서 국어순위 영어순위 수학순위 평균순위를 입력받아 출력하는 프로그램
			//학생성적관리하는 프로그램
	}

}
