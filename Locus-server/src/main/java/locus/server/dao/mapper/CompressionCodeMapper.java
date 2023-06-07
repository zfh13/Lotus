package locus.server.dao.mapper;

import java.util.List;
import locus.server.model.entity.CompressionCode;
import locus.server.model.entity.CompressionCodeExample;
import org.apache.ibatis.annotations.Param;

public interface CompressionCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CompressionCode record);

    int insertSelective(CompressionCode record);

    List<CompressionCode> selectByExample(CompressionCodeExample example);

    CompressionCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CompressionCode record, @Param("example") CompressionCodeExample example);

    int updateByExample(@Param("record") CompressionCode record, @Param("example") CompressionCodeExample example);

    int updateByPrimaryKeySelective(CompressionCode record);

    int updateByPrimaryKey(CompressionCode record);
}