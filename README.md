# Services TPDocker

Ce projet contient deux services :
- **RentalService** : Application Spring Boot pour la gestion de locations
- **PhpService** : Service PHP simple qui affiche un message de bienvenue

## Prérequis

- Java 21
- Gradle
- Docker
- PHP 8.2 (si exécution locale sans Docker)

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

## Build de l'application RentalService

```bash
cd RentalService
./gradlew build
```

## Docker

### Construction de l'image Docker RentalService

```bash
cd RentalService
docker build -t rental-service .
```

### Exécution du conteneur RentalService

```bash
docker run -d -p 8080:8080 --name rental-service rental-service
```

### Commandes Docker utiles

Lister les conteneurs en cours d'exécution :
```bash
docker ps
```

Arrêter un conteneur :
```bash
docker stop <container_name_or_id>
```

Supprimer un conteneur :
```bash
docker rm <container_name_or_id>
```

Vérifier les processus utilisant un port (Windows) :
```bash
netstat -ano | findstr :8080
netstat -ano | findstr :8081
```

## Test des services

Pour tester les deux services avec PowerShell :

```powershell
# Test PhpService
curl -UseBasicParsing http://localhost:8081

# Test RentalService
curl -UseBasicParsing http://localhost:8080/bonjour
```

## Accès aux applications

Une fois les conteneurs démarrés, les applications sont accessibles à :
- **RentalService** : http://localhost:8080/bonjour
- **PhpService** : http://localhost:8081

---

## PhpService - Configuration et Déploiement

### Structure du service PHP

Le PhpService se trouve dans le dossier `../PhpService/` et contient :
- `index.php` : Page d'accueil qui affiche un message de bienvenue
- `Dockerfile` : Configuration Docker pour le service PHP

### Création du Dockerfile PHP

Le fichier `Dockerfile` dans `PhpService/` contient :

```dockerfile
# Utiliser l'image officielle PHP avec Apache
FROM php:8.2-apache

# Copier le fichier PHP dans le répertoire web d'Apache
COPY index.php /var/www/html/

# Exposer le port 80
EXPOSE 80

# Apache démarre automatiquement avec cette image
```

### Construction de l'image Docker PHP

```bash
cd PhpService
docker build -t php-service .
```

### Exécution du conteneur PHP

```bash
docker run -d -p 8081:80 --name php-service php-service
```

Le service sera accessible sur http://localhost:8081
