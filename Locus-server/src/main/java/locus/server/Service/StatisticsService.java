package locus.server.Service;

import locus.server.dao.TransformEventRecordDao;
import locus.server.dao.VisitStatisticsDao;
import locus.server.model.entity.VisitStatistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.List;

@Service
@Slf4j
public class StatisticsService {

    @Autowired
    private VisitStatisticsDao visitStatisticsDao;

    @Autowired
    private TransformEventRecordDao transformEventRecordDao;

    public void processVisitDuration(OffsetDateTime start, OffsetDateTime end) {
        List<VisitStatistics> selective = transformEventRecordDao.queryVisitStatisticsDuration(start,end);
        for(VisitStatistics visitStatistics : selective) {
            VisitStatistics visitStatisticsSelective = visitStatisticsDao.selectByUniqueKey(visitStatistics.getStatisticsDate(), visitStatistics.getCompressionCode(), visitStatistics.getShortUrlDigest(), visitStatistics.getLongUrlDigest());
            if(visitStatisticsSelective == null) {
                visitStatisticsDao.insertSelective(visitStatistics);
            } else {
                visitStatistics.setId(visitStatisticsSelective.getId());
                visitStatisticsDao.updateByPrimaryKey(visitStatistics);
            }
        }

    }





}
