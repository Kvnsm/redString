# PORTAIL-FORMATION

## Requirements
- Java 17

## Setup
- Clone the repo https://github.com/school-by-hiit/portail-formation
- Add the project as Maven project
- Create a postgres database at the port 5432 :
  ```sh
    docker run -d --name sbh-db -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres -p 5432:5432 postgres
  ```

## Technologies
- Mapper with Mapstruct
- Data Access with Spring Data

## Directories architecture
```markdown
|-- src/
| |-- main/
| | |-- java/
| | | |-- fr.schoolbyhiit.portailformation/
| | | | |-- config
| | | | |-- mapper
| | | | | |-- ModuleMapper
| | | | |-- persistence
| | | | | |-- entity
| | | | | | |-- Module
| | | | | |-- ModuleRepository
| | | | |-- service
| | | | | |-- ModuleService
| | | | |-- web
| | | | | |-- dto
| | | | | | |-- ModuleDto
| | | | | |-- ModuleController
| | | | |-- PortailFormationApplication
| | |-- resources/
| | | |-- db.migration/
| | | | |-- V0_0_1__init-schema.sql
| | | |-- application.yaml/
| |-- test/
```