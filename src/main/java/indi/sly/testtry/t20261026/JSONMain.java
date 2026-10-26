package indi.sly.testtry.t20261026;

import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JSONMain {
    @SuppressWarnings("unchecked")
    static void main() throws Exception {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);

        JsonMapper SERIALIZATION_JSON = JsonMapper.builder().addModule(module).build();


        JSONMain main = new JSONMain();

        Map<String, String> doo1 = main.getDoo();

        doo1.put("a", "1");

        String s = SERIALIZATION_JSON.writeValueAsString(doo1);

        System.out.println(s);


        Method getDoo = JSONMain.class.getMethod("getDoo");

        Map<String, String> map = (Map<String, String>) SERIALIZATION_JSON.readValue(s, getDoo.getReturnType());

        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

    }

    private final Map<String, String> doo = new HashMap<>();

    public Map<String, String> getDoo() {
        return doo;
    }

}
