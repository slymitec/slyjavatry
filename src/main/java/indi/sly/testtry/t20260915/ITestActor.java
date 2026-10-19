package indi.sly.testtry.t20260915;

import indi.sly.testtry.t20260915.common.ClientResponseRecord;
import io.dapr.actors.ActorMethod;
import io.dapr.actors.ActorType;
import reactor.core.publisher.Mono;

@ActorType(name = "TestActor")
public interface ITestActor {

    @ActorMethod(name = "test")
    String test(String text);

    @ActorMethod(name = "call", returns = ClientResponseRecord.class)
    Mono<ClientResponseRecord> call(int x);
}