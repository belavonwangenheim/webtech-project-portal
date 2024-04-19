# webtech-project-portal

Member:
Duc Phan, 590057
Béla von Wangenheim, 589289

## Projektbeschreibung: TempJob Connect

### Projektziel
Implementierung einer funktionsfähigen Webanwendung, die als Plattform für die Vermittlung von befristeten Arbeitsstellen dient.
Das Projekt wird auf der Basis eines vorgegebenen Tech-Stacks entwickelt und soll eine reibungslose Kommunikation zwischen Frontend und Backend ermöglichen.

### Technologie-Stack
- **Backend:** Java mit Spring Boot
- **Datenbank:** H2 als lokale In-Memory-Datenbank
- **Frontend:** Vue.js
- **Projektmanagement:** GitHub

## Meilensteine und Mindestanforderungen

### M1: Projektinitialisierung
**Deadline:** 21. April
- **Setup:** Erstellung einer Spring Boot-Anwendung mit initialer GET-Route.
- **Entity-Klasse:** Entwickeln einer Java-Klasse für Jobangebote, die als Grundlage für die Datenbankstruktur dient.
- **GitHub Sicherheit:** Einrichten des Repositories ohne Klartext-Credentials.
- **Dokumentation:** Beginn einer ReadMe-Datei mit Anweisungen zur Einrichtung und Ausführung der Anwendung.

### M2: Frontend-Grundlagen und Erste Interaktion
**Deadline:** 12. Mai
- **Vue.js-App:** Entwicklung und Push einer Basis Vue.js-Anwendung auf GitHub.
- **Komponentenentwicklung:** Erstellen einer Vue.js-Komponente, die `v-for` nutzt, um Jobdaten zu rendern.
- **Frontend-Tests:** Einrichtung von Tests zur Überprüfung der korrekten Rendering-Funktionalität.

### M3: Deployment und Integrationstests
**Deadline:** 26. Mai
- **Deployment:** Öffentliches Zugänglichmachen der Anwendungen über Render.
- **Integration:** Frontend ruft Jobdaten über eine GET-Route vom Backend ab.
- **Backend-Tests:** Einrichtung von Backend-Tests zur Überprüfung der API-Endpunkte.

### M4: REST API und Datenpersistenz
**Deadline:** 16. Juni
- **REST-API:** Implementierung von GET- und POST-Routen im Spring Boot-Backend.
- **Datenbank-Anbindung:** Konfiguration der H2-Datenbank für das Speichern von Jobangeboten.
- **CI/CD-Pipeline:** Automatisierung von Tests und Deployment mittels GitHub Actions.

### Finale Projektpräsentation
**Präsentationszeitraum:** 1.-3. Juli
- Abschluss aller Implementierungen bis 30. Juni, 23:59 Uhr
- Präsentation der Kernfunktionalitäten und des technischen Aufbaus des Portals

### Kernfunktionen des Portals
- **Anzeigen von Jobangeboten:** Nutzer können eine Liste verfügbarer Jobs einsehen.
- **Erstellung von Jobangeboten:** Arbeitgeber können über ein einfaches Formular im Frontend neue Jobs einstellen, die im Backend gespeichert werden.
- **Tests:** Es werden grundlegende Tests für das Frontend und das Backend implementiert, um die Funktionalität sicherzustellen.
- **CI/CD-Pipeline:** Einrichtung einer Pipeline für automatisierte Tests und Deployment-Prozesse.
- **Dokumentation:** Eine klare Anleitung in Form einer ReadMe-Datei für die Benutzung der App.
- **Basis-Design:** Eine klare und einfache Benutzeroberfläche, die reaktionsfähig ist und die wesentlichen Funktionen anbietet.


