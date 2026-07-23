# Study Planner

A backend application for managing study tasks, deadlines, and weekly productivity.

Java and Spring Boot are used to building this project. It provides RESTful APIs for creating,
viewing, updating, filtering, completing, and deleting study tasks.

## Project Goal

The goal of the first version is to build a functional Study Planner MVP that can:

- Allow users to register and log in
- Create study tasks
- Set task deadlines
- View all tasks
- Update existing tasks
- Delete tasks
- Mark tasks as completed
- Filter tasks by completed or pending status
- Track how many tasks were completed during the current week

The first version focuses on core functionality rather than advanced features.

## Current features

- Create tasks
- View all tasks
- View a task by ID
- Update tasks
- Delete tasks
- Mark tasks as completed
- Filter completed and pending tasks
- Store tasks data using an H2 database

## Planned Features

- Weekly task completion statistics
- User registration and login
- User-specific task management
- Task categories and tags
- Reminder system
- Pomodoro timer
- Calendar view
- AI-generated study plans

## Technologies

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- H2 Database
- Maven

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks?status=completed` | Get completed tasks |
| GET | `/api/tasks?status=pending` | Get pending tasks |
| GET | `/api/tasks/{id}` | Get a task by ID |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}` | Update an existing task |
| PATCH | `/api/tasks/{id}/complete` | Mark a task as completed |
| DELETE | `/api/tasks/{id}` | Delete a task |

## Running the Project

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java 21 is installed.
4. Run StudyPlannerApplication.
5. The backend will start at:

http://localhost:8080

The H2 database console is avaliable at:

http://localhost:8080/h2-console

Use the following connection settings:

JDBC URL: jdbc:h2:mem:studyplanner
Username:sa
Password:

## Project Status

The task CRUD and status filtering APIs are complete.

The next development steps are:

1. Add weekly completion statistics
2. Implement user registration and login
3. Associate tasks with individual users