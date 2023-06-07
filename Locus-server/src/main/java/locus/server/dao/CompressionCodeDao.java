package locus.server.dao;

import locus.server.dao.mapper.CompressionCodeMapper;
import locus.server.model.entity.CompressionCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompressionCodeDao extends CompressionCodeMapper {

    CompressionCode getLatestAvailableCompressionCode();
}
