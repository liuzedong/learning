package com.dongdongxia.my.patterns.abstractdocument;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
/**
 * 
 * <P>Description: 默认实现接口</P>
 * @ClassName: AbstractDocument
 * @author java_liudong@163.com  2017年8月26日 下午4:53:22
 */
public abstract class AbstractDocument implements Document {
    
    private final Map<String, Object> properties;
    
    protected AbstractDocument(Map<String, Object> properties) {
        Objects.requireNonNull(properties, "propeties map is required");
        this.properties = properties;
    }

    
    @Override
    public Void put(String key, Object value) {
        properties.put(key, value);
        return null;
    }
    
    @Override
    public Object get(String key) {
        return properties.get(key);
    }
    
    
    @Override
    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
        Optional<List<Map<String, Object>>> any = Stream.of(get(key)).filter(el -> el != null)
                .map(el -> (List<Map<String, Object>>) el).findAny();
        return any.isPresent() ? any.get().stream().map(constructor) : Stream.empty();
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("[");
        properties.entrySet().forEach(e -> builder.append("[").append(e.getKey()).append(" : ").append(e.getValue()).append("]"));
        builder.append("]");
        return builder.toString();
    }
}