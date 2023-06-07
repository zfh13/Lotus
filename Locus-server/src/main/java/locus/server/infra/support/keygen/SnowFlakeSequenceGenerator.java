package locus.server.infra.support.keygen;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SnowFlakeSequenceGenerator implements SequenceGenerator{


    private final long workercenterId;

    private final long machineId;

    private JavaSnowFlake javaSnowFlake;

    public void init() {
        this.javaSnowFlake = new JavaSnowFlake(workercenterId,machineId);
    }

    @Override
    public long generator() {
        return javaSnowFlake.getNextId();

    }
}
