package se.team1.cvdb;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.team1.cvdb.CVDBConfiguration;
import se.team1.cvdb.solution.UserResource;


public class CVDBApplication extends Application<CVDBConfiguration> {

	@Override
	public void initialize(Bootstrap<CVDBConfiguration> bootstrap) {
		bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
	}

	@Override
	public void run(CVDBConfiguration configuration, Environment environment) throws Exception {
		environment.jersey().register(new UserResource());
	}
	
	public static void main(String[] args) throws Exception {
		new CVDBApplication().run(args);
	}

}
