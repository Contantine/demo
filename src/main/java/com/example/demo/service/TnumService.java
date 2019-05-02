package com.example.demo.service;

import com.example.demo.entity.Tnum;
import java.util.List;

public interface TnumService {
    int insert(Tnum tnum);

    int updateTnum(Tnum tnum);

    Tnum getTnum(Integer id);

    List<Tnum> showTnum();

}
