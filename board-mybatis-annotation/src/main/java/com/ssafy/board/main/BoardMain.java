package com.ssafy.board.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.board.controller.BoardController;
import com.ssafy.board.model.BoardDto;

public class BoardMain {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BoardController boardController = new BoardController();
		BoardDto boardDto = new BoardDto();
		boardDto.setUserId("ssafy");
		System.out.print("제목 : ");
		boardDto.setSubject(in.readLine());
		System.out.print("내용 : ");
		boardDto.setContent(in.readLine());

		try {
			boardController.writeArticle(boardDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("================================== 글목록 ================================== ");
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("pgno", "1");
			map.put("key", "subject");
			map.put("word", "");
			List<BoardDto> list = boardController.listArticle(map);
			for(BoardDto article : list) {
				System.out.println(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("================================== 22번 상세글 ================================== ");
		try {
			int articleNo = 22;
//			int articleNo = 50;
			boardDto = boardController.getArticle(articleNo);
			if(boardDto != null) {
				boardController.updateHit(articleNo);
				System.out.println(boardDto);
			} else
				System.out.println(articleNo + "번 글은 삭제되었거나 없는 글번호입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("================================== 29번글 삭제 ================================== ");
		try {
			int articleNo = 29;
			boardController.deleteArticle(articleNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
