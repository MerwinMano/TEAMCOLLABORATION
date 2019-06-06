package mer.mano.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
	
	 public  WebInitializer() {
	      System.out.println("WEBAPPINITIALIZER is Instantiated");
	 }
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{DBconfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return  new Class[]{WebResolver.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[]{"/"};
	}
	


}



