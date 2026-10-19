package indi.sly.testtry.t20261013;


public class TMain {
    static void main() {
        Object[] objects = new Object[2];

        objects[0] = null;
        objects[1] = 1;

        System.out.println(ObjectUtil.isAnyNull(1, 1, 1, objects));
    }

    static void doo(Object... obj) {
        System.out.println(ValueUtil.isAnyNullOrEmpty(1, 2, obj));
    }
}
