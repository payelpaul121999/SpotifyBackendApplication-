# Spotify Backend Application 🎵

A **Spotify-like backend service** built using **Spring Boot**, **Spring Data JPA**, and **PostgreSQL**.
This project provides REST APIs to manage artists, albums, tracks, playlists, and user listening data.

The goal of this project is to simulate the backend architecture of a music streaming platform.

---

# 🚀 Features

### Artist Management

* Create artist
* Get all artists
* Get artist by ID

### Album Management

* Create album
* Bulk insert albums
* Get albums by artist

### Track Management

* Create track
* Bulk insert tracks
* Get tracks by album

### Playlist Management

* Create playlist
* Add tracks to playlist
* Remove tracks from playlist
* View playlist tracks

### Music Interaction

* Like tracks
* Listening history

---

# 🏗️ Project Architecture

```
Controller → Service → Repository → Database
```

```
com.palpa.spotifybackend
│
├── SpotifybackendApplication
│
├── config
│     └── DatabaseConfig
│
├── controller
│     ├── ArtistController
│     ├── AlbumController
│     ├── TrackController
│     ├── PlaylistController
│
├── service
│     ├── ArtistService
│     ├── AlbumService
│     ├── TrackService
│     ├── PlaylistService
│
├── repository
│     ├── ArtistRepository
│     ├── AlbumRepository
│     ├── TrackRepository
│     ├── PlaylistRepository
│     ├── PlaylistTrackRepository
│     ├── LikedTrackRepository
│     ├── ListeningHistoryRepository
│
├── model
│     ├── Artist
│     ├── Album
│     ├── Track
│     ├── Playlist
│     ├── PlaylistTrack
│     ├── LikedTrack
│     ├── ListeningHistory
│
├── dto
│     ├── CreateArtistRequest
│     ├── CreateAlbumRequest
│     ├── CreateTrackRequest
│
└── exception
      └── GlobalExceptionHandler
```

---

# 🛠️ Technologies Used

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* REST APIs
* JSON

---

# ⚙️ Setup Instructions

### 1. Clone the repository

```
git clone https://github.com/yourusername/spotify-backend.git
cd spotify-backend
```

### 2. Create PostgreSQL database

```
CREATE DATABASE spotify_db;
```

### 3. Configure database

Edit `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/spotify_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Run the application

```
mvn spring-boot:run
```

Server will start at:

```
http://localhost:8080
```

---

# 📡 Example APIs

### Create Artist

```
POST /artists
```

```
{
  "name": "Arijit Singh",
  "bio": "Indian playback singer",
  "imageUrl": "https://example.com/image.jpg"
}
```

---

### Create Album

```
POST /albums
```

```
{
  "title": "Divide",
  "releaseDate": "2017-03-03",
  "coverImage": "https://example.com/cover.jpg",
  "artistId": 1
}
```

---

### Create Track

```
POST /tracks
```

```
{
  "title": "Perfect",
  "duration": 263,
  "audioUrl": "https://example.com/audio.mp3",
  "albumId": 1
}
```

---

# 📊 Database Design

Main entities:

```
Artist → Album → Track
Playlist → PlaylistTrack → Track
User → LikedTrack
User → ListeningHistory
```

Relationships:

```
Artist 1 ─── * Album
Album 1 ─── * Track
Playlist * ─── * Track
```

---

# 🔮 Future Improvements

* User authentication with JWT
* Search functionality
* Song streaming API
* Recommendation engine
* Pagination and sorting
* Docker deployment

---

# 👨‍💻 Author

**Payel Paul**

Android Engineer exploring backend development with Spring Boot.

---

# ⭐ Contribution

Feel free to fork the project, raise issues, or submit pull requests.

---

# 📜 License

This project is for **learning and educational purposes**.
