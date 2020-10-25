package com.example.tools.platform.model;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * 分页查询结果，同时提供Lambda风格的接口。
 * <pre>
 *     Pagination<Integer> src = new Pagination<>(Lists.newArrayList(1, 2, 3));
 *     Pagination<String> dest = src.stream().map(String::valueOf).collect(Pagination.toPagination(src.getPage(), src.getSize(), src.getTotal()));
 * </pre>
 *
 * @author freshchen
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pagination<T> {

    /**
     * 查询记录集
     */
    private List<T> content = Lists.newArrayList();

    /**
     * 当前页索引
     */
    private Integer page;

    /**
     * 当前页容量
     */
    private Integer size;

    /**
     * 总记录数
     *
     * @deprecated 如非必要，否则尽量不要赋值，也即业务无需显示精确页数
     */
    @Deprecated
    private Optional<Integer> total = Optional.empty();

    /**
     * 是否可以查询下一页
     * <p>
     * 实现逻辑：hasNext = content.size() == size，从而避免因查询数据量大导致count慢查询
     * 含义：只有当值为true时，才表示当前页"有可能"不是最后一页(缺点：如果最后一页数据的size刚好等于页的size时，会多一次无用的分页查询)
     */
    @Builder.Default
    private Optional<Boolean> hasNext = Optional.empty();

    /**
     * @deprecated 请使用工厂方法
     */
    @Deprecated
    public Pagination(List<T> content) {
        this.content = content;
        this.page = 0;
        this.size = content.size();
    }

    /**
     * 隐藏构造函数，使用工厂方法。
     */
    private Pagination(List<T> content, Integer page, Integer size) {
        this.content = content;
        this.page = page;
        this.size = size;
    }

    /**
     * 构造单页结果(content, 0, content.size())
     */
    public static <E> Pagination<E> of(List<E> content) {
        return new Pagination<E>(content, 0, content.size());
    }

    /**
     * 构造分页结果(content, page, content.size())
     */
    public static <E> Pagination<E> of(List<E> content, Integer page) {
        return new Pagination<E>(content, page, content.size());
    }

    public Stream<T> stream() {
        return content.stream();
    }

    public Stream<T> parallelStream() {
        return content.parallelStream();
    }

    /**
     * 实现 Stream -> Pagination 的{@code Collector}。
     */
    public static <T> Collector<T, ?, Pagination<T>> toPagination(Integer page, Integer size, Integer total) {
        return Collector.of(() -> {
                    Pagination<T> pagination = new Pagination<>();
                    pagination.setPage(page);
                    pagination.setSize(size);
                    pagination.setTotal(Optional.ofNullable(total));
                    return pagination;
                }, (pagination, elm) -> pagination.getContent().add(elm),
                (left, right) -> {
                    left.getContent().addAll(right.getContent());
                    return left;
                });
    }

    /**
     * 实现 Stream -> Pagination 的{@code Collector}。
     */
    public static <T> Collector<T, ?, Pagination<T>> toPagination(Integer page, Integer size,
                                                                  Integer total, Boolean hasNext) {
        return Collector.of(() -> {
                    Pagination<T> pagination = new Pagination<>();
                    pagination.setPage(page);
                    pagination.setSize(size);
                    pagination.setTotal(Optional.ofNullable(total));
                    pagination.setHasNext(Optional.ofNullable(hasNext));
                    return pagination;
                }, (pagination, elm) -> pagination.getContent().add(elm),
                (left, right) -> {
                    left.getContent().addAll(right.getContent());
                    return left;
                });
    }
}
