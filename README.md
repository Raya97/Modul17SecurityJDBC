## UK
# Modul14NoteApp

## Опис проєкту

**Modul14NoteApp** - це проста система для управління нотатками, створена за допомогою Spring Boot. У цьому проєкті користувач може створювати, переглядати, редагувати та видаляти нотатки.

## Структура проєкту

- **Note**: Основна сутність проєкту, яка представляє нотатку з полями `id`, `title` та `content`.
- **NoteService**: Сервісний клас, який реалізує CRUD операції для нотаток, зберігаючи їх у внутрішній колекції.
- **NoteController**: Контролер, який обробляє HTTP-запити для управління нотатками (створення, перегляд, редагування та видалення).
- **TemplateController**: Простіший контролер, який служить для завантаження тестових шаблонів.
- **404.html**: Шаблон сторінки помилки, який відображається при невдалих запитах.
- **edit.html**: Шаблон для редагування нотатки.
- **list.html**: Шаблон для перегляду списку нотаток.
- **test.html**: Тестовий шаблон для перевірки налаштувань.

## EN
# Modul14NoteApp

## Project Description

**Modul14NoteApp** is a simple note management system built using Spring Boot. In this project, users can create, view, edit, and delete notes.

## Project Structure

- **Note**: The main entity of the project, representing a note with `id`, `title`, and `content` fields.
- **NoteService**: A service class that implements CRUD operations for notes, storing them in an internal collection.
- **NoteController**: A controller that handles HTTP requests for managing notes (create, view, edit, and delete).
- **TemplateController**: A simpler controller used to load test templates.
- **404.html**: The error page template displayed when a request fails.
- **edit.html**: Template for editing a note.
- **list.html**: Template for viewing the list of notes.
- **test.html**: Test template for checking configurations.