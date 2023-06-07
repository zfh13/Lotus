package locus.server.infra.support.keygen;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;


public class JavaSnowFlake {

    private static final Logger logger = LoggerFactory.getLogger(JavaSnowFlake.class);

    private final long workercenterIdBits = 5L;

    private final long machineIdBits = 5L;

    private final long sequeceIdBits = 12l;

    private long sequence;

    private final long maxWorkerCenterId = ~(-1l << workercenterIdBits);

    private final long maxMachineId = ~(-1l << machineIdBits);

    private final long shiftTime = machineIdBits + sequeceIdBits + workercenterIdBits;
    private Random random = new Random();

    private final int seed = 100;

    private long laststamp = -1l;
    @Getter
    private final long workercenter;
    @Getter
    private final long machinecenter;
    @Getter
    private final long epoch;

    public JavaSnowFlake(long workercenter, long machineId) {
        if(workercenter<0 || workercenter>maxWorkerCenterId) {
            throw new IllegalArgumentException(String.format("workerId can not over %ld",workercenter));
        }
        if(machineId<0 || machineId>maxMachineId) {
            throw new IllegalArgumentException(String.format("machineId can not over %ld",workercenter));
        }
        this.workercenter = workercenter;
        this.machinecenter = machineId;


        this.epoch = LocalDateTime.of(2023,6,1,0,0,0).toEpochSecond(ZoneOffset.of("+8"));
    }

    private long timegen() {
        return System.currentTimeMillis();
    }

    private long getNextTimeMills(long laststamp) {
        long timestap = timegen();
        while(timestap<=laststamp) {
            timestap = timegen();
        }
        return timestap;
    }

    public synchronized long getNextId() {
        long timestamp = timegen();
        if(timestamp<laststamp) {
            throw new RuntimeException("时钟回转了");
        }
        if(laststamp == timestamp) {
            long sequenceMask = ~(-1l << sequeceIdBits);
            sequence = (sequence + 1) & sequenceMask;
            timestamp = getNextTimeMills(laststamp);

        } else {
            sequence = random.nextInt(seed);
        }
        laststamp = timestamp;

        return ((timestamp-epoch) << shiftTime) | (workercenter << sequeceIdBits + workercenterIdBits )
                | (machinecenter << (sequeceIdBits)) | sequence;
    }

    public static void main(String[] args) {
        long id = new JavaSnowFlake(12,16).getNextId();
        System.out.printf("序列号值为%d",id);
    }
}
