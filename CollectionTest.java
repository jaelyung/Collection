package com.human.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionTest {

	public static void main(String[] args) {
		ArrayList<Integer> arrList=new ArrayList<Integer>();
		//Integer ������ �ٷ�� wrapperŬ���� 
		//add()�� �߰�
		arrList.add(40);
		arrList.add(30);
		arrList.add(20);
		arrList.add(10);
		//get()�� ����� index�� �� ã��
		for(int i=0;i<arrList.size();i++) {
			System.out.println(arrList.get(i));
		}
		System.out.println("-----------------");
		//size()arrList�� ����
		//remove�� ����
//		arrList.remove(1);//index 1�� ���� - �ش簴ü Integer 30�� ����
//		for(int i:arrList) {
//			System.out.println(i);
//		}
//		System.out.println("-----------------");
//		arrList.remove((Integer)10);//10 ��ü ���� - true�� ����
//		for(int i:arrList) {
//			System.out.println(i);
//		}
		Collections.sort(arrList);
		
		Iterator iter=arrList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("-----------------");
		//ã�� �������� index��ġ ����
		int index=arrList.indexOf((Integer)20); //20�̶� �����͸� �����ִ� �ε���
		System.out.println(index);
		index=arrList.indexOf(30);//�ڵ�����ȯ��
		System.out.println(index);
		//contains ã���� �ϴ� �������� ���� �����ϴ����� Ȯ��
		System.out.println(arrList.contains(10));
		//������ true, ������ false�� ����
		
		//��ü�� �־ �����ϱ�
		
	}

}
