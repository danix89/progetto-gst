<%-- 
    Document   : cronologiaStudente
    Created on : 2-dic-2014, 19.10.02
    Author     : Damiano
--%>

<%@page import="java.util.logging.Logger"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cronologia Studente</title>
        <script>
            alert("apro cronologia");
            
            var codice_fiscale = '${person.ssn}';

            $(document).ready(function () {
                $.ajax({
                    url: 'RecuperaCronologiaStudente',
                    type: 'POST',
                    data: {id_studente: codice_fiscale},
                    success: function (cronologiaS) {
                        var dati_cronologia = $.parseJSON(cronologiaS);
                        alert(dati_cronologia.size());
                        
                        for (int i = 0; i < dati_cronologia.size(); i++) {

                            var testo = dati_cronologia[i].testo;
                            var ID_Studente = dati_cronologia[i].ID_Studente;
                            var ID_Docente = dati_cronologia[i].ID_Docente;
                            var Data_Notifica = dati_cronologia[i].Data_Notifica;
                            
                           

                            $("#testo"+i).html(testo);
                  //          $("#messaggio_richiesta").html(messaggio_richiesta);
                         <% System.out.println("cicla"); %>
}
                    }
                });
            });
        </script>

    </head>
    <body>
        <ul class="cbp_tmtimeline">
            <li>
                <time class="cbp_tmtime" datetime="2014-10-03T18:30"><span class="hidden">03/10/2014</span> <span class="large">Now</span></time>

                <div class="cbp_tmicon timeline-bg-gray">
                    <i class="fa-user"></i>
                </div>

                <div class="cbp_tmlabel empty">
                    <span id="testo0"></span>
                </div>
            </li>

        <!--    <li>
                <time class="cbp_tmtime" datetime="2014-10-03T03:45"><span>03:45 AM</span> <span>Today</span></time>

                <div class="cbp_tmicon timeline-bg-info">
                    <i class="fa-paper-plane-o"></i>
                </div>

                <div class="cbp_tmlabel">
                    <h2><a href="#">Nome Studente</a> <span>ha inviato la richiesta tesi al professore </span></h2>
                    <p>Salve Prof, sono lo studente Pippo. <br> vorrei richiedere la tesi x.... </p>
                </div>
            </li>

            <li>
                <time class="cbp_tmtime" datetime="2014-10-02T13:22"><span>01:22 PM</span> <span>Yesterday</span></time>

                <div class="cbp_tmicon timeline-bg-red">
                    <i class="fa-book"></i>
                </div>

                <div class="cbp_tmlabel">
                    <h2><a href="#">Il Prof. A De Lucia </a><span>ha accettato la tua richiesta tesi</span></h2>
                    <p>You have a meeting at <strong>Laborator Office</strong> Today.</p>
                </div>
            </li>

            <li>
                <time class="cbp_tmtime" datetime="2014-09-19T20:23"><span>08:23 PM</span> <span>Two weeks ago</span></time>

                <div class="cbp_tmicon timeline-bg-warning">
                    <i class="fa-book"></i>
                </div>

                <div class="cbp_tmlabel">
                    <h2><a href="#">Nome Studente </a> <span>ha richiesto il completamento tesi</span></h2>

                </div>
            </li>

            <li>
                <time class="cbp_tmtime" datetime="2014-10-02T13:22"><span>01:22 PM</span> <span>Yesterday</span></time>

                <div class="cbp_tmicon timeline-bg-success">
                    <i class="fa-thumbs-up"></i>
                </div>

                <div class="cbp_tmlabel">
                    <h2><a href="#">Il Prof. A De Lucia </a><span>ha confermato la tua tesi</span></h2>
                </div>
            </li>   -->

        </ul>

    </body>
</html>
