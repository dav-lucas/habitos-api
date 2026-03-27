# 🚀 HabitTracker API

📋 **Descrição do Projeto**

O **HabitTracker API** é uma aplicação backend desenvolvida com **Java 21** e **Spring Boot**, focada no auxílio da consolidação e manutenção de bons hábitos. O projeto foi concebido para ser uma ferramenta de gestão comportamental.

---

⚙️ **Funcionalidades**

**🎯 Gestão de Hábitos**
* Cadastro de novos hábitos com meta de dias personalizada.
* Listagem completa de todos os hábitos monitorados.
* Atualização de metas e nomes de hábitos existentes.
* Exclusão de registros do sistema.

**📈 Monitoramento de Progresso**
* Cálculo automático de dias de persistência (Streak).
* Verificação dinâmica de status da meta (Pendente vs. Concluída).
* Sistema de mensagens de incentivo e celebração de conquistas.

---
  
🧪 **Tecnologias e Ferramentas**

* **Java 21**
* **Spring Boot**
* **Spring Data JPA**
* **H2 Database**
* **Maven**
* **Jakarta Validation**
* **Swagger UI**

---

📁 **Estrutura do Projeto**

O projeto segue as melhores práticas de arquitetura **RESTful**, com separação clara de responsabilidades entre as camadas:

* `Model`
* `Repository`
* `Service`
* `Controller`

---

🛣️ **Endpoints Principais da API**

A API conta com documentação interativa completa via **Swagger**.

| Método | Endpoint | Função |
| :--- | :--- | :--- |
| **POST** | `/habitos` | Registra um hábito com meta personalizada (Gera data automática) |
| **GET** | `/habitos` | Lista todos os hábitos cadastrados |
| **GET** | `/habitos/{id}/progresso` | Calcula dias passados, meta restante e exibe feedback |
| **PUT** | `/habitos/{id}` | Atualiza metas e nomes com validação |
| **DELETE** | `/habitos/{id}` | Remove o registro do sistema de forma segura |

---

🚀 **Como Executar e Testar o Projeto**

Pré-requisitos

* Java 21 instalado
* Maven instalado

Passos:

# 1. Clone este repositório
git clone https://github.com/dav-lucas/habitos-api.git

# 2. Acesse o diretório do projeto
cd habitos-api

# 3. Execute a aplicação via Maven
mvn spring-boot:run

# 4. Acessar a documentação interativa (Swagger) no navegador
> http://localhost:8080/swagger-ui.html

# 5. Acessar o Banco de Dados (H2 Console) no navegador
> http://localhost:8080/h2-console
> (JDBC URL: `jdbc:h2:mem:testdb`, User: `sa`, Senha: [vazia])

---

📄 **Licença**

Este projeto está licenciado sob a **MIT License**. Consulte o arquivo `LICENSE` para mais detalhes.
