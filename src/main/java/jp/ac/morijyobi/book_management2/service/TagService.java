package jp.ac.morijyobi.book_management2.service;

import jp.ac.morijyobi.book_management2.bean.entity.Tag;
import jp.ac.morijyobi.book_management2.bean.form.TagForm;

import java.util.List;

public interface TagService {

    Tag registerTag(TagForm tagForm);

    List<Tag> getAllTags();
}
