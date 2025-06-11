# Loja API – Spring Boot + MySQL
API RESTful para cadastro de **Categorias** e **Produtos**.

---

## Requisitos
| Ferramenta | Versão mínima |
|------------|---------------|
| Java JDK   | 17 |
| Maven      | 3.8 |
| MySQL      | 8 |

---

## Configuração do banco
```sql
CREATE DATABASE loja_api CHARACTER SET utf8mb4;
CREATE USER 'root'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON loja_api.* TO 'root'@'localhost';
```

## `src/main/resources/application.properties`
```ini
server.port=8081
server.servlet.context-path=/rest-api/

spring.datasource.url=jdbc:mysql://localhost:3306/loja_api
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
```

---

## Execução
```bash
git clone https://github.com/JairClass/restapi.git
cd restapi
mvn clean package
java -jar target/rest-api-0.0.1-SNAPSHOT.jar
Servidor: http://localhost:8081/rest-api
```
---

## Endpoints
| Entidade  | Método | Rota                                       |
|-----------|--------|--------------------------------------------|
| **Categoria** | GET    | `/categorias`                          |
|           | GET    | `/categorias/{id}`                         |
|           | POST   | `/categorias`                              |
|           | PUT    | `/categorias/{id}`                         |
|           | PATCH  | `/categorias/{id}`                         |
|           | DELETE | `/categorias/{id}`                         |
| **Produto**   | GET    | `/produtos`                            |
|           | GET    | `/produtos/{id}`                           |
|           | GET    | `/produto/categoria/{idCategoria}`         |
|           | POST   | `/produtos`                                |
|           | PUT    | `/produtos/{id}`                           |
|           | PATCH  | `/produtos/{id}`                           |
|           | DELETE | `/produtos/{id}`                           |

---

