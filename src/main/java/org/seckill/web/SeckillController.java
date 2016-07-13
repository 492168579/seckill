package org.seckill.web;

import javafx.scene.chart.PieChart;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcuption;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by yezhaoyi on 16/6/15.
 */
@Controller
@RequestMapping("/seckill") //url :/模块、资源
public class SeckillController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService ;
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public  String list(Model model){
        //list.jsp + model  = ModelAndView
        List<Seckill> list =  seckillService.getSeckillList();
        model.addAttribute("list",list) ;
        return  "list" ;
    }
    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId")Long seckillId, Model model){
        if(seckillId==null){
            return  "redirect:/seckill/list" ;
        }
        Seckill seckill = seckillService.getById(seckillId);
        if(seckill==null){
            return  "forward:/seckill/list";
        }
        model.addAttribute("seckill" ,seckill);
        return  "detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
    @ResponseBody
    public SeckillResult<Exposer> export(@PathVariable Long seckillId){
        SeckillResult<Exposer> result ;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
             result  = new  SeckillResult(true,exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            result = new SeckillResult(false,e.getMessage());
        }
        System.out.print("result:"+result.toString());
        return  result ;
    }
    @RequestMapping(value = "/{seckillId}/{md5}/execution" ,method = RequestMethod.POST,produces = {"application/json;charset=UTF-8" })
    @ResponseBody
    public SeckillResult<SeckillExcuption> execute(@PathVariable("seckillId")Long seckillId ,@PathVariable("md5")String md5 ,@CookieValue(value = "killPhone",required = false) Long phone){
        //Spring mvc vaild
        if(phone==null){
            return  new SeckillResult<SeckillExcuption>(false,"未注册");
        }
        SeckillResult<SeckillExcuption> result ;
        try {
                SeckillExcuption seckillExcuption = seckillService.excuteSeckillProcedure(seckillId,phone,md5);
                return  new SeckillResult<SeckillExcuption>(true,seckillExcuption);
        }catch (SeckillCloseException e) {
            logger.error(e.getMessage(),e);
            SeckillExcuption seckillExcuption = new SeckillExcuption(seckillId, SeckillStatEnum.END);
            return  new SeckillResult<SeckillExcuption>(true,seckillExcuption);
        } catch (RepeatKillException e) {
            logger.error(e.getMessage(),e);
            SeckillExcuption seckillExcuption = new SeckillExcuption(seckillId, SeckillStatEnum.REPEAT_SECKILL);
            return  new SeckillResult<SeckillExcuption>(true,seckillExcuption);
        } catch (SeckillException e) {
            logger.error(e.getMessage(),e);
            SeckillExcuption seckillExcuption = new SeckillExcuption(seckillId, SeckillStatEnum.DATA_ERROR);
            return  new SeckillResult<SeckillExcuption>(true,seckillExcuption);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            SeckillExcuption seckillExcuption = new SeckillExcuption(seckillId, SeckillStatEnum.INNER_ERROR);
            return  new SeckillResult<SeckillExcuption>(true,seckillExcuption);
        }

    }
    @RequestMapping(value = "/time/now" )
    @ResponseBody
    public  SeckillResult time() {
        Date now = new Date();
        SeckillResult seckillResult = new SeckillResult<Long>(true, now.getTime());
        return seckillResult;
    }
}
