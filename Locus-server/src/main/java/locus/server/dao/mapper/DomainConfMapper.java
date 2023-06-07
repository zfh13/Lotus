package locus.server.dao.mapper;

import java.util.List;
import locus.server.model.entity.DomainConf;
import locus.server.model.entity.DomainConfExample;
import org.apache.ibatis.annotations.Param;

public interface DomainConfMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DomainConf record);

    int insertSelective(DomainConf record);

    List<DomainConf> selectByExample(DomainConfExample example);

    DomainConf selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DomainConf record, @Param("example") DomainConfExample example);

    int updateByExample(@Param("record") DomainConf record, @Param("example") DomainConfExample example);

    int updateByPrimaryKeySelective(DomainConf record);

    int updateByPrimaryKey(DomainConf record);
}