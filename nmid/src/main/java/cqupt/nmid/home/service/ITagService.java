package cqupt.nmid.home.service;

import cqupt.nmid.home.model.json.ResponseJson;

public interface ITagService {
    public ResponseJson getFrequentlyTags(int size);
    public ResponseJson getBlogListByTag(int tagId,int page,int pageSize,String sortBy,String order);
}
