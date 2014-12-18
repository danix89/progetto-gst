<%-- 
    Document   : cronologiaDocente
    Created on : 2-dic-2014, 19.10.02
    Author     : Ciro
--%>

<%@page import="java.util.logging.Logger"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cronologia Docente</title>
        <script>
            var codice_fiscale = '${person.ssn}';
            var n;

            $(document).ready(function () {
                $.ajax({
                    url: 'RecuperaCronologiaDocente',
                    type: 'POST',
                    data: {id_docente: codice_fiscale},
                    success: function (cronologiaD) {
                        alert("ajax docente");
                        if (cronologiaD != "null") {
                            var array_cronologia = $.parseJSON(cronologiaD);
                            n = array_cronologia.employees[0].size;

                            for (var i = n - 1; i >= 0; i--) {

                                var temp = document.createElement("li");
                                var str = " <time class=\"cbp_tmtime\" datetime=\"2014-10-03T18:30\"><span class=\"hidden\"> 03/10/2014</span> <span class=\"large\" id=\"data" + i + "\"></span></time> <div class=\"cbp_tmicon timeline-bg-gray\"> <i class=\"fa-user\"></i>  </div> <div class=\"cbp_tmlabel empty\"> <span id=\"testo" + i + "\" ></span>  </div> ";
                                temp.innerHTML = str;
                                $("#principale").append(temp);


                            }

                            for (var i = n - 1; i >= 0; i--) {
                                var nomeStudente = array_cronologia.employees[i].nomeStudente;
                                var testo = array_cronologia.employees[i].testo;
                                var ID_Studente = array_cronologia.employees[i].ID_Studente;
                                var ID_Docente = array_cronologia.employees[i].ID_Docente;
                                var Data_Notifica = array_cronologia.employees[i].Data_Notifica;
                                $("#testo" + i).html("Con lo studente " + nomeStudente + ": " + testo);
                                $("#data" + i).html(Data_Notifica);

                            }

                        } else {
                            var i = 0;
                            var testo = "Quando inizierai ad interagire con la piattaforma, qui troverai le tue notifiche.";
                            var temp = document.createElement("li");
                            var str = " <time class=\"cbp_tmtime\" datetime=\"2014-10-03T18:30\"><span class=\"hidden\"> 03/10/2014</span> <span class=\"large\" id=\"data" + i + "\"></span></time> <div class=\"cbp_tmicon timeline-bg-gray\"> <i class=\"fa-user\"></i>  </div> <div class=\"cbp_tmlabel empty\"> <span id=\"testo" + i + "\" ></span>  </div> ";
                            temp.innerHTML = str;
                            $("#principale").append(temp);
                            $("#testo" + i).html("Messaggio di sistema: " + testo);
                            var dat = new Date();
                            var gg = dat.getDate();
                            var mm = (dat.getMonth() + 1);
                            var aa = dat.getFullYear();
                            var data_corr = gg + "/" + mm + "/" + aa;
                            $("#data" + i).html(data_corr);

                        }
                    }
                
                });
            });
        </script>

    </head>
    <body>
        <ul class="cbp_tmtimeline" id="principale">




        </ul>

    </body>
</html>
