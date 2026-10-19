package indi.sly.testtry.t20250614;

public abstract class ATestObject {
    @MethodScope(value = MethodScopeType.ONLY_KERNEL)
    abstract void AY();

    @MethodScope(value = MethodScopeType.ONLY_KERNEL)
    public void BY() {
        System.out.println("A");
    }
}
