package indi.sly.testtry.t20260915.common;


public abstract class ASystemException extends RuntimeException {
    public ASystemException(Class<? extends ASystemException> type) {
        super(type.getSimpleName());
        this.type = type;
    }

    protected final Class<? extends ASystemException> type;

    public Class<? extends ASystemException> getType() {
        return this.type;
    }
}
