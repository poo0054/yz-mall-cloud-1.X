package com.yz.mall.common.mybatis.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yz.mall.common.core.web.api.ResultCode;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表格分页数据对象
 *
 */

@Data
@NoArgsConstructor
public class TableDataInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 列表数据
     */
    private List<T> rows;

    /**
     * 消息状态码
     */
    private long code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<T> list, long total) {
        this.rows = list;
        this.total = total;
    }

    public static <T> TableDataInfo<T> build(IPage<T> page) {
        TableDataInfo<T> rspData = new TableDataInfo<>();
        rspData.setCode(ResultCode.SUCCESS.getCode());
        rspData.setMsg(ResultCode.SUCCESS.getMessage());
        rspData.setRows(page.getRecords());
        rspData.setTotal(page.getTotal());
        return rspData;
    }

    public static <T> TableDataInfo<T> build(List<T> list) {
        TableDataInfo<T> rspData = new TableDataInfo<>();
        rspData.setCode(ResultCode.SUCCESS.getCode());
        rspData.setMsg(ResultCode.SUCCESS.getMessage());
        rspData.setRows(list);
        rspData.setTotal(list.size());
        return rspData;
    }

    public static <T> TableDataInfo<T> build() {
        TableDataInfo<T> rspData = new TableDataInfo<>();
        rspData.setCode(ResultCode.SUCCESS.getCode());
        rspData.setMsg(ResultCode.SUCCESS.getMessage());
        return rspData;
    }

}
