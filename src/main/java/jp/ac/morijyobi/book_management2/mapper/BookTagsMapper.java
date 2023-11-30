package jp.ac.morijyobi.book_management2.mapper;

import jp.ac.morijyobi.book_management2.bean.entity.BookTag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookTagsMapper {


    @Insert("INSERT INTO book_tags VALUES (#{bookId}, #{tagId})")
    void insertBookTag(BookTag bookTag);
}
