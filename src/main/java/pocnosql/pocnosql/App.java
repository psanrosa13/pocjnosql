package pocnosql.pocnosql;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.jnosql.artemis.Database;
import org.jnosql.artemis.DatabaseQualifier;
import org.jnosql.artemis.Databases;
import org.jnosql.artemis.key.KeyValueTemplate;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

//			Instance<UsuarioRepository> instance = container.select(UsuarioRepository.class,
//					DatabaseQualifier.ofKeyValue());

//			UsuarioRepository usuarioRepository = instance.get();

			KeyValueTemplate template = container.select(KeyValueTemplate.class).get();
			Usuario usuario = new Usuario();
			usuario.setEmail("paula234@teste.com");
			usuario.setNome("Paula");
			template.put(usuario);
//			usuarioRepository.save(usuario);

		}
	}
}
