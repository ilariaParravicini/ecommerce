/* 
 *  CERCA PRODOTTI
 */

function cercaProdotti(nome) {
    //alert("inizio richiesta ajax");

    var xmlHttp = new XMLHttpRequest();

    xmlHttp.onreadystatechange = function() {
        // verrà eseguita quando il server invia la risposta
        if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
            document.getElementById("infoprodotti").innerHTML = xmlHttp.responseText;
        }
    };

    xmlHttp.open('GET', 'ajax.aspx?nome=' + nome, true);
    // in maniera asincrona mando la richiesta.
    xmlHttp.send();

    //alert('Io vengo eseguito anche se il server non ha ancora risposto!');


    //CON LOGICA CLOSURE!!!
//    var app = (function() {
//        var xmlHttp = new XMLHttpRequest();
//        //istanzio oggetto httpreq e configurarlo. grazie al discorso del modulo, 
//        //posso def un unico oggetto che posso riutilizzare
//        //
//        var gestioneRisposta = function() {
//            if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
//                //document oggetto di window: posso usarlo direttamente
//                document.getElementById("infoprodotti").innerHTML = xmlHttp.responseText;
//            }
//        };
//
//        var caricaNomi = function(iniziali) {
//            //setto la richiesta nome parametro=velore di ciò che arriva
//            xmlHttp.open('GET', 'ajax.aspx?nome=' + nome, true);
//            //le inner function hanno accesso a variabili locali
//            xmlHttp.onreadystatechange = gestioneRisposta();
//
//        };
//        return {
//            //nome proprietà oggetto JSON che sto tornando il cui valore è caricaNomi
//            caricaNomi: caricaNomi
//        };
//
//    })();
}


var appValidazione = (function() {

    var validazioneUsername = function() {
        var username = document.getElementById("userName").value;
            if (username.length === 0) {
                toastr.warning("nome utente non inserite", "warning");            
                return false;
//                return true;
            } else {
//                toastr.warning("username non inserita", "warning");            
//                return false;
                return true;
            }
    };

    var validazionePassword = function() {
        var password = document.getElementById("password").value;
            if (password.length === 0) {
                toastr.warning("password non inserita", "warning");
                return false;
            } else {
                return true;
            }
    };

    return{
        validazioneUsername: validazioneUsername,
        validazionePassword: validazionePassword
    };
})();
