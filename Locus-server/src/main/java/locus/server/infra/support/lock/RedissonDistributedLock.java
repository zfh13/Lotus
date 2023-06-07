package locus.server.infra.support.lock;

import locus.server.infra.exception.LockException;
import lombok.AllArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class RedissonDistributedLock implements DistributedLock{

    private RedissonClient redissonClient;

    private String path;

    private RLock rlock;

    public RLock initInternalLock() {
        return redissonClient.getLock(path);
    }

    RedissonDistributedLock(RedissonClient redissonClient, String lockPath) {
        this.redissonClient = redissonClient;
        this.path = lockPath;
        this.rlock = initInternalLock();
    }

    @Override
    public void lock(long leaseTime, TimeUnit unit) {
        rlock.lock(leaseTime, unit);
    }

    @Override
    public void tryLock(long waitTime, long leaseTime, TimeUnit unit)  {
        try {
            rlock.tryLock(waitTime, leaseTime, unit);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new LockException(String.format("Acquire lock fail by thread interrupted,path:%s", path), e);
        }
    }

    @Override
    public void unlock() {
        rlock.unlock();
    }

    @Override
    public boolean isLock() {
        return rlock.isLocked();
    }

    @Override
    public boolean isHeldByThread() {
        return rlock.isHeldByCurrentThread();
    }
}
