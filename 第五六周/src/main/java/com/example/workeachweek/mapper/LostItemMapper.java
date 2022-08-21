package com.example.workeachweek.mapper;

import com.example.workeachweek.Infomation.LostItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LostItemMapper {

    public boolean add(LostItem item);

    public boolean del(int lost_id);

    public boolean edit(LostItem item);

    public List<LostItem> findAll();

    public LostItem findOne(int lost_id);

}
