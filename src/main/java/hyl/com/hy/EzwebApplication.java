package hyl.com.hy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersByPathRequest;

@SpringBootApplication
public class EzwebApplication {
	
	private static final String PROPERTIES_PREFIX = "/EC2/hyl-emp";
	
	public static void main(String[] args) {
		SpringApplication.run(EzwebApplication.class, args);
	}
	
	public static void init() {
		
		AWSSimpleSystemsManagement ssmClient = AWSSimpleSystemsManagementClientBuilder.standard()
				.withRegion(Regions.US_WEST_2)
				.build();
		ssmClient.getParametersByPath(new GetParametersByPathRequest().withPath(PROPERTIES_PREFIX)).getParameters().forEach(p -> {
			System.setProperty(p.getName().substring(PROPERTIES_PREFIX.length()), p.getValue());
		});
		System.setProperty("org.apache.el.parser.SKIP_IDENTIFIER_CHECK", "true");
	}

}
