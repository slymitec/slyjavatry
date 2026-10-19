package indi.sly.testtry.t20261004;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;

import org.redisson.codec.JsonJackson3Codec;
import org.redisson.codec.TypedJsonJackson3Codec;
import org.redisson.config.Config;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.json.JsonMapper;

@RestController
public class RedissionController {
    @Resource
    private RedissonClient redissonClient;

    @Resource
    private JsonMapper jsonMapper;

    private RLiveObjectService liveObjectService;

    @PostConstruct
    public void init() {
        Config config = this.redissonClient.getConfig();

        //config.setCodec(JsonJackson4Codec.INSTANCE);

        this.liveObjectService = this.redissonClient.getLiveObjectService();
    }

    @RequestMapping(value = {"/redis"}, method = {RequestMethod.GET, RequestMethod.POST})
    public Object redis() {
        TestREntity testREntity = new TestREntity();

        testREntity.setId(10);
        testREntity.setNum(100L);
        testREntity.getNs().add(1L);
        testREntity.getNs().add(2L);

        System.out.println(this.jsonMapper.writeValueAsString(testREntity));
        System.out.println(this.jsonMapper.toString());

        testREntity = this.liveObjectService.persist(testREntity);

        //TestREntity testREntity = this.liveObjectService.get(TestREntity.class, 10);

        long num = testREntity.getNum();
        System.out.println(num);

        for (Long n : testREntity.getNs()) {
            System.out.println(n);
        }

        return "";
    }
}
