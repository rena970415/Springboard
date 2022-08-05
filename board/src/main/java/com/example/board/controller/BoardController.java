package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.domain.vo.BoardVO;
import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("/list");
		model.addAttribute("boardList", boardService.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("/register : " + boardVO);
		boardService.register(boardVO);
		
		// Flash 라는 영역은  session에 생기고, redirect로 전송할 때 , request영역이 초기화 된다.
		// 초기화 되기 전에 Flash영역에 데이터를 저장해놓고, 초기화된 후 Flash영역에서 데이터를 가지고 온다.
		// 데이터를 가져왔다면, Flash 영역에 있던 데이터는 없어진다.
		rttr.addFlashAttribute("bno", boardVO.getBno());
		//redirect로 전송할 때에는 경로 앞에 "redirect:"을 붙여준다.
		return "redirect:/board/list";
	}
	
	
	
	
}
