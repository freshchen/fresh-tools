package com.example.tools.platform.model;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * 分页查询结果，同时提供Lambda风格的接口。
 * <pre>
 *     Cursor<Integer> src = new Cursor<>(Lists.newArrayList(1, 2, 3));
 *     Cursor<String> dest = src.stream().map(String::valueOf).collect(Cursor.toCursor(src.getSize(), hasNext, nextCursor));
 * </pre>
 */
@Data
@NoArgsConstructor
public class Cursor<T> {

    // 查询记录集
    private List<T> content = Lists.newArrayList();

    // 是否有下一页
    private Boolean hasNext;

    // 下一页索引
    private Long nextCursor;

    // 是否有上一页
    private Boolean hasPrevious;

    // 上一页索引
    private Long previousCursor;

    // 当前页容量
    private Integer size;


    /**
     * 隐藏构造函数，使用工厂方法。
     */
    private Cursor(List<T> content, Integer size, Boolean hasNext, Long nextCursor, Boolean hasPrevious, Long previousCursor) {
        this.content = content;
        this.size = size;
        this.hasNext = hasNext;
        this.nextCursor = nextCursor;
        this.hasPrevious = hasPrevious;
        this.previousCursor = previousCursor;
    }

    public Stream<T> stream() {
        return content.stream();
    }

    public Stream<T> parallelStream() {
        return content.parallelStream();
    }

    /**
     * 根据查询结果，Cursorable 和排序字段，构造单页结果
     */
    public static <E, F> Cursor<E> of(List<E> content, Cursorable cursorable, Function<E, F> sortFieldMapper,
                                      Class<F> sortFieldType) {
        Objects.requireNonNull(content);
        Objects.requireNonNull(sortFieldMapper);
        Objects.requireNonNull(sortFieldType);

        boolean hasMore = content.size() > cursorable.getSize();
        // 点击上一页或者本页被填满，则存在下一页
        boolean hasNext = cursorable.isPrevious() || hasMore;
        // 点击下一页或者本页被填满且不是首页，则存在上一页
        boolean hasPrevious = cursorable.isNext() || (hasMore && !cursorable.isFirst());
        if (hasMore) {
            // 截去窥探数据，点击上一页时掐头，否则去尾
            int headIndex = cursorable.isPrevious() ? content.size() - cursorable.getSize() : 0;
            content = content.subList(headIndex, headIndex + cursorable.getSize());
        }

        Function<E, Long> mapperLong = cursorable.getLongMapperBySortType(sortFieldType, sortFieldMapper);
        Long after = hasNext && content.size() > 0 ?
                Optional.of(content.get(content.size() - 1)).map(mapperLong).orElse(null) : null;
        Long before = hasPrevious && content.size() > 0 ?
                Optional.of(content.get(0)).map(mapperLong).orElse(null) : null;
        return of(content, hasNext, after, hasPrevious, before);
    }

    /**
     * 构造分页结果(content, content.size(), hasNext, nextCursor, hasPrevious, previousCursor)
     */
    public static <E> Cursor<E> of(List<E> content, Boolean hasNext, Long nextCursor, Boolean hasPrevious, Long previousCursor) {
        return new Cursor<>(content, content.size(), hasNext, nextCursor, hasPrevious, previousCursor);
    }

    /**
     * 构造分页结果(content, content.size(), hasNext, nextCursor, false, 0L)
     */
    public static <E> Cursor<E> of(List<E> content, Boolean hasNext, Long nextCursor) {
        return new Cursor<>(content, content.size(), hasNext, nextCursor, false, 0L);
    }

    /**
     * 构造单页结果(content, content.size(), false, 0L, false, 0L)
     */
    public static <E> Cursor<E> of(List<E> content) {
        return new Cursor<>(content, content.size(), false, 0L, false, 0L);
    }

    /**
     * 实现 Stream -> Cursor 的{@code Collector}。
     */
    public static <T> Collector<T, ?, Cursor<T>> toCursor(Integer size, Boolean hasNext, Long nextCursor, Boolean hasPrevious, Long previousCursor) {
        return Collector.of(() -> {
                    Cursor<T> cursor = new Cursor<>();
                    cursor.setSize(size);
                    cursor.setHasNext(hasNext);
                    cursor.setNextCursor(nextCursor);
                    cursor.setHasPrevious(hasPrevious);
                    cursor.setPreviousCursor(previousCursor);
                    return cursor;
                }, (cursor, elm) -> cursor.getContent().add(elm),
                (left, right) -> {
                    left.getContent().addAll(right.getContent());
                    return left;
                });
    }

    /**
     * 实现 Stream -> Cursor 的{@code Collector}。
     */
    public static <T> Collector<T, ?, Cursor<T>> toCursor(Integer size, Boolean hasNext, Long nextCursor) {
        return toCursor(size, hasNext, nextCursor, false, 0L);
    }

    /**
     * 实现 Stream -> Cursor 的{@code Collector}。
     */
    public static <T> Collector<T, ?, Cursor<T>> toCursor(Integer size) {
        return toCursor(size, false, 0L, false, 0L);
    }
}
