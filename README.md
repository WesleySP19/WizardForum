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
  |-- models/
  |   |-- User.java
  |   |-- NormalUser.java
  |   |-- CTUser.java
  |   |-- Topic.java
  |   |-- Message.java
  |
  |-- services/
  |   |-- ChatService.java
  |
  |-- utils/
  |
  |-- Main.java
  |-- Forum.java
  ```

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

## Como Utilizar
1. Clone este repositório:
   ```bash
   git clone https://github.com/DevHawnk/ForumWizards.git
   ```
2. Compile os arquivos Java:
   ```bash
   javac -d bin src/**/*.java
   ```
3. Execute o sistema:
   ```bash
   java -cp bin Main
   ```

## Contribuição
Fique à vontade para abrir issues ou criar pull requests com melhorias e sugestões. Este projeto foi criado com o objetivo de aprendizado e crescimento colaborativo.

## Licença
Este projeto é de uso livre e aberto para modificações. Por favor, credite os autores ao utilizá-lo.

