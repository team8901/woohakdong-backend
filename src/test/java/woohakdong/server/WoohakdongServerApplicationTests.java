package woohakdong.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import woohakdong.server.config.WithoutRedisConfig;

@ActiveProfiles("test")
@SpringBootTest
@WithoutRedisConfig
class WoohakdongServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
