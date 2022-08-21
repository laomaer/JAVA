package com.example.workeachweek.service;


import com.example.workeachweek.Infomation.LostItem;
import com.example.workeachweek.mapper.LostItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostItemService {

    @Autowired
    LostItemMapper lostItemMapper;

    public Boolean add(LostItem item){
        return lostItemMapper.add(item);
    }

    public boolean del(int lost_id){
        return lostItemMapper.del(lost_id);
    };

    public boolean edit(LostItem item){
        return lostItemMapper.edit(item);
    };

    public List<LostItem> findAll(){
        return lostItemMapper.findAll();
    };

    public LostItem findOne(int lost_id){
        return lostItemMapper.findOne(lost_id);
    };

}
