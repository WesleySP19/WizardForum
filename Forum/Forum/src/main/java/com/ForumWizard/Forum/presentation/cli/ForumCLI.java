package com.ForumWizard.Forum.presentation.cli;

import com.ForumWizard.Forum.application.service.ForumService;
import com.ForumWizard.Forum.application.service.TopicService;
import com.ForumWizard.Forum.application.service.UserService;
import com.ForumWizard.Forum.models.chat.Chat;
import com.ForumWizard.Forum.models.forum.Forum;
import com.ForumWizard.Forum.models.forum.Topic;
import com.ForumWizard.Forum.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;

@Component
public class ForumCLI {

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Fórum Wizards!");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar Tópico");
            System.out.println("2. Listar Tópicos");
            System.out.println("3. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (choice) {
                case 1:
                    System.out.println("Digite o título do tópico:");
                    String title = scanner.nextLine();
                    System.out.println("Digite o conteúdo do tópico:");
                    String content = scanner.nextLine();
                    Topic topic = new Topic();
                    topic.setTitle(title);
                    topic.setContent(content);
                    topic.setUserId(1L); // ID do usuário logado
                    topicService.createTopic(topic);
                    System.out.println("Tópico criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Listando tópicos...");
                    topicService.getAllTopics().forEach(t -> System.out.println(t.getTitle()));
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}