package com.risesun.persistence.type;

import java.sql.Types;

/**
 * @author qiuxu
 */

public enum JdbcType {
    INTEGER(Types.INTEGER), STRING(Types.VARCHAR);

    public final int TYPE_CODE;

    JdbcType(int types) {
        this.TYPE_CODE = types;
    }
}
