package cqupt.nmid.home.dao;

import java.util.List;

import cqupt.nmid.home.model.BlogModel;
import cqupt.nmid.home.model.TagModel;

/**
 * 标签表数据操作
 * @author MagicWolf
 *
 */
public interface ITagDao {
    public List<TagModel> getTagsByBlogId(int id);
    public TagModel getTagById(int id);
    public List<TagModel> getFrequentlyTags(int size);
}
