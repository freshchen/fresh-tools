package com.example.tools.platform.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author darcy
 * @since 2020/08/09
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Maps {

    public static <T> Map<String, T> subMap(Map<String, T> map, Set<String> keys) {
        return subMap(map, keys, (key) -> key);
    }

    public static <T> Map<String, T> subMap(Map<String, T> map, Set<String> keys, Function<String, String> keyHandler) {
        return subMap(map, keys, keyHandler, (value) -> value);
    }

    public static <T, R> Map<String, R> subMap(Map<String, T> map, Set<String> keys, Function<String, String> keyHandler,
                                               Function<T, R> valueHandler) {
        Objects.requireNonNull(map);
        Map<String, R> subMap = com.google.common.collect.Maps.newHashMapWithExpectedSize(keys.size());
        keys.stream().filter(map::containsKey)
                .map((key) -> Pair.of(keyHandler.apply(key), valueHandler.apply(map.get(key))))
                .forEach((pair) -> {
                    subMap.put(pair.getKey(), pair.getValue());
                });
        return subMap;
    }

    @SafeVarargs
    public static <T> boolean isAllNullValues(Map<String, T> map, Predicate<T>... nullPredicate) {
        return org.apache.commons.collections4.MapUtils.isEmpty(map) ||
                map.values().stream()
                        .allMatch((t) -> t == null ||
                                Stream.of(nullPredicate)
                                        .anyMatch((predicate) -> predicate.test(t)));
    }
}
