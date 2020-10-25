package com.example.tools.platform.model;

import com.example.tools.platform.exception.ApiException;
import com.example.tools.platform.exception.Errors;
import com.example.tools.platform.util.Asserts;
import com.google.common.collect.ImmutableList;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.function.Function;

/**
 * 游标分页参数对象
 * 注：以存在大量相同数据的字段分页时，可能会影响分页的准确性
 *
 * @author freshchen
 */
@Data
public class Cursorable {

    /**
     * 获取该 after 游标之后（大于该游标）的数据。after 和 before 两个参数最多制定一个。
     */
    private Long after;

    /**
     * 获取该 before 游标之前（小于该游标）的数据。after 和 before 两个参数最多制定一个。
     */
    private Long before;

    /**
     * 每页记录数量，必须传入，最大 2000。
     */
    private Integer size;

    /**
     * 排序字段，默认是 id，还支持其他 Long 或 OffsetDateTime 字段，如 created 等，业务应用必须检查合适的字段。
     */
    private String orderBy = "id";

    /**
     * 默认排序方式为 desc，可选值 升序（asc），降序（desc）
     */
    private String sort = "desc";

    public final static String ASC = "asc";
    public final static String DESC = "desc";
    public final static ImmutableList SORTABLE_TYPES = ImmutableList.of(Long.class, OffsetDateTime.class);

    public void validate() {
        if (after != null && before != null) {
            throw new ApiException(Errors.BAD_PARAMS, "Must specify only one of `after` and `before`.");
        }
        if (size == null || size < 1 || size > 2000) {
            throw new ApiException(Errors.BAD_PARAMS, "Must specify valid `size` parameter: [1 - 2000] ");
        }
        if (StringUtils.isBlank(orderBy)) {
            throw new ApiException(Errors.BAD_PARAMS, "Must specify valid `orderBy` parameter");
        }
    }

    public boolean isFirst() {
        return after == null && before == null;
    }

    public boolean isNext() {
        return after != null && before == null;
    }

    public boolean isPrevious() {
        return after == null && before != null;
    }

    public boolean isAsc() {
        return ASC.equals(sort);
    }

    public boolean isSortableType(Class type) {
        return SORTABLE_TYPES.contains(type);
    }

    public <E, T> Function<E, Long> getLongMapperBySortType(Class<T> type, Function<E, T> sortFieldMapper) {
        Asserts.isTrue(isSortableType(type), "Only support order by Long or OffsetDateTime type field.");
        if (type.equals(OffsetDateTime.class)) {
            return e -> ((OffsetDateTime) sortFieldMapper.apply(e)).toInstant().toEpochMilli();
        } else {
            return (Function<E, Long>) sortFieldMapper;
        }
    }

    public <T> T getSortFieldValueBySortType(Class<T> type, Long cursor) {
        Asserts.isTrue(isSortableType(type), "Only support order by Long or OffsetDateTime type field.");
        if (type.equals(OffsetDateTime.class)) {
            return (T) (OffsetDateTime.ofInstant(Instant.ofEpochMilli(cursor), ZoneOffset.UTC));
        } else {
            return (T) cursor;
        }
    }
}
