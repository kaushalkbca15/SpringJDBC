package com.fcb.dao.cfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={DataSourceCfg.class,SessionFactoryCfg.class})
public class ApplicationConfig {

}
