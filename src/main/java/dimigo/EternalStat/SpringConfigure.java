package dimigo.EternalStat;


import dimigo.EternalStat.repository.StatRepository;
import dimigo.EternalStat.service.StatService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigure {


    private StatRepository statRepository;
    //생성자 방식으로 의존성 주입

    public SpringConfigure(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @Bean
    public StatService StatService()
    {
        return new StatService(statRepository);
    }

}
