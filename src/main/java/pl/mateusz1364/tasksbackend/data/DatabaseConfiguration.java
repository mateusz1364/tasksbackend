package pl.mateusz1364.tasksbackend.data;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import pl.mateusz1364.tasksbackend.domain.config.AppCredentials;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@EnableJpaRepositories("pl.mateusz1364.tasksbackend.data")
@Configuration
public class DatabaseConfiguration {

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource(AppCredentials appCredentials) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl(appCredentials.getDatabaseUrl());
        dataSource.setUsername(appCredentials.getDatabaseUsername());
        dataSource.setPassword(appCredentials.getDatabasePassword());
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DriverManagerDataSource dataSource) {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "validate");
//        hibernateProperties.put("hibernate.connection.autocommit", false);
//        hibernateProperties.put("hibernate.enable_lazy_load_no_trans", true);

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("pl.mateusz1364.tasksbackend.data");
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        return sessionFactoryBean;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(LocalSessionFactoryBean factory,
                                                     DriverManagerDataSource dataSource) {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(true);
        factory.setPackagesToScan("pl.mateusz1364.tasksbackend.data");
        factory.setDataSource(dataSource);
        return factory.getObject();
    }

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}