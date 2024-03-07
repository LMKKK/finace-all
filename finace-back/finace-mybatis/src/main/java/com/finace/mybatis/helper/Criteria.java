package com.finace.mybatis.helper;

public class Criteria<T> extends GeneratedCriteria<T> {
    //true 表示and false表示or
    private boolean andOrOr = true;

    protected Criteria() {
        super();
    }

    public boolean isAndOrOr() {
        return andOrOr;
    }

    public void setAndOrOr(boolean andOrOr) {
        this.andOrOr = andOrOr;
    }
}