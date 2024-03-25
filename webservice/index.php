<?php

// Connessione al database MySQL
$servername = "localhost";
$username = "root";
$password = "";
$database = "gestionaleEventi_masterDB";

$conn = new mysqli($servername, $username, $password, $database);

// Controllo della connessione
if ($conn->connect_error) {
    die("Connessione fallita: " . $conn->connect_error);
}

// Funzione per il recupero degli eventi
function recuperaEventiPerData($date) {
    global $conn;
    $sql = "SELECT * 
    FROM eventi AS E 
    INNER JOIN eventiRuoli AS ER USING(id_evento)
    INNER JOIN ruoli AS R USING(id_ruolo)
    WHERE E.date >= '$date'
    ORDER BY E.id_evento";
    $result = $conn->query($sql);
    
    $events = array();
    $id_evento_attuale = "";
    if ($result->num_rows > 0) {
        while($row = $result->fetch_assoc()) {
            if($id_evento_attuale != $row['id_evento']){
                $id_evento_attuale = $row['id_evento'];
                $row->ruoli = array();
                $events[] = $row; 
            }
            $events[$id_evento_attuale]['ruoli'].array_push($row['descrizione_ruolo']);
        }
    }
    return $events;
}

// Funzione per la cancellazione di eventi
function eliminaEvento($eventId) {
    global $conn;
    $sql = "DELETE FROM events WHERE id = $eventId";
    
    if ($conn->query($sql) === TRUE) {
        return "Evento cancellato con successo";
    } else {
        return "Errore durante la cancellazione dell'evento: " . $conn->error;
    }
}

function retrieveEventId(){
    global $conn;
    $result = $conn -> query("SELECT id_evento FROM eventi ORDER BY id_evento desc");
    $id = 0;

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $id = (int) $row['id_evento'];
    }

    return $id;
}

function aggiungiEvento($id, $evento){
    global $conn;
    $nome_evento = $evento -> nome;
    $num_tecnici = $evento -> tecnici;
    $data = $evento -> data;
    $ruoli = $evento -> ruoli;

    $conn -> query("INSERT INTO eventi VALUES ('$id','$nome_evento', $num_tecnici, '$data')");
    return $ruoli;
}

function inserimentoRuoli($id, $ruoli){
    global $conn;
    $roles = array();
    $result = $conn -> query("SELECT * from ruoli");
    if($result->num_rows > 0){
        while($row = $result->fetch_assoc()){
            $roles[] = $row;
        }
        foreach($ruoli as $ruolo){
            foreach($roles as $role){
                inserisciRuolo($ruolo, $role, $id);
            }
        }
    }
}

function inserisciRuolo($ruolo, $role, $id){
    global $conn;
    if($role['descrizione_ruolo'] == $ruolo){
        $id_ruolo = $role['id_ruolo'];
        $conn -> query("INSERT INTO eventi_ruoli VALUES ('$id','$id_ruolo')");
    }
}

// Gestione delle richieste
if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    if (isset($_GET['date'])) {
        $date = $_GET['date'];
        $events = recuperaEventiPerData($date);
        header('Content-Type: application/xml; charset=utf-8');
        $response = "<?xml version='1.0' encoding='UTF-8'?>";
        $response .= "<eventi>";
        foreach ($events as $event) {
            $response .= "<evento>";
            $response .= "<id>" . $event['id_evento'] . "</id>";
            $response .= "<nome>" . $event['nome_evento'] . "</nome>";
            $response .= "<tecnici>" . $event['num_tecnici'] . "</tecnici>";
            $response .= "<data>" . $event['data'] . "</data>";
            $response .= "<ruoli>";
            foreach($event['ruoli'] as $ruolo){
                $response .= "<ruolo>" . $ruolo . "</ruolo>";
            }
            $response .= "</ruoli>";
            $response .= "</evento>";
        };

        $response .= "</eventi>";
        echo $response;
    }
} else if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $request = file_get_contents('php://input');
    $xml = new DOMDocument();
    $xml -> loadXML($request);

    try {
        if ($xml -> schemaValidate("schemas/evento.xsd")) {
            $evento = simplexml_load_string($request);

            $id = retrieveEventId();

            $id++;

            $ruoli = aggiungiEvento($id, $evento);

            inserimentoRuoli($id, $ruoli);
        }
    } catch (\Exception $e) {}
} else if ($_SERVER['REQUEST_METHOD'] === 'DELETE') {
    parse_str(file_get_contents("php://input"),$post_vars);
    $eventId = $post_vars['eventId'];
    echo eliminaEvento($eventId);
}

$conn->close();
?>
