package com.ForumWizard.Forum;

import com.ForumWizard.Forum.models.user.Topic;
import com.ForumWizard.Forum.models.user.User;
import com.ForumWizard.Forum.repositories.TopicRepository;
import com.ForumWizard.Forum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ForumApplication implements CommandLineRunner {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Iniciando o ForumApplication...");

		User admin = new User();
		admin.setName("Admin");
		admin.setEmail("admin@forum.com");
		admin.setPassword(passwordEncoder.encode("admin123")); // Codifica a senha
		admin.setUserType(UserType.ADMIN);
		userRepository.save(admin);
		System.out.println("Usuário admin criado com sucesso!");

		Topic topic = new Topic();
		topic.setTitle("Bem-vindo ao Fórum!");
		topic.setContent("Este é o primeiro tópico do Fórum Wizards.");
		topic.setUserId(admin.getId()); // Associa o tópico ao usuário admin

		topicRepository.save(topic); // Usando o método save do JpaRepository
		System.out.println("Tópico criado com sucesso!");

		Topic retrievedTopic = topicRepository.findById(topic.getId()).orElse(null);
		if (retrievedTopic != null) {
			System.out.println("Tópico lido: " + retrievedTopic.getTitle());
		} else {
			System.out.println("Tópico não encontrado.");
		}
	}
}