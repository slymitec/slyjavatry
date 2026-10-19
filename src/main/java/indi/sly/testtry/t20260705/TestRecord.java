package indi.sly.testtry.t20260705;

import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;

public record TestRecord(List<String> list) {
    public TestRecord() {
        this(new ArrayList<>());
    }
}
