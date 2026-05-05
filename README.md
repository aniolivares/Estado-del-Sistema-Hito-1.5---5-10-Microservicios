# Proyecto Semestral: 777

**Integrantes:** Nicolas Ortega, Jairo Cid, Anita Olivares

**Estado del Sistema (Hito Final - 10 Microservicios)**

| Microservicio | Puerto | DB Name | Funcionalidad |
| :--- | :--- | :--- | :--- |
| Módulo de Registro | 8082 | universidad_backend | CRUD de usuarios y autenticación. |
| Módulo de Catálogo | 8081 | universidad_backend | CRUD de Productos (Prendas). |
| Módulo de Carrito | 8084 | universidad_backend | CRUD de ItemCarrito y persistencia de compra. |
| Módulo de Favoritos | 8080 | universidad_backend | CRUD de productos favoritos por usuario. |
| Módulo de Notificaciones | 8085 | universidad_backend | CRUD de alertas y mensajes push al cliente. |

**Despliegue Técnico**

* **Instancia:** AWS EC2 t3.large (Ubuntu 24.04)
* **Orquestación:** Docker Compose (11 contenedores: 10 APIs + 1 MySQL)
* **Comando de inicio:** `docker compose up -d`
* **Base de Datos:** MySQL 8.0 compartida.
