package indi.sly.testtry.t20261017;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.ConstantFailurePolicy;
import io.dapr.client.domain.JobSchedule;
import io.dapr.client.domain.ScheduleJobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController
public class JobController {
    @Autowired
    DaprClient daprClient;

    @RequestMapping("/jobtest")
    public Object jobtest(String text) {

        if (text == null) {
            text = "";
        }

        Instant now = Instant.now();

        ConstantFailurePolicy policy = new ConstantFailurePolicy();
        policy.setMaxRetries(4);
        policy.setDurationBetweenRetries(Duration.ofSeconds(8));

        ScheduleJobRequest request = new ScheduleJobRequest("JobName", now.plusSeconds(10));
        request.setOverwrite(true);
        request.setFailurePolicy(policy);
        request.setTtl(now.plus(1, ChronoUnit.HOURS));
        request.setSchedule(JobSchedule.hourly());
        request.setData(text.getBytes());

        daprClient.scheduleJob(request).block();

        return "success";
    }

    @PostMapping("/job/{jobName}")
    public Mono<ResponseEntity<Void>> handleJobCallback(@PathVariable("jobName") String jobName, @RequestBody(required = false) byte[] payload) {

        String body = payload != null ? new String(payload) : "(no payload)";
        System.out.println("Job triggered: " + jobName + ", payload: " + body);

        return Mono.just(ResponseEntity.ok().build());
    }
}
