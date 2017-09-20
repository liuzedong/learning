package com.dongdongxia.my.micro.service.demo01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dongdongxia.my.micro.service.demo01.model.Calculation;

/**
 * 
 * <P>Description: 计算服务的控制器</P>
 * @ClassName: CalculationController
 * @author java_liudong@163.com  2017年9月20日 上午10:29:27
 */
@RestController
@RequestMapping("/calculation")
public class CalculationController {

    private static final String PATTERN = "^-?+\\d+\\.?+\\d*$";
    
    /**
     * 
     * <p>Title: pow</p>
     * <p>Description: 指数计算</p>
     * @param b 值
     * @param e 指数
     * @return 结果
     * @author java_liudong@163.com  2017年9月20日 上午10:34:27
     */
    @RequestMapping("/power")
    public Calculation pow(@RequestParam(value = "base") String b,
            @RequestParam(value = "exponent") String e) {
        // 将入参添加进来
        List<String> input = new ArrayList<String>();
        input.add(b);
        input.add(e);
        
        List<String> output = new ArrayList<String>();
        String powValue = "";
        
        if (b != null && e != null && b.matches(PATTERN) && e.matches(PATTERN)) {
            powValue = String.valueOf(Math.pow(Double.valueOf(b), Double.valueOf(e)));
        } 
        else {
            powValue = "入参不能为空，或，格式不对，只能使用数字";
        }
        output.add(powValue);
        return new Calculation("power", input, output);
    }
    
    /**
     * 
     * <p>Title: sqrt</p>
     * <p>Description: 计算平方根</p>
     * @param aValue 值
     * @return 结果
     * @author java_liudong@163.com  2017年9月20日 上午10:43:38
     */
    @RequestMapping(value = "/sqrt/{value:.+}", method = RequestMethod.GET)
    public Calculation sqrt(@PathVariable(value = "value") String aValue) {
        List<String> input = new ArrayList<>();
        input.add(aValue);
        List<String> output = new ArrayList<>();
        
        String sqrtValue = "";
        if (aValue != null && aValue.matches(PATTERN)) {
            sqrtValue = String.valueOf(Math.sqrt(Double.valueOf(aValue)));
        } 
        else {
            sqrtValue = "计算值，不能为空且必须是数字";
        }
        output.add(sqrtValue);
        return new Calculation("sqrt", input, output);
    }
}
