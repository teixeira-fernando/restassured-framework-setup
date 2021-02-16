package org.fernando.setup.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({"classpath:conf/${environment}.properties"})
public interface Configuration extends Config{

    @Key("env.login.url")
    String loginUrl();

    @Key("env.user.url")
    String userUrl();
}
