package locus.server.infra.support.lock;

import java.util.concurrent.TimeUnit;

public interface DistributedLock {

    void lock(long leaseTime, TimeUnit unit);

    void tryLock(long waitTime,long leaseTime,TimeUnit unit) throws InterruptedException;

    void unlock();

    boolean isLock();

    boolean isHeldByThread();















}
