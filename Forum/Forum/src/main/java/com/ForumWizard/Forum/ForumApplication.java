package com.ForumWizard.Forum;

import com.ForumWizard.Forum.models.Topic;
import com.ForumWizard.Forum.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumApplication implements CommandLineRunner {

	@Autowired
	private TopicRepository topicRepository; 

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Override
	public void run(String... args) {
		
		System.out.println("Iniciando o ForumApplication...");

		
		Topic topic = new Topic();
		topic.setTitle("Bem-vindo ao Fórum!");
		topic.setContent("Este é o primeiro tópico do Fórum Wizards.");
		topic.setUserId(1);

		topicRepository.create(topic);
		System.out.println("Tópico criado com sucesso!");

		Topic retrievedTopic = topicRepository.read(1);
		if (retrievedTopic != null) {
			System.out.println("Tópico lido: " + retrievedTopic.getTitle());
		} else {
			System.out.println("Tópico não encontrado.");
		}
	}
}
