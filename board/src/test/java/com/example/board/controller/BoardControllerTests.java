package com.example.board.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.board.domain.vo.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void listTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list").param("pageNum", "52").param("amount", "10")).andReturn().getModelAndView().getModelMap());
	}
	
//	@Test
//	public void registerTest() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "테스트 새 글 제목")
//				.param("content", "테스트 새 글 내용")
//				.param("writer", "hong3")
//				).andReturn().getFlashMap());
//		
//	}
	
//	@Test
//	public void readTest() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
//				.param("bno", "2")
//				).andReturn().getModelAndView().getViewName());
//	}
//	
//	@Test
//	public void removeTest() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
//				.param("bno", "2")
//				).andReturn().getFlashMap());
//	}
	
//	@Test
//	public void modifyTest() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//				.param("bno", "12")
//				.param("title", "수정한 게시글 제목")
//				.param("content",  "수정한 게시글 내용")
//				.param("writer", "bugbug")
//				).andReturn().getFlashMap());
//	}

//	@Test
//	public void goModifyTest() throws Exception{
//		mockMvc.perform(MockMvcRequestBuilders.get("/board/modify")
//				.param("bno", "11")
//				);
//	}
	
	
	
}




