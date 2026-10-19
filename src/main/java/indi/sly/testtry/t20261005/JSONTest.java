package indi.sly.testtry.t20261005;

import tools.jackson.databind.JavaType;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.util.*;

public class JSONTest {
    static void main() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);

        JsonMapper SERIALIZATION_JSON = JsonMapper.builder().addModule(module).build();

        Deque<TestDTO> testDTOs = new ArrayDeque<>();
        TestDTO testDTO = new TestDTO();
        testDTO.setText("hello1");
        testDTOs.push(testDTO);
        testDTO = new TestDTO();
        testDTO.setText("hello2");
        testDTOs.push(testDTO);

        String x = SERIALIZATION_JSON.writeValueAsString(testDTOs);
        System.out.println(x);


        TestDTO[] definitionValues = SERIALIZATION_JSON.readValue(x, TestDTO[].class);
        for (TestDTO dto : definitionValues) {
            System.out.println(dto.getText());
        }

    }

    static void main2() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);

        JsonMapper SERIALIZATION_JSON = JsonMapper.builder().addModule(module).build();

        Map<String, TestDTO> testDTOs = new HashMap<>();
        TestDTO testDTO = new TestDTO();
        testDTO.setText("hello1");
        testDTOs.put("A", testDTO);
        testDTO = new TestDTO();
        testDTO.setText("hello2");
        testDTOs.put("B", testDTO);

        String x = SERIALIZATION_JSON.writeValueAsString(testDTOs);
        System.out.println(x);

        JavaType type = SERIALIZATION_JSON.getTypeFactory().constructParametricType(Map.class, String.class, TestDTO.class);


        Map<String, TestDTO> map1 = SERIALIZATION_JSON.readValue(x, type);

        map1.forEach((k, v) -> System.out.println(k + ":" + v.getText()));

    }
}
