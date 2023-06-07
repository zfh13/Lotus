package locus.server.dao;

import locus.server.dao.mapper.TransformEventRecordMapper;
import locus.server.model.entity.VisitStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.OffsetDateTime;
import java.util.List;

@Mapper
public interface TransformEventRecordDao extends TransformEventRecordMapper {

    List<VisitStatistics> queryVisitStatisticsDuration(@Param("start") OffsetDateTime start,
                                                       @Param("end") OffsetDateTime end);
}
