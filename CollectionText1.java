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
		//���̰� ������ ���� ��ü�� �ν�
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
	//�ּ��ϰ� ����ϸ� �ؽ��ڵ尡 ��µ�

	@Override
	public int compareTo(Rectangle other) {
		//���̸� �̿��ؼ� ����
		//-1==��ȯ�ʿ�,  0==����, 1==��ȯ�ʿ����
		int returnValue=0;
		if(this.area()==other.area()) {
			returnValue=0;
		}else if(this.area()>other.area()){
			returnValue=-1;
		}else if(this.area()<other.area()) {
			returnValue=1;
		}
		//this�� other�� ���ؼ� this�� Ŭ�� -1�� ���ϵǸ� �������� ����
		//this�� other�� ���ؼ� this�� Ŭ�� 1�� ���ϵǸ� �������� ����
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
		//�÷����� ����Ϸ��� equals�� �ؽ��ڵ带 ������ �ؾ��Ѵ�.
		
		//int String �� ���ư�
		//�츮�� ���� Ŭ������ ������
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
		//���� (12,12)���� �ּҰ� �޶� ������ �ȵ�
		//equals()�޼ҵ� �߰��ؾ���
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
		
		//��ü ����
		//compareTo  ,  compare
		//compareTo -->comparable �������̽� 
		//�Ű����� 1�� : �ڱ��ڽ� �Ű����� ��
		//compare -->comparator �������̽�
		//�Ű����� 2��: �Ű����� 2�� ��
		//�������ؾ� sort ���� ����
		System.out.println("----------------------");
		Collections.sort(arrList);
		for(Rectangle r:arrList) {
			System.out.println(r);
		}
		//width�� Ȥ�� height�� �����Ҷ�?
		//�޸� �� �͸�Ŭ����
		//�Ź� �޼ҵ�� ������ �� ������ ����Ŭ�����ȿ��� �͸�Ŭ������ ������
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
		//���ٽ�
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
			
		//�л���ü�� ���� ������� ������� ���м��� ��ռ����� �Է¹޾� ����ϴ� ���α׷�
			//�л����������ϴ� ���α׷�
	}

}
