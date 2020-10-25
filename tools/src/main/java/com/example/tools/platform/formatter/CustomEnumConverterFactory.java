package com.example.tools.platform.formatter;


import com.example.tools.platform.util.Asserts;
import com.example.tools.platform.util.Enums;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author darcy
 * @since 2020/06/27
 **/
public class CustomEnumConverterFactory implements ConverterFactory<String, Enum> {

    private String[] props;

    /**
     * @param prop 属性名
     */
    public CustomEnumConverterFactory(String prop) {
        Asserts.notBlank(prop);
        this.props = new String[]{prop};
    }

    /**
     * @param props 属性名
     */
    public CustomEnumConverterFactory(String... props) {
        Asserts.notEmpty(props);
        for (String prop : props) {
            Asserts.notBlank(prop);
        }

        this.props = props;
    }

    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return new CustomEnumConverter(targetType, props);
    }

    /**
     * 基于特定属性的枚举数据类型转换器，如果无法找到，再尝试用枚举名进行转换。
     */
    public static class CustomEnumConverter<T extends Enum<T>> implements Converter<String, T> {

        private Class<T> enumCls;
        private String[] props;

        /**
         * @param enumCls 枚举类型
         * @param prop    属性名
         */
        public CustomEnumConverter(Class<T> enumCls, String prop) {
            this.enumCls = enumCls;
            this.props = new String[]{prop};
        }

        /**
         * @param enumCls 枚举类型
         * @param props   属性名 (可以是多个)
         */
        public CustomEnumConverter(Class<T> enumCls, String... props) {
            this.enumCls = enumCls;
            this.props = props;
        }

        @Override
        public T convert(String source) {
            if (StringUtils.isEmpty(source)) {
                return null;
            }
            for (String prop : props) {
                Optional<T> enumOpt = Enums.getEnum(enumCls, prop, source);
                if (enumOpt.isPresent()) {
                    return enumOpt.get();
                }
            }
            return Stream.of(enumCls.getEnumConstants()).filter(e -> e.name().equals(source)).findFirst().orElse(null);
        }
    }
}
