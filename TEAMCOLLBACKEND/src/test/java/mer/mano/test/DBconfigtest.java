package mer.mano.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBconfigtest {
	
		public static void main(String arg[]) {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.refresh();
			context.scan("mer.mano");
			
			System.out.println("Testing DBConfig");
			
		}

}
