package jp.ac.morijyobi.book_management2.service.impl;

import jp.ac.morijyobi.book_management2.bean.entity.Tag;
import jp.ac.morijyobi.book_management2.bean.form.TagForm;
import jp.ac.morijyobi.book_management2.mapper.TagsMapper;
import jp.ac.morijyobi.book_management2.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    private final TagsMapper tagsMapper;

    public TagServiceImpl(TagsMapper tagsMapper) {
        this.tagsMapper = tagsMapper;
    }

    @Override
    public Tag registerTag(TagForm tagForm) {
        Tag tag = new Tag();
        tag.setTagName(tagForm.getTagName());

        tagsMapper.insertTag(tag);

        return null;
    }
}