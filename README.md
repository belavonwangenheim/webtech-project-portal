# webtech-project-portal

Member:
Duc Phan, 590057
Béla von Wangenheim, 589289

Ah, eine H2-Datenbank ist ideal für Prototypen! Hier die angepasste Projektbeschreibung:

## Projektbeschreibung: TempJob Connect

### Projektziel
Entwicklung eines grundlegenden Webportals "TempJob Connect" mit dem Ziel, eine Plattform für die Vermittlung von befristeten und saisonalen Arbeitsstellen zu schaffen. 
Das Portal soll in seiner Grundversion technisch solide umgesetzt sein und dabei auf die essentiellen Funktionalitäten fokussieren.

### Technologie-Stack
- **Backend:** Java mit Spring Boot
- **Datenbank:** H2 als lokale In-Memory-Datenbank
- **Frontend:** Vue.js
- **Projektmanagement:** GitHub

### Meilensteine

#### M1: Initialisierung und "Hello World"
**Deadline:** 21. April
- Entwicklung einer einfachen Spring Boot-Anwendung mit "Hello World"-Ausgabe
- Erstellung einer Entity-Klasse, die Jobangebote repräsentiert

#### M2: Einführung in Vue.js und Frontend-Setup
**Deadline:** 12. Mai
- Implementierung und Push einer grundlegenden Vue.js-Anwendung auf GitHub
- Entwicklung einer Vue.js-Komponente, die die Verwendung der `v-for`-Direktive zum Rendern von Listen demonstriert

#### M3: Integration von Frontend und Backend
**Deadline:** 26. Mai
- Deployment der Spring Boot-Anwendung und der Vue.js-Frontend-Anwendung auf einer lokalen Umgebung oder einem Hosting-Dienst
- Frontend kann Jobangebote mittels einer GET-Route vom Backend abrufen

#### M4: API-Entwicklung und Datenpersistenz
**Deadline:** 16. Juni
- Erweiterung des Spring Boot-Backends um eine REST-API mit GET- und POST-Routen
- Anbindung der H2-Datenbank für das Speichern und Abrufen von Jobdaten
- Ermöglichen des Frontends, Jobangebote über das Backend zu erstellen und zu speichern

### Finale Projektpräsentation
**Präsentationszeitraum:** 1.-3. Juli
- Abschluss aller Implementierungen bis 30. Juni, 23:59 Uhr
- Präsentation der Kernfunktionalitäten und des technischen Aufbaus des Portals

### Kernfunktionen des Portals
- **Anzeigen von Jobangeboten:** Nutzer können eine Liste verfügbarer Jobs einsehen.
- **Erstellung von Jobangeboten:** Arbeitgeber können über ein einfaches Formular im Frontend neue Jobs einstellen, die im Backend gespeichert werden.
- **Basis-Design:** Eine klare und einfache Benutzeroberfläche, die reaktionsfähig ist und die wesentlichen Funktionen anbietet.
