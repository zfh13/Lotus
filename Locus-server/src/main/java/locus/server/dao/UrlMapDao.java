package locus.server.dao;

import locus.server.dao.mapper.UrlMapMapper;
import locus.server.model.entity.UrlMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UrlMapDao extends UrlMapMapper {

    List<UrlMap> selectAll();

    UrlMap selectByCompressionCode(@Param("compressionCode") String compressionCode);

}
