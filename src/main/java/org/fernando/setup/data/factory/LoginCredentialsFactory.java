package org.fernando.setup.data.factory;

import org.apache.commons.lang3.StringUtils;
import org.fernando.setup.config.ConfigurationManager;
import org.fernando.setup.model.LoginCredentials;

public class LoginCredentialsFactory {

    public LoginCredentials validLoginCredentials(){
        LoginCredentials loginCredentials = new LoginCredentials();
        loginCredentials.setEmail(ConfigurationManager.getConfiguration().userEmailCredential());
        loginCredentials.setPassword(ConfigurationManager.getConfiguration().userPasswordCredential());
        return loginCredentials;
    }
}
