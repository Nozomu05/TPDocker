# RentalService

Application Spring Boot pour la gestion de locations.

## Prérequis

- Java 21
- Gradle
- Docker

## Configuration JAVA_HOME

Pour configurer la variable d'environnement JAVA_HOME sur Windows :

```powershell
[System.Environment]::SetEnvironmentVariable('JAVA_HOME', 'C:\Program Files\Java\jdk-21', 'User')
```

Vérifier la configuration :
```powershell
echo $env:JAVA_HOME
java -version
```

## Build de l'application

```bash
./gradlew build
```

## Docker

### Création du Dockerfile

Créer un fichier `Dockerfile` à la racine du projet avec le contenu suivant :

```dockerfile
FROM eclipse-temurin:21

VOLUME /tmp

EXPOSE 8080

ADD ./build/libs/RentalService-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
```

### Construction de l'image Docker

```bash
docker build -t rental-service .
```

### Exécution du conteneur

```bash
docker run -p 8080:8080 rental-service
```

### Commandes Docker utiles

Lister les conteneurs en cours d'exécution :
```bash
docker ps
```

Arrêter un conteneur :
```bash
docker stop <container_id>
```

Vérifier les processus utilisant le port 8080 :
```bash
netstat -ano | findstr :8080
```

## Accès à l'application

Une fois le conteneur démarré, l'application est accessible à :
- http://localhost:8080
