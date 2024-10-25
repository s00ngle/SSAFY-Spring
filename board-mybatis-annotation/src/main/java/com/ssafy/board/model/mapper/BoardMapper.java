package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.ssafy.board.model.BoardDto;

@Mapper
public interface BoardMapper {
	
	final String WRITE_ARTICLE = """
		insert into board
		(user_id, subject, content, hit, register_time)
		values (#{userId},
		#{subject}, #{content}, 0, now())
			""";
	
	final String DETAIL_ARTICLE = """
		select b.article_no, b.user_id, b.subject, b.content, b.hit,
		b.register_time, m.user_name
		from board b, members m
		where b.user_id = m.user_id
		and b.article_no = #{no}
				""";

	@Insert(WRITE_ARTICLE)
	int writeArticle(BoardDto boardDto) throws SQLException;
	
	@SelectProvider(type = BoardDynamicSqlProvider.class, method = "listArticle")
	List<BoardDto> listArticle(Map<String, Object> map) throws SQLException;
	
	int totalArticleCount(Map<String, String> map) throws SQLException;
	
	@Select(DETAIL_ARTICLE)
	BoardDto getArticle(int articleNo) throws SQLException;
	
	@Update("update board set hit = hit + 1 where article_no = #{no}")
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(BoardDto boardDto) throws SQLException;
	
	@Delete("delete from board where article_no = #{no}")
	void deleteArticle(int articleNo) throws SQLException;
	
}
