package com.dongdongxia.my.patterns.abstractdocument;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 
 * <P>Description: AbstractDocument test class</P>
 * @ClassName: AbstractDocumentTest
 * @author java_liudong@163.com  2017年8月25日 上午10:50:58
 */
public class AbstractDocumentTest {

    private static final String KEY = "key";
    private static final String VALUE = "value";
    
    private class DocumentImplementation extends AbstractDocument {

        DocumentImplementation(Map<String, Object> properties) {
            super(properties);
        }
        
    }
    
    private DocumentImplementation document = new DocumentImplementation(new HashMap<>());
    
    /**
     * 
     * <p>Title: shouldPutAndGetValue</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:46:04
     */
    @Test
    public void shouldPutAndGetValue() {
        document.put(KEY, VALUE);
        assertEquals(VALUE, document.get(KEY));
    }
    
    /**
     * 
     * <p>Title: shouldRetrieveChildren</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:45:58
     */
    @Test
    public void shouldRetrieveChildren() {
        Map<String, Object> child1 = new HashMap<>();
        Map<String, Object> child2 = new HashMap<>();
        List<Map<String, Object>> children = Arrays.asList(child1, child2);
        
        document.put(KEY, children);
        
        Stream<DocumentImplementation> childrenStream = document.children(KEY, DocumentImplementation::new);
        assertNotNull(children);
        assertEquals(2, childrenStream.count());
    }
    
    /**
     * 
     * <p>Title: shouldRetrieveEmptyStreamForNonExistiongChildren</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:45:54
     */
    @Test
    public void shouldRetrieveEmptyStreamFor() {
        Stream<DocumentImplementation> children = document.children(KEY, DocumentImplementation::new);
        assertNotNull(children);
        assertEquals(0, children.count());
    }
    
    /**
     * 
     * <p>Title: shildIncludePropsInToString</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:45:50
     */
    @Test
    public void shildIncludePropsInToString() {
        Map<String, Object> props = new HashMap<>();
        props.put(KEY, VALUE);
        DocumentImplementation document = new DocumentImplementation(props);
        assertNotNull(document.toString().contains(KEY));
        assertNotNull(document.toString().contains(VALUE));
    }
}
