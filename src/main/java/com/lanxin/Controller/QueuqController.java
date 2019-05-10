package com.lanxin.Controller;

import com.lanxin.Commons.Result;
import com.lanxin.Service.ProvideService;
import com.lanxin.bean.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.List;

/**
 * Created by fjw on 2019/5/9.
 */
@Controller
public class QueuqController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    @Autowired
    private ProvideService provideService;

    @RequestMapping(value = "queuesend")
        public Result queuesend(){

        jmsMessagingTemplate.convertAndSend(queue,provideService.selectallUser());

        return  Result.ok(provideService.selectallUser());

    }

    @RequestMapping(value = "topicsend")
     public String topicsend(){

        jmsMessagingTemplate.convertAndSend(topic,"hello word,我是topic生产方");

        return  "success";
    }


    @RequestMapping(value = "select")
    public ModelAndView select(){

        ModelAndView modelAndView=new ModelAndView();

        modelAndView.setViewName("selectall");

        modelAndView.addObject("lists", provideService.selectallUser());

        return  modelAndView;
    }

}
