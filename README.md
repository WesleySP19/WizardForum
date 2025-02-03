# Projeto: Fórum Brasília Wizards

## Visão Geral
Este projeto é um fórum criado especificamente para o time de futebol americano **Brasília Wizards**. O objetivo principal é melhorar a comunicação e organização entre os atletas, a Comissão Técnica (CT) e a presidência do time. O fórum também permite maior integração entre os membros, oferecendo um espaço para debates, planejamento e troca de mensagens instantâneas.

## Funcionalidades
- **Cadastro de Usuários:**
  - Usuários podem se registrar, gerando um ID único que permite acessá-los no sistema.
  - Dois tipos de usuários: Normal e CT (Comissão Técnica).

- **Interação no Fórum:**
  - Usuários normais podem criar tópicos, comentar e interagir.
  - Usuários CT podem avaliar perfis, criar tópicos importantes, apagar tópicos/comentários e bloquear usuários.
  - Possibilidade de atribuir "estrelas" a tópicos relevantes como forma de avaliação.

- **Chat Instantâneo:**
  - Sistema de mensagens instantâneas que permite troca de mensagens de texto, áudio, vídeo e imagens.
  - Mensagens podem ser enviadas em tempo real ou armazenadas para serem lidas posteriormente.

## Estrutura do Projeto
- **Arquitetura:**
  - Segue os princípios de Clean Architecture e Clean Code.
  - Separado em módulos bem definidos para facilitar manutenção e expansão.

- **Estrutura de Pastas:**
  ```plaintext
  src/
  ├── main/
  │   ├── java/
  │   │   └── com/
  │   │       └── forumfootball/
  │   │           ├── domain/              # Camada de Domínio (Entidades e Regras de Negócio)
  │   │           │   ├── model/
  │   │           │   │   ├── user/        # Entidades de Usuário
  │   │           │   │   │   ├── User.java
  │   │           │   │   │   ├── Athlete.java
  │   │           │   │   │   ├── CT.java
  │   │           │   │   │   └── Admin.java
  │   │           │   │   ├── forum/       # Entidades do Fórum
  │   │           │   │   │   ├── Forum.java
  │   │           │   │   │   ├── Topic.java
  │   │           │   │   │   └── Comment.java
  │   │           │   │   └── chat/        # Entidades de Chat
  │   │           │   │       ├── Chat.java
  │   │           │   │       └── Message.java
  │   │           │   ├── enums/
  │   │           │   │   ├── UserType.java
  │   │           │   │   └── ChatType.java
  │   │           │   └── exceptions/      # Exceções Customizadas
  │   │           │       └── ValidationException.java
  │   │           ├── application/         # Casos de Uso e Serviços
  │   │           │   ├── service/
  │   │           │   │   ├── UserService.java
  │   │           │   │   ├── ForumService.java
  │   │           │   │   ├── ChatService.java
  │   │           │   │   └── HallOfFameService.java
  │   │           │   └── validation/      # Validações Específicas
  │   │           │       └── UserValidator.java
  │   │           ├── infrastructure/      # Implementações de Infraestrutura
  │   │           │   ├── repository/
  │   │           │   │   ├── UserRepository.java
  │   │           │   │   ├── ForumRepository.java
  │   │           │   │   └── ChatRepository.java
  │   │           │   └── auth/
  │   │           │       └── AuthManager.java  # Autenticação e Autorização
  │   │           └── presentation/        # Interface com o Usuário (CLI/Web)
  │   │               ├── cli/
  │   │               │   ├── ForumCLI.java
  │   │               │   └── MenuManager.java
  │   │               └── dto/             # Objetos de Transferência de Dados
  │   │                   └── UserDTO.java
  │   └── resources/                       # Configurações e Mensagens
  └── test/                                # Testes Unitários e Integração

- **Descrição das Classes:**
  - `User.java`: Classe base para todos os usuários.
  - `NormalUser.java`: Representa um usuário comum com permissões de criação e interação em tópicos.
  - `CTUser.java`: Extensão de `User`, com permissões administrativas.
  - `Topic.java`: Gerencia os tópicos do fórum e seus comentários.
  - `Message.java`: Representa mensagens enviadas no chat.
  - `ChatService.java`: Contém a lógica para gerenciamento de mensagens no chat.
  - `Forum.java`: Classe principal que gerencia o funcionamento do fórum.
  - `Main.java`: Ponto de entrada do sistema.

## Tecnologias Utilizadas
- **Java Vanilla:** Sem o uso de frameworks externos, seguindo as boas práticas da linguagem.
- **Organização Modular:** Estrutura organizada para manter o código limpo e reutilizável.
