<%-- 
    Document   : listaTesisti
    Created on : 2-dic-2014, 15.42.08
    Author     : Damiano
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Tesisti</title>

        <script>
            var codice_fiscale = '${person.ssn}';

            $(document).ready(function () {
                $.ajax({
                    url: 'RecuperaTesisti',
                    type: 'POST',
                    data: {id_docente: codice_fiscale},
                    success: function (msg) {


                        var jarray = $.parseJSON(msg);
                        var out = jarray.employees[0].id_studente;
                        var out2 = jarray.employees[0].descrizione;
                        
                        var out3 = jarray.employees[1].id_studente;
                        var out4 = jarray.employees[1].descrizione;
                        /*
                         var i;
                         
                         var out = "<table border='"+1+"'>";
                         for (i = 0; i < arr.length; i++) {
                         out += "<tr><td>" +
                         arr[i]+
                         "</td><td>";
                         }
                         out += "</table>"
                         */


                        $("#a").html(out);
                        $("#b").html(out2);
                        $("#c").html(out3);
                        $("#d").html(out4);
                        
                    }
                });
            });
        </script>


    </head>
    <body>

        <!-- Colored panel, remember to add "panel-color" before applying the color -->
        <div class="panel panel-color panel-danger"><!-- Add class "collapsed" to minimize the panel -->
            <div class="panel-heading">
                <h3 class="panel-title">Richieste Tesi</h3>

                <div class="panel-options">
                    <a href="#" data-toggle="panel">
                        <span class="collapse-icon">&ndash;</span>
                        <span class="expand-icon">+</span>
                    </a>                  
                </div>
            </div>

            <div class="panel-body">               
                <div class="row">
                    <div class="col-sm-3">
                        <b>Nome Studente</b><p id="nome_studente"></p>
                        <p id="a"></p>
                    </div>

                    <div class="col-sm-7">
                        <b>Messaggio</b><p id="titolo_tesi"></p>
                        <p id="b"></p>
                    </div>

                    <div class="col-sm-1 text-right">
                        <b>Rifiuta</b>
                        <button class="btn btn-icon btn-red">
                            <i class="fa-remove"></i>
                        </button>
                    </div>
                    <div class="col-sm-1 text-right">
                        <b>Accetta</b>
                        <button class="btn btn-icon btn-success">
                            <i class="fa-thumbs-o-up"></i>
                        </button>
                    </div>
                </div>
                
                  <div class="row">
                    <div class="col-sm-3">
                        <b>Nome Studente</b><p id="nome_studente"></p>
                        <p id="c"></p>
                    </div>

                    <div class="col-sm-7">
                        <b>Messaggio</b><p id="titolo_tesi"></p>
                        <p id="d"></p>
                    </div>

                    <div class="col-sm-1 text-right">
                        <b>Rifiuta</b>
                        <button class="btn btn-icon btn-red">
                            <i class="fa-remove"></i>
                        </button>
                    </div>
                    <div class="col-sm-1 text-right">
                        <b>Accetta</b>
                        <button class="btn btn-icon btn-success">
                            <i class="fa-thumbs-o-up"></i>
                        </button>
                    </div>
                </div>
            </div>

        </div>

        <!-- Colored panel, remember to add "panel-color" before applying the color -->
        <div class="panel panel-color panel-danger"><!-- Add class "collapsed" to minimize the panel -->
            <div class="panel-heading">
                <h3 class="panel-title">Lista Tesisti</h3>

                <div class="panel-options">
                    <a href="#" data-toggle="panel">
                        <span class="collapse-icon">&ndash;</span>
                        <span class="expand-icon">+</span>
                    </a>                  
                </div>
            </div>

            <div class="panel-body">               
                <div class="row">
                    <div class="col-sm-4">
                        <b>Nome Studente</b><p id="nome_studente"></p>
                        <p></p>
                    </div>

                    <div class="col-sm-4">
                        <b>Titolo Tesi</b><p id="titolo_tesi"></p>
                        <p></p>
                    </div>

                    <div class="col-sm-4">
                        <b>Data Inizio</b><p id="data_inizio_tesi"></p>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
