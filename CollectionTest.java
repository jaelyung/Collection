package com.human.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionTest {

	public static void main(String[] args) {
		ArrayList<Integer> arrList=new ArrayList<Integer>();
		//Integer 정수를 다루는 wrapper클래스 
		//add()로 추가
		arrList.add(40);
		arrList.add(30);
		arrList.add(20);
		arrList.add(10);
		//get()을 사용해 index로 값 찾기
		for(int i=0;i<arrList.size();i++) {
			System.out.println(arrList.get(i));
		}
		System.out.println("-----------------");
		//size()arrList의 길이
		//remove로 삭제
//		arrList.remove(1);//index 1을 삭제 - 해당객체 Integer 30이 리턴
//		for(int i:arrList) {
//			System.out.println(i);
//		}
//		System.out.println("-----------------");
//		arrList.remove((Integer)10);//10 객체 삭제 - true가 리턴
//		for(int i:arrList) {
//			System.out.println(i);
//		}
		Collections.sort(arrList);
		
		Iterator iter=arrList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("-----------------");
		//찾는 데이터의 index위치 리턴
		int index=arrList.indexOf((Integer)20); //20이란 데이터를 갖고있는 인덱스
		System.out.println(index);
		index=arrList.indexOf(30);//자동형변환됨
		System.out.println(index);
		//contains 찾고자 하는 데이터의 값이 존재하는지를 확인
		System.out.println(arrList.contains(10));
		//있으면 true, 없으면 false를 리턴
		
		//개체로 넣어서 구현하기
		
	}

}
