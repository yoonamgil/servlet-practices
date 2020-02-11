package com.douzone.guestbook.dao.test;

import java.util.List;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;

public class GuestBookDaoTest {

	public static void main(String[] args) {
		System.out.println("********************");
	//	insertTest();
		selectTest();

	}
	public static void selectTest() {
		List<GuestBookVo>list=new GuestBookDao().findAll();
		for(GuestBookVo vo : list) {
			System.out.println(vo);
			
		}
	}
	public static void insertTest(GuestBookVo vo) {
		
		new GuestBookDao().insert(vo);
		
	}
	public static void deleteTest(GuestBookVo vo) {
		
		new GuestBookDao().delete(vo);
		
	}

}
