package com.wb.wbs.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: shiroDemo
 * @ClassName ShiroFl
 * @description:
 * @author: SZW
 * @create: 2020-08-29 13:28
 * @Version 1.0
 **/
public class ShiroFl {
    private static Logger logger = LoggerFactory.getLogger(ShiroFl.class);

    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("auth.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //obtain the currently executing user
        Subject user = SecurityUtils.getSubject();
        Session session = user.getSession();
        session.setAttribute("key", "value");

        if(!user.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);
            try {
                user.login(token);
            } catch (UnknownAccountException uae) {
            } catch (IncorrectCredentialsException ice ) {
            } catch (LockedAccountException lae) {
            }
            catch (AuthenticationException ae) {
            }
        }

        logger.info( "User [" + user.getPrincipal() + "] logged in successfully." );

        //if user have specific role or not
        if(user.hasRole("schwartz")) {
            logger.info("May the Schwartz be with you!");
        }
        else {
            logger.info( "Hello, mere mortal.");
        }

        if (user.isPermitted("winnebago:drive:eagle5" ) ) {
            logger.info("You are permitted to 'drive' the 'winnebago' with license plate (id) 'eagle5'." +
                    "Here are the keys - have fun!");
        } else {
            logger.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        user.logout();
    }

}