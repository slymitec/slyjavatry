package indi.sly.testtry.t20260915;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DaprTestController {
    @Autowired
    private DaprClient daprClient;

    @GetMapping("/dapr")
    public String dapr(String name) {
        TextRecord textRecord = new TextRecord(name);

        daprClient.saveState("statestore", "name", textRecord).block();

        State<TextRecord> block = daprClient.getState("statestore", "name", TextRecord.class).block();

        return name;
    }

    @RequestMapping(value = {"/daprinvoke"}, method = {RequestMethod.POST})
    public TextRecord daprinvoke(@RequestBody TextRecord textRecord) {
        return new TextRecord("daprinvoke: " + textRecord.text());
    }
}
