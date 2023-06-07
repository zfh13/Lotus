package locus.server.infra.support.mybatis;

import locus.server.infra.common.TimeZoneConstant;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.Optional;

public class OffsetDateTimeTypeHandler extends BaseTypeHandler<OffsetDateTime> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OffsetDateTime offsetDateTime, JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(i, Timestamp.from(offsetDateTime.toInstant()));
    }

    @Override
    public OffsetDateTime getNullableResult(ResultSet rs, String s) throws SQLException {
        Timestamp timestamp = rs.getTimestamp(s);
        return getOffsetDateTime(timestamp);
    }

    @Override
    public OffsetDateTime getNullableResult(ResultSet rs, int i) throws SQLException {
        Timestamp timestamp = rs.getTimestamp(i);
        return getOffsetDateTime(timestamp);
    }

    @Override
    public OffsetDateTime getNullableResult(CallableStatement cs, int i) throws SQLException {
        Timestamp timestamp = cs.getTimestamp(i);
        return getOffsetDateTime(timestamp);
    }
    private static OffsetDateTime getOffsetDateTime(Timestamp timestamp) {
        return Optional.ofNullable(timestamp)
                .map(ts -> OffsetDateTime.ofInstant(ts.toInstant(), TimeZoneConstant.CHINA.getOffset()))
                .orElse(null);
    }
}
