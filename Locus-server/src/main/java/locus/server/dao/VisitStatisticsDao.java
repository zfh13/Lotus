package locus.server.dao;

import locus.server.dao.mapper.VisitStatisticsMapper;
import locus.server.model.entity.VisitStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

@Mapper
public interface VisitStatisticsDao extends VisitStatisticsMapper {

    VisitStatistics selectByUniqueKey(@Param("statisticsDate") LocalDate statisticsDate,
                                      @Param("compressionCode") String compressionCode,
                                      @Param("shortUrlDigest") String shortUrlDigest,
                                      @Param("longUrlDigest") String longUrlDigest);


}
