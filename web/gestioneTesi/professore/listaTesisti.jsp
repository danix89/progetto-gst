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

                        var jarray_size = jarray.mainOb[0].size;

                        var i = 0;
                        var temp;

                        for (i = 0; i < jarray_size; i++) {
                            var row = document.createElement("div");
                            row.setAttribute("class", "row");

                            var stringa = "<div class=\"col-sm-3\"><b>Nome Studente</b><p id=\"nome_studente\"></p><p id=\"a" + i + "\"></p></div><div class=\"col-sm-7\"><b>Messaggio</b><p id=\"titolo_tesi\"></p><p id=\"b" + i + "\"></p></div><div class=\"col-sm-1 text-right\"><b>Rifiuta</b><button class=\"btn btn-icon btn-red\"><i class=\"fa-remove\"></i></button></div><div class=\"col-sm-1 text-right\"><b>Accetta</b><button class=\"btn btn-icon btn-success\"><i class=\"fa-thumbs-o-up\"></i></button>";

                            row.innerHTML = stringa;
                            $("#richieste").append(row);

                        }


                        for (i = 0; i <= jarray_size; i++) {
                            var out = jarray.mainOb[i].id_studente;
                            var out2 = jarray.mainOb[i].descrizione;

                            $("#a" + i).html(out);
                            $("#b" + i).html(out2);


                        }
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

            <div class="panel-body" id="richieste">               

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
