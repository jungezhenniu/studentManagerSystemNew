package com.biz.std.staticValue;

import org.springframework.stereotype.Component;

/**
 * Created by wangxianjun on 2017/5/9.
 */
@Component("constantList")
public class ConstantList {
    private static final int pageSize = 4;

    public static int getPageSize() {
        return pageSize;
    }


}
