## UK
# Modul17SecurityJDBC

## Опис проєкту

**Modul17SecurityJDBC** - це система для управління нотатками, яка включає додатковий функціонал авторизації та аутентифікації користувачів, реалізований за допомогою Spring Security з використанням JDBC.

## Структура проєкту

### Моделі
- **User**: Модель користувача з полями `id`, `username`, `password`, `enabled`.
- **Authority**: Модель для зберігання ролей користувачів з полями `username` та `authority`.
- **Note**: Основна сутність проєкту, яка представляє нотатку з полями `id`, `title`, `content`.

### Репозиторії
- **UserRepository**: Репозиторій для управління користувачами.
- **AuthorityRepository**: Репозиторій для управління ролями користувачів.
- **NoteRepository**: Репозиторій для управління нотатками.

### Сервіси
- **UserService**: Сервіс для роботи з користувачами, включаючи шифрування паролів і збереження ролей.
- **NoteService**: Сервіс для управління нотатками.
- **PasswordChecker**: Клас для перевірки пароля користувача.
- **PasswordEncoderUtil**: Клас для шифрування паролів.

### Конфігурація безпеки
- **SecurityConfig**: Конфігурація Spring Security для захисту доступу до ресурсів програми.

### Контролери
- **LoginController**: Контролер для обробки запитів на сторінку входу.
- **RegistrationController**: Контролер для реєстрації нових користувачів.
- **NoteController**: Контролер для управління нотатками.
- **TemplateController**: Контролер для завантаження шаблонів.
- **GlobalExceptionHandler**: Глобальний обробник винятків.
- **CustomErrorController**: Контролер для обробки помилок.

### Міграції бази даних
- **V1__Create_note_table.sql**: Flyway міграція для створення таблиці `note`.
- **V2__Create_user_table.sql**: Flyway міграція для створення таблиць `users` та `authorities`.

### Шаблони
- **error/404.html**: Шаблон сторінки помилки, що відображається при невдалих запитах.
- **note/error.html**: Загальний шаблон сторінки помилки.
- **note/login.html**: Шаблон для сторінки входу.
- **note/register.html**: Шаблон для сторінки реєстрації.
- **note/test.html**: Тестовий шаблон для перевірки конфігурацій.

---

## EN
# Modul17SecurityJDBC

## Project Description

**Modul17SecurityJDBC** is a note management system that includes additional functionality for user authorization and authentication, implemented using Spring Security with JDBC.

## Project Structure

### Models
- **User**: User model with fields `id`, `username`, `password`, `enabled`.
- **Authority**: Model for storing user roles with fields `username` and `authority`.
- **Note**: The main entity of the project, representing a note with `id`, `title`, `content`.

### Repositories
- **UserRepository**: Repository for managing users.
- **AuthorityRepository**: Repository for managing user roles.
- **NoteRepository**: Repository for managing notes.

### Services
- **UserService**: Service for working with users, including password encryption and role saving.
- **NoteService**: Service for managing notes.
- **PasswordChecker**: Class for checking user password.
- **PasswordEncoderUtil**: Class for encrypting passwords.

### Security Configuration
- **SecurityConfig**: Spring Security configuration for securing access to application resources.

### Controllers
- **LoginController**: Controller for handling login page requests.
- **RegistrationController**: Controller for registering new users.
- **NoteController**: Controller for managing notes.
- **TemplateController**: Controller for loading templates.
- **GlobalExceptionHandler**: Global exception handler.
- **CustomErrorController**: Error handling controller.

### Database Migrations
- **V1__Create_note_table.sql**: Flyway migration for creating the `note` table.
- **V2__Create_user_table.sql**: Flyway migration for creating `users` and `authorities` tables.

### Templates
- **error/404.html**: Error page template displayed when a request fails.
- **note/error.html**: General error page template.
- **note/login.html**: Template for the login page.
- **note/register.html**: Template for the registration page.
- **note/test.html**: Test template for checking configurations.
