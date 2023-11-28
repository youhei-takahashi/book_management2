package jp.ac.morijyobi.book_management2.mapper;

import jp.ac.morijyobi.book_management2.bean.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface TagsMapper {

    @Insert("INSERT INTO tags VALUES(default, #{tagName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTag(Tag tag);
}
