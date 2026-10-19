package indi.sly.testtry.t20260928;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.security.Provider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class JSONMain {

    static void main() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);

        JsonMapper SERIALIZATION_JSON = JsonMapper.builder().addModule(module).build();

        L l = new L();
        l.setN(123);
        l.getMap().put("A", List.of(1, 2, 3));
        l.getMap().put("B", List.of(2, 3, 4));

        String s = SERIALIZATION_JSON.writeValueAsString(l);

        byte[] st = SERIALIZATION_JSON.writeValueAsBytes(l);

        System.out.println(s);
        System.out.println(st.length);

        L nl = SERIALIZATION_JSON.readValue(s, L.class);
        L nl2 = SERIALIZATION_JSON.readValue(st, L.class);

        Class<Long> longClass = long.class;

        System.out.println(longClass == Long.TYPE);
    }

    public static class L {
        private long n;

        public long getN() {
            return n;
        }

        public void setN(long n) {
            this.n = n;
        }

        private final Map<String, List<Integer>> map = new HashMap<>();

        public Map<String, List<Integer>> getMap() {
            return map;
        }
    }
}
