package mer.mano.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import mer.mano.model.Blog;
import mer.mano.model.BlogComment;
import mer.mano.model.BlogDislike;
import mer.mano.model.BlogLike;
import mer.mano.model.Friend;
import mer.mano.model.Job;

@Configuration
	@ComponentScan("mer.mano")
	@EnableTransactionManagement
	public class DBconfig {

		@Bean(name="dataSource")
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:admin");
			dataSource.setUsername("merwin");
			dataSource.setPassword("Admin12345");
			System.out.println("---Data Source created---");
			return dataSource;
		}

		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory() {
			Properties hibernateProp = new Properties();
			hibernateProp.put("hibernate.hbm2ddl.auto", "update");
			hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			hibernateProp.setProperty("hibernate.show_sql", "true");

			LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
			factoryBuilder.addProperties(hibernateProp);

			factoryBuilder.addAnnotatedClass(Blog.class);
			//factoryBuilder.addAnnotatedClass(UserDetail.class);
			factoryBuilder.addAnnotatedClass(BlogComment.class);
			factoryBuilder.addAnnotatedClass(Job.class);
			//factoryBuilder.addAnnotatedClass(Forum.class);
			//factoryBuilder.addAnnotatedClass(ForumComment.class);
			factoryBuilder.addAnnotatedClass(BlogLike.class);
			factoryBuilder.addAnnotatedClass(BlogDislike.class);
			//factoryBuilder.addAnnotatedClass(ProfilePic.class);
			factoryBuilder.addAnnotatedClass(Friend.class);

		



			SessionFactory sessionFactory = factoryBuilder.buildSessionFactory();
			System.out.println("---SessionFactory created---");
			return sessionFactory;
		}

		@Bean
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
			System.out.println("---TransactionManager created---");
			return new HibernateTransactionManager(sessionFactory);
		}


}
