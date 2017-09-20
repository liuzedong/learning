package com.dongdongxia.my.micro.service.demo01.model;

import java.util.List;

/**
 * 
 * <P>Description: 计算实体，封装计算的数据</P>
 * @ClassName: Calculation
 * @author java_liudong@163.com  2017年9月20日 上午10:18:06
 */
public class Calculation {
    
    /**
     * 函数
     */
    private String function;
    /**
     * 入参
     */
    private List<String> input;
    /**
     * 出参
     */
    private List<String> output;
    
    public Calculation(String function, List<String> input, List<String> output) {
        this.function = function;
        this.input = input;
        this.output = output;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }
}
