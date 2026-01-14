# 🎴 MontaDeck API

> Multi-TCG REST API for managing Trading Card Game collections

A complete CRUD API built with Spring Boot for managing card collections, featuring data validation, professional error handling, and clean architecture.

---

## 🛠️ Techonologies

- **Java 17**
- **Spring Boot 3.2.1**
    - Spring Data JPA
    - Spring Validation
    - Spring Web
- **PostgresSQL** - Database
- **Maven** - Dependecy management
- **Lombok** - Reduce boilerplate code

---

## ⚡ Features

- ✅ Complete CRUD operations (Create, Read, Update, Delete)
- ✅ **Multi-TCG support** - Ready for Magic: The Gathering, Pokémon, Yu-Gi-Oh!, and more
- ✅ Data validation with Bean Validation
- ✅ Professional error handling with custom exceptions
- ✅ RESTful API design
- ✅ Clean architecture (Controller → Service → Repository)
- ✅ Scalable database schema for multiple card games
- ✅ Automatic JSON serialization/deserialization
- ✅ PostgreSQL database integration

---

## 📋 Prerequisites

Before running this project, make sure you have:

- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+

---

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/montadeck-api.git
cd montadeck-api
```

### 2. Configure the database

Create a PostgreSQL database:
```sql
CREATE DATABASE montadeck_db;
```

Update `src/main/resources/application.properties` with your credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/montadeck_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### 3. Run the application
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

---

## 📚 API Endpoints

## 🎴 External API Integration (Planned)

This API is designed to integrate with multiple TCG card databases:

### Supported APIs (Planned)

- 🧙 **Magic: The Gathering** - [Scryfall API](https://scryfall.com/docs/api)
- ⚡ **Pokémon** - [Pokémon TCG API](https://pokemontcg.io/)
- 🐉 **Yu-Gi-Oh!** - [YGOPRODeck API](https://ygoprodeck.com/api-guide/)
- 🎯 **Future TCGs** - Extensible architecture for adding more games

### Quick Example: Add a card manually
```bash
curl -X POST http://localhost:8080/api/cards \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Lightning Bolt",
    "type": "Instant",
    "manaCost": 1,
    "text": "Lightning Bolt deals 3 damage to any target.",
    "rarity": "Common",
    "color": "Red"
  }'
```

---

### Cards

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/api/cards` | Get all cards | - |
| GET | `/api/cards/{id}` | Get card by ID | - |
| POST | `/api/cards` | Create new card | Card JSON |
| PUT | `/api/cards/{id}` | Update card | Card JSON |
| DELETE | `/api/cards/{id}` | Delete card | - |

### Card JSON Structure
```json
{
  "name": "Lightning Bolt",
  "type": "Instant",
  "manaCost": 1,
  "text": "Deals 3 damage to any target",
  "rarity": "Uncommon",
  "color": "Red"
}
```

---

## 💡 Usage Examples

### Create a new card
```bash
curl -X POST http://localhost:8080/api/cards \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Counterspell",
    "type": "Instant",
    "manaCost": 2,
    "text": "Counter target spell",
    "rarity": "Uncommon",
    "color": "Blue"
  }'
```

### Get all cards
```bash
curl http://localhost:8080/api/cards
```

### Update a card
```bash
curl -X PUT http://localhost:8080/api/cards/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Dark Ritual",
    "type": "Instant",
    "manaCost": 1,
    "text": "Add 3 black mana",
    "rarity": "Common",
    "color": "Black"
  }'
```

### Delete a card
```bash
curl -X DELETE http://localhost:8080/api/cards/1
```

---

## ✔️ Validation Rules

- **name**: Required, 1-200 characters
- **type**: Required, max 50 characters
- **manaCost**: Optional, must be >= 0 if provided
- **text**: Optional, max 1000 characters
- **rarity**: Required, max 30 characters
- **color**: Required, max 20 characters

---

## ⚠️ Error Responses

The API returns standardized error responses:

### 404 - Not Found
```json
{
  "timestamp": "2026-01-14T01:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Card not found with ID: 999",
  "path": "/api/cards/999"
}
```

### 400 - Bad Request (Validation Error)
```json
{
  "timestamp": "2026-01-14T01:31:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/api/cards",
  "errors": {
    "name": "Name is required",
    "color": "Color is required"
  }
}
```

---

## 🗄️ Database Design

The API uses a flexible schema designed to accommodate different TCG systems:
```json
{
  "id": 1,
  "name": "Card Name",
  "type": "Card Type",
  "game": "MTG | Pokemon | YuGiOh | ...",  // Future: TCG identifier
  "manaCost": 3,                            // MTG specific
  "energyCost": "GGC",                      // Pokemon specific
  "attribute": "DARK",                      // YuGiOh specific
  "text": "Card effect text",
  "rarity": "Rare",
  "color": "Blue",
  "imageUrl": "https://...",                // Future feature
  "price": 25.99,                           // Future feature
  "metadata": {}                            // Game-specific data
}
```

> **Note:** Current implementation focuses on MTG, but the architecture is designed for easy expansion to other TCGs.

---

## 🏗️ Project Structure
```
src/main/java/com/montadeck/api/
├── controller/        # REST endpoints
├── service/           # Business logic
├── repository/        # Database access
├── model/             # Entities
└── exception/         # Custom exceptions & error handling
```

### Architecture Pattern
```
Client → Controller → Service → Repository → Database
```

---

## 👨‍💻 Author

**Raphael Luccas** - QA Automation Engineer & Backend Developer

Passionate about Trading Card Games and building tools for the TCG community. This project aims to create a unified platform for managing collections across all major TCG franchises.

- GitHub: https://github.com/raphaelluccasdev
- LinkedIn: https://www.linkedin.com/in/raphael-luccas-de-almeida-lazar/
- Email: raphaelluccasdev@gmail.com

---

## 🎯 Project Vision

MontaDeck aims to become the **first Brazilian multi-TCG platform**, unifying Magic: The Gathering, Pokémon, Yu-Gi-Oh!, and other card games into a single, powerful API. The goal is to provide collectors and players with comprehensive tools for managing their collections, building decks, and tracking card values across all major TCGs.

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Built with [Spring Boot](https://spring.io/projects/spring-boot)
- Database: [PostgreSQL](https://www.postgresql.org/)
- Magic: The Gathering cards used as examples

---

### Roadmap

- 🔄 Automatic card import from multiple APIs
- 🔍 Universal card search across all TCGs
- 🎮 Game-specific attributes and filters
- 📊 Price tracking integration
- 🎨 Card images display
- 👥 User collections and deck building
- 🌐 Multi-language support

---

## 🎮 Supported Trading Card Games

### Current Focus
- 🧙‍♂️ **Magic: The Gathering** - Started with MTG as the foundation

### Planned Support
- ⚡ **Pokémon TCG**
- 🐉 **Yu-Gi-Oh!**
- 🎴 **Flesh and Blood**
- 🏺 **Lorcana**
- ⚔️ **Vanguard**
- 🎯 **And many more!**

> The API architecture is designed to be game-agnostic, allowing easy expansion to any TCG.

---

⭐ If you found this project helpful, consider giving it a star!