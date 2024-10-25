package com.ssafy.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.mapper.BoardMapper;
import com.ssafy.configuration.SqlMapConfig;
import com.ssafy.util.SizeConstant;

public class BoardServiceImpl implements BoardService {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSessionFactory();

	@Override
	public int writeArticle(BoardDto boardDto) throws Exception {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			int no = boardMapper.writeArticle(boardDto);
			sqlSession.commit();
			return no;
		}
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws Exception {
		int pgNo = Integer.parseInt(map.get("pgno"));
		int end = pgNo * SizeConstant.LIST_SIZE;
		int start = end - SizeConstant.LIST_SIZE;
//		map.put("start", start + "");
//		map.put("end", end + "");
//		return boardDao.listArticle(map);
		
		Map<String, Object> param = new HashMap<>();
		String key = map.get("key");
		String word = map.get("word");
		if(key != null && !key.isEmpty() && word != null && !word.isEmpty()) {
			param.put("key", key);
			param.put("word", word);
		}
		param.put("start", start);
		param.put("end", end);
		try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			return boardMapper.listArticle(param);
		}
	}

	@Override
	public BoardDto getArticle(int articleNo) throws Exception {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			return boardMapper.getArticle(articleNo);
		}
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			boardMapper.updateHit(articleNo);
			sqlSession.commit();
		}
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws Exception {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			boardMapper.modifyArticle(boardDto);
			sqlSession.commit();
		}
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			boardMapper.deleteArticle(articleNo);
			sqlSession.commit();
		}
	}

}
