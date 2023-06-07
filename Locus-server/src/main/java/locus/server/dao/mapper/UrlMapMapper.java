package locus.server.dao.mapper;

import java.util.List;
import locus.server.model.entity.UrlMap;
import locus.server.model.entity.UrlMapExample;
import org.apache.ibatis.annotations.Param;

public interface UrlMapMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UrlMap record);

    int insertSelective(UrlMap record);

    List<UrlMap> selectByExample(UrlMapExample example);

    UrlMap selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UrlMap record, @Param("example") UrlMapExample example);

    int updateByExample(@Param("record") UrlMap record, @Param("example") UrlMapExample example);

    int updateByPrimaryKeySelective(UrlMap record);

    int updateByPrimaryKey(UrlMap record);
}