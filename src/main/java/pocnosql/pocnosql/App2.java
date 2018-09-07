package pocnosql.pocnosql;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;

import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.api.key.BucketManagerFactory;
import org.jnosql.diana.api.key.KeyValueConfiguration;
import org.jnosql.diana.redis.key.RedisConfiguration;

public class App2 {
	private static final String BUCKET = "developers";

	public static void main(String[] args) {
		KeyValueConfiguration<?> configuration;
		
		BucketManagerFactory<?> managerFactory;

		configuration = new RedisConfiguration();
		managerFactory = configuration.get();

		BucketManager manager = managerFactory.getBucketManager(BUCKET);

		Usuario usuario = new Usuario();
    	usuario.setEmail("paula@teste.com123");
    	usuario.setNome("Paula");
		manager.put(usuario.getNome(),usuario);
		
	}

}
