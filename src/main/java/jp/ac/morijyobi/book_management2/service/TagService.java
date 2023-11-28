package jp.ac.morijyobi.book_management2.service;

import jp.ac.morijyobi.book_management2.bean.entity.Tag;
import jp.ac.morijyobi.book_management2.bean.form.TagForm;

public interface TagService {

    Tag registerTag(TagForm tagForm);
}
