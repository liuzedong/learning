package com.dongdongxia.my.patterns.abstractdocument;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.dongdongxia.my.patterns.abstractdocument.domain.Car;
import com.dongdongxia.my.patterns.abstractdocument.domain.HasModel;
import com.dongdongxia.my.patterns.abstractdocument.domain.HasParts;
import com.dongdongxia.my.patterns.abstractdocument.domain.HasPrice;
import com.dongdongxia.my.patterns.abstractdocument.domain.HasType;
import com.dongdongxia.my.patterns.abstractdocument.domain.Part;
/**
 * 
 * <P>Description: 测试实体类 Part 和 Car</P>
 * @ClassName: DomainTest
 * @author java_liudong@163.com  2017年8月25日 上午10:30:34
 */
public class DomainTest {

    // 定义部件使用的常亮
    private static final String TEST_PART_TYPE = "test-part-type";
    private static final String TEST_PART_MODEL = "test-part-model";
    private static final long TEST_PART_PRICE = 0L;
    
    // 定义汽车使用的常亮
    private static final String TEST_CAR_MODEL = "test-car-model";
    private static final long TEST_CAR_PRICE = 1L;
    
    /**
     * 
     * <p>Title: shouldConstructPart</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:44:02
     */
    @Test
    public void shouldConstructPart() {
        Map<String, Object> partProperties = new HashMap<>();
        partProperties.put(HasType.PROPERTY, TEST_PART_TYPE);
        partProperties.put(HasModel.PROPERTY, TEST_PART_MODEL);
        partProperties.put(HasPrice.PROPERTY, TEST_PART_PRICE);
        Part part = new Part(partProperties);
        
        // 下面的方法是Junit 里面的方法，用来测试两个对象是否相等，如果不对的话， junit就会抛出异常
        assertEquals(TEST_PART_TYPE, part.getType().get());
        assertEquals(TEST_PART_MODEL, part.getModel().get());
        assertEquals(TEST_PART_PRICE, part.getPrice().get());
    }
    
    /**
     * 
     * <p>Title: shouldConstructCar</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:43:57
     */
    @Test
    public void shouldConstructCar() {
        Map<String, Object> carProperties = new HashMap<>();
        carProperties.put(HasModel.PROPERTY, TEST_CAR_MODEL);
        carProperties.put(HasPrice.PROPERTY, TEST_CAR_PRICE);
        // 想汽车实体，添加配件
        carProperties.put(HasParts.PROPERTY, Arrays.asList(new HashMap<>(), new HashMap<>()));
        Car car = new Car(carProperties);
        
        assertEquals(TEST_CAR_MODEL, car.getModel().get());
        assertEquals(TEST_CAR_PRICE, car.getPrice().get());
        assertEquals(2, car.getParts().count());
    }
}
