package indi.sly.testtry.t20250706;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekController {
    @Resource
    private ChatClient chatClient;

    @GetMapping("/DeepSeek.action")
    String generation(String input) {
        return this.chatClient.prompt()
                .user(input)
                .call()
                .content();
    }
}
