package locus.server.infra.support.lock;

import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
public class DistributedLockFactory {

    private RedissonClient redissonClient;

    private static final String DISTRIBUTED_LOCK_PATH_PREFIX = "dl:";

    public DistributedLock provideDistributedLock(String lockKey) {
        String path = DISTRIBUTED_LOCK_PATH_PREFIX + lockKey;
        return new RedissonDistributedLock(redissonClient,path);
    }




}
