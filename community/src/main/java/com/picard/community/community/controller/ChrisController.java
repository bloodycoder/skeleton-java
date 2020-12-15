package com.picard.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/chris")
public class ChrisController {
    @RequestMapping(path="/welcome",method= RequestMethod.GET)
    public String getWelcome(Model model){
        return "/app01/welcome01";
    }
    @RequestMapping(path="/welcome",method= RequestMethod.POST)
    public String postWelcome(String nickname,Model model){
        nickname = nickname.trim().toLowerCase();
        if(nickname.length()>=6 && nickname.contains("zhu") || nickname.contains("pig")){
            //ok
            //success page
            model.addAttribute("jumpPage","problem01");
            model.addAttribute("word1","you success finished the your first problem!");
            model.addAttribute("word2","click the linked below to continue.");
            return "/app01/successPage";
        }
        model.addAttribute("errorMsg",1);
        return "/app01/welcome01";
    }
    @RequestMapping(path="/problem01",method= RequestMethod.GET)
    public String getProblem01(Model model){
        return "/app01/problem1";
    }
    @RequestMapping(path="/problem01",method= RequestMethod.POST)
    public String postProblem01(String tryTimes,String firstTry,Model model){
        tryTimes = tryTimes.trim().toLowerCase();
        firstTry = firstTry.trim().toLowerCase();
        try{
            int trytimes  = Integer.parseInt(tryTimes);
            String[] splited = firstTry.split(" ");
            if(trytimes == 2 && Integer.parseInt(splited[0])==3 &&  Integer.parseInt(splited[1])==3){
                //ok
                //success page
                model.addAttribute("jumpPage","problem02");
                model.addAttribute("word1","you success finished the your second problem!");
                model.addAttribute("word2","click the linked below to continue.");
                return "/app01/successPage";
            }
        }catch (Exception e){
            model.addAttribute("errorMsg",1);
            return "/app01/problem1";
        }
        model.addAttribute("errorMsg",1);
        return "/app01/problem1";
    }
    @RequestMapping(path="/problem02",method= RequestMethod.GET)
    public String getProblem02(Model model){
        return "/app01/problem2";
    }
    @RequestMapping(path="/problem02",method= RequestMethod.POST)
    public String postProblem02(String bookUnread,String forever,Model model){
        bookUnread = bookUnread.trim().toLowerCase();
        forever = forever.trim().toLowerCase();
        if (bookUnread.contains("monde") && forever.contains("forever")) {
            model.addAttribute("jumpPage", "problem03");
            model.addAttribute("word1", "you success finished the your second problem!");
            model.addAttribute("word2", "click the linked below to continue.");
            return "/app01/successPage";
        }
        model.addAttribute("errorMsg",1);
        return "/app01/problem2";
    }
    @RequestMapping(path="/problem03",method= RequestMethod.GET)
    public String getProblem03(Model model){
        return "/app01/problem3";
    }
    @RequestMapping(path="/problem03",method= RequestMethod.POST)
    public String postProblem03(String money,Model model){
        money = money.trim().toLowerCase();
        int value = Integer.parseInt(money);
        if (value == 20) {
            model.addAttribute("jumpPage", "problemFinal");
            model.addAttribute("word1", "宝宝真是太聪明了！还有最后一道题，再接再厉");
            model.addAttribute("word2", "click the linked below to continue.");
            return "/app01/successPage";
        }
        model.addAttribute("errorMsg",1);
        return "/app01/problem3";
    }
    @RequestMapping(path="/problemFinal",method= RequestMethod.GET)
    public String getProblemFinal(Model model){
        return "/app01/problem-final";
    }
    @RequestMapping(path="/problemFinal",method= RequestMethod.POST)
    public String postProblemFinal(String originPoem,Model model){
        originPoem = originPoem.trim().toLowerCase();
        if (originPoem.contains("world") && originPoem.contains("moon") && originPoem.contains("forever")) {
            //model.addAttribute("jumpPage", "problemFinal");
            //model.addAttribute("word1", "宝宝真是太聪明了！还有最后一道题，再接再厉");
            //model.addAttribute("word2", "click the linked below to continue.");
            return "redirect:http://xylovesunx.xyz";
        }
        model.addAttribute("errorMsg",1);
        return "/app01/problem-final";
    }
}
