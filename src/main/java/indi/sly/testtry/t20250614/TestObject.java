package indi.sly.testtry.t20250614;

public class TestObject extends ATestObject implements ITestObject {
    @Override
    public void IA() {
        System.out.println("IA");
    }

    @Override
    public void AY() {
        System.out.println("AA");
    }

    @MethodScope(value = MethodScopeType.ONLY_KERNEL)
    public void Y() {
        System.out.println("Y");
    }

    public void N() {
        System.out.println("N");
    }

    @Override
    @MethodScope(value = -3)
    public void IA2() {
        System.out.println("IA2");
    }
}
