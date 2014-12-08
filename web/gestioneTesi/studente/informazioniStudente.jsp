<%-- 
    Document   : informazioniStudente
    Created on : 2-dic-2014, 12.01.38
    Author     : CosimoAlessandro
--%>

<%
    String account_tipo = (String) session.getAttribute("typeOfAccount");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informazioni Studente</title>

        <script>
            var codice_fiscale= '${person.ssn}';
            var tipo_account='<%= account_tipo %>';
            
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
                        var universit� = data_user.universit�;
                        var dipartimento=data_user.dipartimento;
                        
                        $("#universit�").html(universit�);
                        $("#fullname").html(nome + " " + cognome);
                        $("#matricola").html(matricola);
                        $("#ciclo").html(ciclo);
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
                        <b>Universit� </b><p id="universit�"></p>
                    </div>
             </div>
                 <br>
                <div class="row">
                    <div class="col-sm-8">
                        <b>Nome e Cognome </b><p id="fullname"></p>
                    </div>

                    <div class="col-sm-4">
                        <b>Matricola </b><p id="matricola"></p>
                    </div>

                </div>
                <br>
                <div class="row">
                    <div class="col-sm-2">
                        <b>Ciclo </b><p id="ciclo"></p>
                    </div>

                    <div class="col-sm-5">
                        <b>Dipartimento </b><p>Dipartimento</p>
                    </div>

                    <div class="col-sm-5">
                        <b>Corso di laurea: </b><p>Corso di laurea</p>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
