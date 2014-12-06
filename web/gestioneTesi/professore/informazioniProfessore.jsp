<%-- 
    Document   : informazioniProfessore
    Created on : 2-dic-2014, 15.16.26
    Author     : Damiano
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informazioni Professore</title>
    </head>
    <script>
    $(document).ready(function () {
                $.ajax({
                    url: 'RecuperaDatiUtente',
                    type: 'POST',
                    data: {ssn: 'linkin836@hotmail.com', tipo: 'professore'},
                    success: function (msg) {
                        var data_user = $.parseJSON(msg);
                        var nome = data_user.nome;
                        var cognome = data_user.cognome;
                        var matricola = data_user.matricola;
                        var ciclo = data_user.ciclo;
                        var università = data_user.università;
                        var dipartimento= data_user.dipartimento;
                        
                        $("#università").html(università);
                        $("#fullname").html(nome + " " + cognome);
                        $("#dipartimento").html(dipartimento);

                    }
                });
            });
       </script>    
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
                        <p id="fullname">Nome e Cognome</p>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-sm-6">
                        <p id="dipartimento">Dipartimento</p>
                    </div>

                    <div class="col-sm-6">
                        <p id="corso_laurea">Corsi di laurea</p>
                    </div>

                </div>
            </div>
        </div>        
        
    </body>
</html>
