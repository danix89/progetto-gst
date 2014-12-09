<%-- 
    Document   : informazioniProfessore
    Created on : 2-dic-2014, 15.16.26
    Author     : Damiano
--%>

<%
    String account_tipo = (String) session.getAttribute("typeOfAccount");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informazioni Professore</title>

        <script>
            var codice_fiscale = '${person.ssn}';
            var tipo_account = '<%= account_tipo%>';

            $(document).ready(function () {
                $.ajax({
                    url: 'RecuperaDatiUtente',
                    type: 'POST',
                    data: {ssn: codice_fiscale, tipo: tipo_account},
                    success: function (msg) {
                        var data_user = $.parseJSON(msg);
                        var nome = data_user.nome;
                        var cognome = data_user.cognome;
                        var matricola = data_user.matricola;
                        var ciclo = data_user.ciclo;
                        var università = data_user.università;
                        var dipartimento = data_user.dipartimento;

                        $("#università").html(università);
                        $("#fullname").html(nome + " " + cognome);
                        $("#dipartimento").html(dipartimento);

                    }
                });
            });
        </script>   
    </head>
    <body>

        <div class="panel panel-color panel-danger"><!-- Add class "collapsed" to minimize the panel -->
            <div class="panel-heading">
                <h3 class="panel-title">I Tuoi Dati</h3>

                <div class="panel-options">
                    <a href="#" data-toggle="panel">
                        <span class="collapse-icon">&ndash;</span>
                        <span class="expand-icon">+</span>
                    </a>                  
                </div>
            </div>

            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-12">
                        <b>Nome e Cognome</b><p id="fullname"></p>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-sm-6">
                        <b>Dipartimento</b><p id="dipartimento"></p>
                    </div>

                    <div class="col-sm-6">
                        <b>Cordi di Laurea</b><p id="corso_laurea"></p>
                    </div>

                </div>
            </div>
        </div>        

    </body>
</html>
