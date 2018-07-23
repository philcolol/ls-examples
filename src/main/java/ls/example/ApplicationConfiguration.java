package ls.example;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

@Configuration
@EnableConfigurationProperties
public class ApplicationConfiguration
{
    @Bean
    public Logger getLogger()
    {
        return Logger.getLogger("ls-example");
    }

    @Bean
    public ExecutorService getExecutorService()
    {
        return Executors.newWorkStealingPool();
    }
}
