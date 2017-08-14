package config;

import api.service.CardService;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.alibaba.dubbo.registry.Registry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangtc on 2017/6/27.
 */
@Configuration
public class ApplicationExportConfig {

    @Bean
    public ApplicationConfig dubboApplicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("IMC");
        return applicationConfig;
    }

    @Bean
    public ProtocolConfig dubboProtocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20881);
        return protocolConfig;
    }

    @Bean
    public RegistryConfig dubboRegistryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("N/A");
        return registryConfig;
    }
    @Bean
    public ServiceBean<CardService> exportedCardService(CardService cardService){
        ServiceBean<CardService> serviceBean = new ServiceBean<CardService>();
        serviceBean.setInterface(CardService.class);
        serviceBean.setVersion("1.0");
        serviceBean.setRef(cardService);
        serviceBean.setTimeout(3000);
        return serviceBean;
    }
}
