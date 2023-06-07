package locus.server.dao;

import locus.server.dao.mapper.DomainConfMapper;
import locus.server.model.entity.DomainConf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomainConfDao extends DomainConfMapper {

    List<DomainConf> selectAll();

    DomainConf selectByDomain(@Param("domain") String domain);
}
