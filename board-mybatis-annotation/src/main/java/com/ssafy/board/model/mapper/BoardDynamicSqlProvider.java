package com.ssafy.board.model.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class BoardDynamicSqlProvider {

	public String listArticle(Map<String, Object> condition) {
		return new SQL() {
			{
				SELECT("b.article_no, b.user_id, b.subject, b.content, b.hit, b.register_time, m.user_name");
				FROM("board b");
				INNER_JOIN("members m on b.user_id = m.user_id");
				String key = (String) condition.get("key");
				String word = (String) condition.get("word");
				if(word != null && !word.isEmpty()) {
					if(key.equals("subject"))
						WHERE("subject like concat('%', #{word}, '%')");
					else
						WHERE("${key} = #{word}");
				}
				ORDER_BY("b.article_no desc");
				LIMIT("#{start}, #{end}");
			}
		}.toString();
	}

}
