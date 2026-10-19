package indi.sly.testtry.t20261005;

import indi.sly.testtry.t20260915.TextRecord;
import indi.sly.testtry.t20260915.common.ASystemException;
import indi.sly.testtry.t20260915.common.ClientResponseRecord;
import indi.sly.testtry.t20260915.common.ClientResponseTypes;
import indi.sly.testtry.t20260915.common.ConditionRefuseException;
import io.dapr.actors.ActorId;
import io.dapr.actors.runtime.AbstractActor;
import io.dapr.actors.runtime.ActorRuntimeContext;
import io.dapr.actors.runtime.ActorStateManager;
import reactor.core.publisher.Mono;

public class TestActor extends AbstractActor implements ITestActor {
    public TestActor(ActorRuntimeContext runtimeContext, ActorId id) {
        super(runtimeContext, id);
    }

    @Override
    public String test(TestDTO text) {
        return this.getId().toString() + ": " + (text != null ? text.getText() : "");
    }
}