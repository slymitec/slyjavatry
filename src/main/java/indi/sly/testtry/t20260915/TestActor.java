package indi.sly.testtry.t20260915;

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
    public String test(String text) {
        ActorStateManager actorStateManager = this.getActorStateManager();

        actorStateManager.contains("tt").flatMap(e -> {
            if (e) {
                return actorStateManager.get("tt", TextRecord.class).map(textRecord -> new TextRecord(textRecord.text() + ", " + text)).flatMap(textRecord -> actorStateManager.set("tt", textRecord));
            } else {
                return actorStateManager.set("tt", new TextRecord(text));
            }
        }).then(actorStateManager.save()).block();

        ActorId id = this.getId();

        return "(" + id.toString() + "): " + text;
    }

    @Override
    public Mono<ClientResponseRecord> call(int x) {
        try {
            if (x > 0) {
                throw new ConditionRefuseException();
            }
        } catch (ASystemException e) {
            return Mono.just(new ClientResponseRecord(ClientResponseTypes.KERNEL_EXCEPTION, e.getMessage()));
        }

        return Mono.just(new ClientResponseRecord(ClientResponseTypes.NORMAL, Integer.toString(x)));
    }

//    @Override
//    public Mono<Void> onPreActorMethod(ActorMethodContext actorMethodContext) {
//        return Mono.error(new ConditionRefuseException());
//    }
}