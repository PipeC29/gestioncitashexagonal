# 🩺 Gestión de Citas Médicas — Backend Hexagonal

Este proyecto es un sistema backend construido con **Spring Boot** y la arquitectura **Hexagonal (Ports & Adapters)**. Permite:

- Registrar doctores y pacientes
- Agendar citas médicas
- Consultar citas por doctor
- Manejar errores con respuestas JSON estructuradas

---

## 🚀 Tecnologías utilizadas

- Java 8
- Spring Boot 2.7.x
- Maven
- H2 (Base de datos en memoria)
- Postman (para pruebas)
- Arquitectura Hexagonal limpia

---

## ⚙️ Cómo ejecutar el proyecto

bash
./mvnw clean install
./mvnw spring-boot:run


Accede a la API en: http://localhost:8080

🔌 Endpoints REST disponibles

👨‍⚕️ Crear doctor
POST /api/doctores

Body JSON:

json
{
  "nombre": "Andrés",
  "apellido": "Salazar",
  "especialidad": "Cardiología",
  "horaInicio": "08:00",
  "horaFin": "14:00"
}

Crear paciente
POST /api/pacientes

Body JSON:

json
{
"nombre": "Laura Méndez",
"identificacion": "CC123456"
}

Agendar cita
POST /api/citas

Body JSON:

json
{
"doctor": { "id": 1 },
"paciente": { "id": 1 },
"fechaHora": "2025-06-18T10:00:00",
"duracionMinutos": 30
}

Consultar citas por doctor
GET /api/citas/doctor/{idDoctor} Ejemplo:

GET http://localhost:8080/api/citas/doctor/1
🧪 Probar los endpoints con Postman
Abre Postman

Selecciona el método (POST o GET)

Ingresa la URL de la API

En POST, ve a Body → raw → JSON y pega el contenido de ejemplo

Presiona Send

🗃️ Acceso a la consola de base de datos H2
URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Usuario: sa

Contraseña: (vacía)

Puedes ejecutar queries como:

sql
SELECT * FROM DOCTOR;
SELECT * FROM PACIENTE;
SELECT * FROM CITA;
❗ Manejo global de errores
Respuestas de error controladas y en formato JSON:

json
{
"mensaje": "Doctor no encontrado",
"codigo": 404,
"timestamp": "2025-06-18T14:10:00"
}
Tipos de errores manejados:

404 → Recurso no encontrado

409 → Conflicto (agenda ocupada)

400 → Parámetros inválidos

500 → Error inesperado

🧱 Arquitectura Hexagonal
Capa	Responsabilidad
domain.model	Entidades del modelo de negocio
domain.port.in	Casos de uso disponibles
domain.port.out	Interfaces para adaptadores externos
application.service	Lógica de negocio
infrastructure.adapter	Persistencia (JPA, base de datos)
infrastructure.controller	Endpoints REST (handlers frontend)
exception	Manejadores de errores globales

📌 Próximas mejoras (TODO)

Documentación Swagger/OpenAPI

Validación con anotaciones @Valid

Seguridad JWT

Carga inicial con data.sql

Tests de integración con MockMVC