package locus.server.dao.mapper;

import java.util.List;
import locus.server.model.entity.VisitStatistics;
import locus.server.model.entity.VisitStatisticsExample;
import org.apache.ibatis.annotations.Param;

public interface VisitStatisticsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VisitStatistics record);

    int insertSelective(VisitStatistics record);

    List<VisitStatistics> selectByExample(VisitStatisticsExample example);

    VisitStatistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VisitStatistics record, @Param("example") VisitStatisticsExample example);

    int updateByExample(@Param("record") VisitStatistics record, @Param("example") VisitStatisticsExample example);

    int updateByPrimaryKeySelective(VisitStatistics record);

    int updateByPrimaryKey(VisitStatistics record);
}