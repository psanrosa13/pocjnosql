package pocnosql.pocnosql;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.api.key.BucketManagerFactory;
import org.jnosql.diana.api.key.KeyValueConfiguration;
import org.jnosql.diana.redis.key.RedisConfiguration;

@ApplicationScoped
public class Gerenciador {

    private static final String BUCKET = "developers";

    private KeyValueConfiguration<?> configuration;

    private BucketManagerFactory<?> managerFactory;

    @PostConstruct
    public void init() {
        configuration = new RedisConfiguration();
        managerFactory = configuration.get();
    }

    @Produces
    public BucketManager getManager() {
        System.out.println(" passando aqui");
        return managerFactory.getBucketManager(BUCKET);
    }

}
