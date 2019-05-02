package com.example.demo.Controller;


import com.example.demo.entity.Tnum;
import com.example.demo.service.TnumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author QQQ
 */
@RestController
@RequestMapping("/Tnum")
public class TnumController {

    @Resource
    private TnumService tnumService;


    @RequestMapping("/showall")
    public List<Tnum> getTnum(){
        List<Tnum> list = tnumService.showTnum();
        return list;
    }

}
