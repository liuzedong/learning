package com.dongdongxia.my.patterns.abstractdocument;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dongdongxia.my.patterns.abstractdocument.domain.Car;
import com.dongdongxia.my.patterns.abstractdocument.domain.HasModel;
import com.dongdongxia.my.patterns.abstractdocument.domain.HasParts;
import com.dongdongxia.my.patterns.abstractdocument.domain.HasPrice;
import com.dongdongxia.my.patterns.abstractdocument.domain.HasType;

/**
 * 
 * <P>Description: 抽象文档测试， 属于结构型类型</P>
 * @ClassName: App
 * @author java_liudong@163.com  2017年8月24日 上午10:07:32
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    public App() {
        LOGGER.info("构造 parts and car");

        Map<String, Object> carProperties = new HashMap<>(); // 汽车的配置
        carProperties.put(HasModel.PROPERTY, "300SL"); // 汽车的容量
        carProperties.put(HasPrice.PROPERTY, 10000L); // 汽车的价钱
        
        Map<String, Object> wheelProperties = new HashMap<>();  // 车轮的配置
        wheelProperties.put(HasType.PROPERTY, "wheel"); // 类型是车轮
        wheelProperties.put(HasModel.PROPERTY, "15C"); // 车轮的15C大小的
        wheelProperties.put(HasPrice.PROPERTY, 100L); // 车轮的价钱

        Map<String, Object> doorProperties = new HashMap<>(); // 车门的配置
        doorProperties.put(HasType.PROPERTY, "door"); // 类型是车门
        doorProperties.put(HasModel.PROPERTY, "Lambo"); // 兰博基尼
        doorProperties.put(HasPrice.PROPERTY, 300L); // 兰博基尼车门的价钱

        // 先就定义上面的三个属性吧, 将两个属性添加到汽车的配置上面
        carProperties.put(HasParts.PROPERTY, Arrays.asList(wheelProperties, doorProperties));

        Car car = new Car(carProperties);

        LOGGER.info("这是我们的汽车");
        LOGGER.info("-> model : {}", car.getModel().get());
        LOGGER.info("-> price : {}", car.getPrice().get());
        LOGGER.info("-> parts : ");
        car.getParts().forEach(p -> LOGGER.info("\t{}/ {}/ {}", p.getType().get(), p.getModel().get(), p.getPrice().get()));
    }
    
    /**
     * 
     * <p>Title: main</p>
     * <p>Description: 自启动测试类</p>
     * @param args main入参
     * @author java_liudong@163.com  2017年8月26日 下午4:43:41
     */
    public static void main(String[] args) {
        new App();
    }

}
