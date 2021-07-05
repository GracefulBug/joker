package com.life.joker.common;

/**
 * @author zhengdeqi
 * @description 转换器
 * @date 2021/7/5
 */
public interface Converter<S, T> extends org.springframework.core.convert.converter.Converter<S, T> {

    /**
     * 类型转换
     *
     * @param source
     * @return
     */
    @Override
    T convert(S source);

    /**
     * 类型转换
     *
     * @param source
     * @return
     */
    default T transform(S source) {
        return this.convert(source);
    }

    /**
     * 反转换
     *
     * @param target
     * @return
     */
    default S reTransform(T target) {
        return null;
    }

}
