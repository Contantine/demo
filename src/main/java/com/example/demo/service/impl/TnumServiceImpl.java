package com.example.demo.service.impl;


import com.example.demo.entity.Tnum;
import com.example.demo.mapper.TnumMapper;
import com.example.demo.service.TnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class TnumServiceImpl implements TnumService {

    @Autowired
    private TnumMapper tnumMapper;

    @Override
    public int insert(Tnum tnum){
        return tnumMapper.insert(tnum);
    }

    @Override
    public int updateTnum(Tnum tnum){
        return tnumMapper.updateByPrimaryKeySelective(tnum);
    }

    @Override
    public Tnum getTnum(Integer id){
        return tnumMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tnum> showTnum(){
        String sql = "SELECT *\n" +
                " from test";
        return tnumMapper.showTnum(sql);
    }
}
