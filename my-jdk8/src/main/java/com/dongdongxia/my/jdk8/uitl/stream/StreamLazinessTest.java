package com.dongdongxia.my.jdk8.uitl.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * <P>Description: 关于流的惰性的测试</P>
 * @ClassName: StreamLazinessTest
 * @author java_liudong@163.com  2017年11月27日 上午10:22:29
 */
public class StreamLazinessTest {

    static class Employee {
        int id;
        String name;
        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        public String getName() {
            return this.name;
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i < 10000000; i++) {
            employees.add(new Employee(i, "name_" + i));
        }
        Stream<String> employeeNameStreams = employees.parallelStream().filter(employee -> employee.id % 2 == 0).map(employee -> {
            System.out.println("In Map - " + employee.getName());
            return employee.getName();
        });
        Thread.sleep(2000);
        System.out.println("2 sec");
        employeeNameStreams.collect(Collectors.toList());
    }
}