package indi.sly.testtry.t20261026;

import java.util.List;
import java.util.Map;

public interface ProxyInterface {
    void doo1();

    void doo2(Object i);

    void doo3(Object... i);

    void d2(List<? extends ITestP> p);

    <T extends ITestP, P extends ITestP2> void d3(Map<T, P> list);
}
