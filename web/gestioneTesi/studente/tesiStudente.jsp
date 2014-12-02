<%-- 
    Document   : tesiStudente
    Created on : 2-dic-2014, 12.07.51
    Author     : CosimoAlessandro
--%>

<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="assets/js/select2/select2.css">
        <link rel="stylesheet" href="assets/js/select2/select2-bootstrap.css">



        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script type="text/javascript">
            jQuery(document).ready(function ($)
            {
                $("#dipartimenti").select2({
                    placeholder: 'Seleziona il tuo dipartimento...',
                    allowClear: true
                }).on('select2-open', function ()
                {
                    // Adding Custom Scrollbar
                    $(this).data('select2').results.addClass('overflow-hidden').perfectScrollbar();
                });

            });



            jQuery(document).ready(function ($)
            {
                $("#corso_laurea").select2({
                    placeholder: 'Seleziona il tuo corso di laurea...',
                    allowClear: true
                }).on('select2-open', function ()
                {
                    // Adding Custom Scrollbar
                    $(this).data('select2').results.addClass('overflow-hidden').perfectScrollbar();
                });

            });

            jQuery(document).ready(function ($)
            {
                $("#professore").select2({
                    placeholder: 'Seleziona il professore...',
                    allowClear: true
                }).on('select2-open', function ()
                {
                    // Adding Custom Scrollbar
                    $(this).data('select2').results.addClass('overflow-hidden').perfectScrollbar();
                });

            });
        </script>

    </head>
    <body>

        <!-- Form richiesta tesi -->

        <div class="panel panel-color panel-danger"><!-- Add class "collapsed" to minimize the panel -->
            <div class="panel-heading">
                <h3 class="panel-title">Richiesta Tesi</h3>

            </div>
            
            <div class="panel-body">
                
            <form role="form" class="form-horizontal">

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="dipartimenti">Dipartimenti</label>

                    <div class="col-sm-10">
                        <select class="form-control" name="dipartimenti" id="dipartimenti">
                            <option></option>
                            <option value="distra">DISTRA</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="corso_laurea">Corsi di laurea</label>

                    <div class="col-sm-10">
                        <select class="form-control" name="corso_laurea" id="corso_laurea">
                            <option></option>
                            <option value="mit">Tecnologie Informatiche e Management</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="professore">Professori</label>

                    <div class="col-sm-10 ">
                        <select class="form-control" name="professore" id="professore">
                            <option > </option>
                            <option value="delucia">De Lucia</option>
                            <option value="ferrucci">Ferrucci</option>
                        </select>
                    </div>
                </div>

                <div class="form-group-separator"></div>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="field-5">Messaggio richiesta</label>

                    <div class="col-sm-10">
                        <textarea class="form-control" cols="5" id="messaggio" name="messaggio"></textarea>
                    </div>
                </div>

                <div class="form-group-separator"></div>

                <div class="form-group">
                    <div class="col-sm-12 text-right">
                        <button class="btn btn-danger btn-icon btn-icon-standalone btn-lg">
                            <i class="fa-envelope"></i>
                            <span>Invia Richiesta</span>
                        </button>
                    </div>
                </div>

            </form>
            </div>
        </div>


            <!--Bottom Scripts-->
            <script src="assets/js/select2/select2.min.js"></script>


    </body>
</html>
