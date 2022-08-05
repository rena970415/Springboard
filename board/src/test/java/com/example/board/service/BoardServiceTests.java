package com.example.board.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService boardService;
	
	@Test
	public void sericeTest() {
		log.info(boardService);
	}
	
//	@Test
//	public void registerTest() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("새로 작성한 글제목");
//		boardVO.setContent("새로 작성한 글 내용");
//		boardVO.setWriter("hong1");
//		
//		boardService.register(boardVO);
//		log.info("생성된 게시글 번호 : " + boardVO.getBno());
//	}
	
//	@Test
//	public void getTest() {
//		BoardVO boardVO = boardService.get(8L);
//		if(boardVO != null) {
//			log.info(boardVO);
//			return;
//		}
//		log.info("no BOARD");
//	}
	
//	@Test
//	public void modifyTest() {
//		BoardVO boardVO = boardService.get(0L);
//		if(boardVO == null) {log.info("NO BOARD"); return;}
//		boardVO.setTitle("신규 등록!");
//		boardVO.setContent("신규로 등록된 게시글입니다.");
//		
//		if(boardService.modify(boardVO)) {
//			log.info("UPDATE SUCCESS!");
//			return;
//		}
//		log.info("UPDATE RAILURE!");
//	}
	
	
//	@Test
//	public void removeTest() {
//		BoardVO boardVO = boardService.get(8L);
//		if(boardVO == null) {log.info("no Board"); return;}
//		
//		if(boardService.remove(boardVO.getBno())) {
//			log.info("삭제 성공!");
//			return;
//		}
//		log.info("삭제 실패");
//		
//	}
//	
//	@Test
//	public void getListTest() {
//		boardService.getList().forEach(log::info);
//	}
	
	
	
	
	
}
