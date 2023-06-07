package locus.server.dao.mapper;

import java.util.List;
import locus.server.model.entity.TransformEventRecord;
import locus.server.model.entity.TransformEventRecordExample;
import org.apache.ibatis.annotations.Param;

public interface TransformEventRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransformEventRecord record);

    int insertSelective(TransformEventRecord record);

    List<TransformEventRecord> selectByExample(TransformEventRecordExample example);

    TransformEventRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransformEventRecord record, @Param("example") TransformEventRecordExample example);

    int updateByExample(@Param("record") TransformEventRecord record, @Param("example") TransformEventRecordExample example);

    int updateByPrimaryKeySelective(TransformEventRecord record);

    int updateByPrimaryKey(TransformEventRecord record);
}