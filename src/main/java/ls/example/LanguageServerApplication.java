package ls.example;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration()
@ComponentScan({
        "ls.example"
})
public class LanguageServerApplication
{
    public static void main(String[] args)
    {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .sources(LanguageServerApplication.class)
                .run(args);
    }
}
