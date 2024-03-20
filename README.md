# Gestionale eventi
Un gestionale che assiste un'impresa di organizzazione di eventi nella creazione e gestione degli eventi, dei materiali e dello staff.
## **Capitolo 1: Descrizione del Progetto**
**1.1 Panoramica Generale**

Il progetto proposto è un'applicazione software sviluppata in linguaggio Java, che sfrutta un database MySQL e si interfaccia con un Web-service in PHP. L'obiettivo principale di questa applicazione è fornire un sistema gestionale per un'azienda specializzata nell'organizzazione di eventi. Questo sistema permetterà agli utenti autorizzati di gestire in modo efficiente e organizzato le attività legate alla pianificazione e esecuzione degli eventi.

**1.2 Descrizione Dettagliata**

L'azienda, che sarà l'utilizzatrice finale dell'applicazione, organizza una vasta gamma di eventi, dai meeting aziendali alle conferenze, dagli eventi sportivi alle fiere commerciali. Ogni evento è caratterizzato da una serie di informazioni fondamentali, tra cui la data di svolgimento, il numero di tecnici richiesti e il luogo in cui si terrà l'evento.

L'applicazione sarà accessibile tramite un'interfaccia e permetterà agli utenti di accedere alle funzionalità in base ai ruoli assegnati. Ogni utente avrà un singolo ruolo assegnato, che determinerà i permessi e le capacità di accesso all'interno dell'applicazione.

Una volta effettuato il login, gli utenti saranno in grado di visualizzare tutti gli eventi associati al loro ruolo. Questa visualizzazione può essere ordinata per nome, data o numero di tecnici, per consentire agli utenti di accedere rapidamente alle informazioni pertinenti. Gli utenti avranno anche la possibilità di nascondere gli eventi passati, riducendo così il carico visivo e concentrandosi sulle attività future.

Gli utenti con privilegi da amministratore avranno accesso a funzionalità aggiuntive, tra cui la possibilità di aggiungere nuovi eventi al sistema e cancellare eventi esistenti che non sono più rilevanti o necessari. Questa funzionalità di gestione degli eventi consentirà agli amministratori di mantenere aggiornato il sistema e di rispondere prontamente alle esigenze e alle richieste dell'azienda.

In sintesi, l'applicazione proposta mira a ottimizzare il processo di gestione degli eventi per un'azienda specializzata nell'organizzazione di tali attività. Fornendo una piattaforma centralizzata e intuitiva, l'applicazione consentirà agli utenti di pianificare, monitorare e gestire efficacemente tutti gli eventi, migliorando così l'efficienza operativa complessiva dell'organizzazione.
## **Capitolo 2: Architettura del Sistema**
**2.1 Descrizione dell'Architettura Complessiva del Sistema**

L'architettura del sistema è basata su un'approccio client-server, in cui il lato client è rappresentato dall'interfaccia accessibile agli utenti attraverso una applicazione Java, mentre il lato server è composto da diversi componenti software che gestiscono l'accesso ai dati, la logica di business e le comunicazioni con il database.

**2.2 Componenti Chiave del Sistema**

I principali componenti del sistema includono:

- **Interfaccia Utente (UI)**: Questo componente offre un'interfaccia  intuitiva e user-friendly per gli utenti dell'applicazione, consentendo loro di interagire con il sistema e accedere alle funzionalità offerte.

- **Gestione degli Utenti e dei Ruoli**: Questo modulo gestisce l'autenticazione degli utenti, il controllo degli accessi e l'assegnazione dei ruoli all'interno del sistema.

- **Gestione degli Eventi**: Questo componente gestisce la creazione, la visualizzazione, la modifica e l'eliminazione degli eventi nel sistema, assicurando la coerenza e l'integrità dei dati.

- **Web-service in PHP**: Questo servizio web fornisce un'interfaccia per l'accesso ai dati nel database MySQL, consentendo alle diverse componenti del sistema di interagire con il database in modo sicuro e efficiente.

- **Database MySQL**: Questo è il repository principale dei dati del sistema, contenente informazioni sugli utenti, i ruoli, gli eventi e altre entità correlate.

**2.3 Interazioni tra i Componenti**

Le interazioni tra i componenti avvengono principalmente attraverso chiamate HTTP tra il client (applicazione Java) e il server, nonché tra i diversi componenti sul lato server. Quando un utente effettua il login, ad esempio, l'interfaccia utente invia le credenziali al server, che le verifica tramite il modulo di gestione degli utenti. Una volta autenticato, l'utente può interagire con il modulo di gestione degli eventi per visualizzare o modificare gli eventi nel sistema.

**2.4 Diagrammi o Schemi dell'Architettura**

Segue un diagramma semplificato dell'architettura del sistema:

```
     +------------------------------------+
     |           Interfaccia Utente       |
     +------------------------------------+
                    |   |
                    |   |
                    v   v
     +------------------------------------+
     |    Gestione Utenti e Ruoli         |
     +------------------------------------+
                    |   |
                    |   |
                    v   v
     +------------------------------------+
     |          Gestione degli Eventi      |
     +------------------------------------+
                    |   |
                    |   |
                    v   v
     +------------------------------------+
     |         Web-service in PHP          |
     +------------------------------------+
                    |   |
                    |   |
                    v   v
     +------------------------------------+
     |           Database MySQL            |
     +------------------------------------+
```

Questo diagramma illustra le relazioni tra i diversi componenti del sistema e il flusso generale delle interazioni tra di essi.
## **Capitolo 3: Descrizione del Web-service**
**3.1 Scopo del Web-service**

Il Web-service svolge un ruolo fondamentale all'interno dell'architettura del sistema, fornendo un'interfaccia standardizzata per l'accesso e la manipolazione dei dati presenti nel database MySQL. Il suo obiettivo principale è quello di consentire alle diverse componenti del sistema di comunicare in modo efficiente e sicuro, garantendo al contempo l'integrità e la coerenza dei dati.

**3.2 Funzionalità offerte dal Web-service**

Il Web-service offre diverse funzionalità per la gestione degli eventi, degli utenti e dei ruoli all'interno del sistema. Le principali funzionalità incluse sono:

- **Recupero degli Eventi**: Permette di ottenere un elenco di eventi in base a determinati criteri, come la data o il luogo dell'evento.
  
- **Aggiunta di Eventi**: Consente di aggiungere nuovi eventi al sistema, fornendo le informazioni necessarie come data, numero di tecnici e luogo.
  
- **Cancellazione di Eventi**: Permette di eliminare eventi esistenti dal sistema in base all'identificatore univoco dell'evento.
  
- **Recupero degli Utenti e dei Ruoli**: Fornisce la possibilità di recuperare informazioni sugli utenti e i ruoli presenti nel sistema.
  
- **Aggiunta di Utenti e Ruoli**: Consente di aggiungere nuovi utenti e ruoli al sistema, fornendo le informazioni necessarie come nome utente, password e ruolo assegnato.

**3.3 Parametri di Input**

I parametri di input per le richieste al Web-service variano a seconda del metodo HTTP utilizzato e dell'operazione desiderata. Tuttavia, i parametri comuni includono:

- **Metodo HTTP**: Può essere POST per l'aggiunta di dati, GET per il recupero di dati o DELETE per la cancellazione di dati.
  
- **Endpoint**: Specifica l'URL del servizio web a cui inviare la richiesta.
  
- **Oggetti XML**: Rappresentano i dati da inviare o ricevere sotto forma di oggetti XML, come l'oggetto evento, l'oggetto utente e l'oggetto ruolo.

**3.4 Esempi di Richieste e Risposte**

Di seguito sono riportati alcuni esempi di richieste e risposte per le principali funzionalità offerte dal Web-service:

**Recupero degli Eventi (GET)**:
- Richiesta:
```
GET /events?date=2024-03-21 HTTP/1.1
Host: example.com
```
- Risposta:
```
HTTP/1.1 200 OK
Content-Type: application/xml

<events>
  <event>
    <id>1</id>
    <date>2024-03-21</date>
    <technicians>5</technicians>
    <location>Conference Hall</location>
  </event>
  <!-- altri eventi... -->
</events>
```

**Aggiunta di Eventi (POST)**:
- Richiesta:
```
POST /events HTTP/1.1
Host: example.com
Content-Type: application/xml

<event>
  <date>2024-04-15</date>
  <technicians>8</technicians>
  <location>Outdoor Stadium</location>
</event>
```
- Risposta:
```
HTTP/1.1 201 Created
Location: /events/2
```

**Cancellazione di Eventi (DELETE)**:
- Richiesta:
```
DELETE /events/1 HTTP/1.1
Host: example.com
```
- Risposta:
```
HTTP/1.1 204 No Content
```

Questi esempi illustrano il formato delle richieste e delle risposte per le diverse operazioni supportate dal Web-service, fornendo una panoramica delle interazioni possibili con il sistema attraverso questo componente critico.
## **Capitolo 4: Requisiti del Progetto**
**4.1 Requisiti Funzionali**

1. **Gestione degli Utenti e dei Ruoli**:
   - Il sistema deve consentire agli utenti di autenticarsi utilizzando le proprie credenziali.
   - Gli utenti devono essere assegnati a ruoli specifici con relativi privilegi di accesso.

2. **Gestione degli Eventi**:
   - Gli utenti devono poter visualizzare un elenco di eventi associati al loro ruolo.
   - Devono essere fornite funzionalità per l'aggiunta, la modifica e la cancellazione degli eventi.
   - Gli eventi devono essere ordinabili per nome, data o numero di tecnici.
   - Gli utenti devono poter nascondere gli eventi passati e cercare eventi specifici.

3. **Interfaccia Utente**:
   - L'interfaccia utente deve essere intuitiva e user-friendly.
   - Deve supportare le operazioni di login, visualizzazione degli eventi e gestione degli eventi.

**4.2 Requisiti Non Funzionali**

1. **Prestazioni**:
   - Il sistema deve essere reattivo e fornire risposte rapide alle richieste degli utenti.
   - Il tempo di risposta medio per le operazioni principali non deve superare i 2 secondi.

2. **Sicurezza**:
   - Le comunicazioni tra il client e il server devono essere crittografate utilizzando HTTPS.
   - Deve essere implementato un sistema di gestione delle sessioni per proteggere l'autenticazione degli utenti.

3. **Scalabilità**:
   - Il sistema deve essere progettato per gestire un grande numero di utenti e eventi senza degradare le prestazioni.

4. **Affidabilità**:
   - Il sistema deve garantire l'integrità e la disponibilità dei dati in modo affidabile.

**4.3 Requisiti di Integrazione**

1. **Integrazione con il Database MySQL**:
   - Il sistema deve essere integrato con il database MySQL per l'archiviazione e la gestione dei dati degli utenti e degli eventi.

2. **Interfacciamento con il Web-service in PHP**:
   - L'applicazione Java deve comunicare con il Web-service in PHP per accedere e manipolare i dati nel database.

3. **Compatibilità con l'Interfaccia Utente in Java**:
   - Il Web-service deve fornire risposte compatibili con l'interfaccia utente in Java, utilizzando oggetti XML per la trasmissione dei dati.

Questi requisiti definiscono le funzionalità, le prestazioni, la sicurezza e le integrazioni necessarie per garantire il successo del progetto. Assicurandosi che tutti questi requisiti siano soddisfatti, il sistema sarà in grado di fornire un'esperienza utente ottimale e un'efficace gestione degli eventi per l'azienda.
## Implementazione
   - Linguaggi di programmazione utilizzati
   - Framework o librerie utilizzate
   - Descrizione delle principali fasi di sviluppo
   - Struttura del codice sorgente
   - Descrizione delle scelte architetturali o di design
## Test e validazione
   - Strategia di test adottata
   - Risultati dei test e validazione del sistema
## Deployment e gestione del progetto
   - Descrizione del processo di deployment del progetto
   - Pianificazione e gestione delle risorse
   - Monitoraggio e manutenzione del sistema
## Conclusioni
   - Riepilogo dei risultati raggiunti
   - Possibili sviluppi futuri o miglioramenti
## Appendici
 - Glossario dei termini tecnici
 - Riferimenti o link utili
 - Altri dettagli o informazioni aggiuntive
