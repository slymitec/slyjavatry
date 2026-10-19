package indi.sly.testtry.t20250614;

public interface ITestObject extends ITestObject2 {
    @MethodScope(value = MethodScopeType.ONLY_KERNEL)
    void IA();
}
