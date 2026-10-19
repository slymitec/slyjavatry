package indi.sly.testtry.t20261004;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

import java.util.ArrayList;
import java.util.List;

@REntity
public class TestREntity {
    public TestREntity() {
        this.ns = new ArrayList<>();
    }

    @RId
    private int id;
    private long num;
    private final List<Long> ns;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public List<Long> getNs() {
        return ns;
    }
}
