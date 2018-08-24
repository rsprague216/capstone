/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprague.ryan.capstone;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Web application lifecycle listener.
 *
 * @author Ryan Sprague
 */

@DataSourceDefinition(
        name = "java:app/jdbc/db",
        className = "org.apache.derby.jdbc.ClientDataSource",
        url = "jdbc:derby://localhost:1527/",
        databaseName = "charManagerDB",
        user = "app",
        password = "app")

@WebListener
public class CharacterListener implements ServletContextListener {
    
    @Resource(lookup = "java:app/jdbc/db")
    DataSource dataSource;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("********** /character manager loaded");
        
        CharacterManager characterManager = new CharacterManager(dataSource);
        
        
        SkillManager skillManager = new SkillManager();
        CharSkillManager charSkillManager = new CharSkillManager(dataSource);
        CharClassManager charClassManager = new CharClassManager(dataSource);
        UserManager userManager = new UserManager(dataSource);
//        userManager.addUser(new User("ryan", "ryan"));
        
        sce.getServletContext().setAttribute("userManager", userManager);
        sce.getServletContext().setAttribute("characterManager", characterManager);
        sce.getServletContext().setAttribute("skillManager", skillManager);
        sce.getServletContext().setAttribute("charSkillManager", charSkillManager);
        sce.getServletContext().setAttribute("charClassManager", charClassManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
