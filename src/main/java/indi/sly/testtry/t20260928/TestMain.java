package indi.sly.testtry.t20260928;

import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.util.UUID;

public class TestMain {

    static void main() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);

        JsonMapper SERIALIZATION_JSON = JsonMapper.builder().addModule(module).build();

        UUID uuid = UUID.randomUUID();

        System.out.println(uuid);

        String s = SERIALIZATION_JSON.writeValueAsString(uuid);

        System.out.println(s);

        UUID uuid1 = SERIALIZATION_JSON.readValue(s, UUID.class);

        System.out.println(uuid1);

    }
}
