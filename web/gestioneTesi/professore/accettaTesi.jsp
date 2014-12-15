<%-- 
    Document   : accettaTesi
    Created on : 13-dic-2014, 20.28.13
    Author     : Damiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Xenon Boostrap Admin Panel" />


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accetta Tesi</title>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic">
        <link rel="stylesheet" href="../../assets/css/fonts/linecons/css/linecons.css">
        <link rel="stylesheet" href="../../assets/css/fonts/fontawesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="../../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../../assets/css/xenon-core.css">
        <link rel="stylesheet" href="../../assets/css/xenon-forms.css">
        <link rel="stylesheet" href="../../assets/css/xenon-components.css">
        <link rel="stylesheet" href="../../assets/css/xenon-skins.css">
        <link rel="stylesheet" href="../../assets/css/custom.css">

        <script src="../../assets/js/jquery-1.11.1.min.js"></script>



    </head>
    <body>


        <div id="inCorso" class="panel panel-color panel-danger"><!-- Add class "collapsed" to minimize the panel -->
            <div class="panel-heading">
                <h3 class="panel-title">Inserisci Informazioni Tesi</h3>
            </div>


            <div class="panel-body">

                <form  role="form" action="${pageContext.request.contextPath}/accettaTesi" method="POST" class="form-horizontal validate">

                    <br>

                    <div class="form-group">
                        <label class="col-sm-2 control-label text-primary" for="titolo">Bozza Titolo</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="titolo" data-validate="required" data-message-required="Campo obbligatorio." placeholder="Inserisci il titolo" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label text-primary" for="abstract">Descrizione Argomento Tesi</label>

                        <div class="col-sm-10">
                            <textarea class="form-control" name="abstract" cols="5" data-validate="required" data-message-required="Campo obbligatorio." placeholder="Inserisci l'abstract"  rows="6" ></textarea>
                        </div>
                    </div>

                    <br>

                    <div class="form-group">
                        <div class="col-sm-4">

                            <div class="input-group">
                                <input placeholder="Data Inizio" name="data_inizio" type="text" class="form-control datepicker" data-format="D, dd MM yyyy">

                                <div class="input-group-addon">
                                    <a href="#"><i class="linecons-calendar"></i></a>
                                </div>
                            </div>
                        </div>

                    </div>

                    <br>

                    <form role="form" class="form-horizontal">

                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="tagsinput-1">Seleziona Argomenti Tesi</label>

                            <div class="col-sm-9">

                                <script type="text/javascript">
                                    jQuery(document).ready(function ($)
                                    {
                                        $("#multi-select").multiSelect({
                                            afterInit: function ()
                                            {
                                                // Add alternative scrollbar to list
                                                this.$selectableContainer.add(this.$selectionContainer).find('.ms-list').perfectScrollbar();
                                            },
                                            afterSelect: function ()
                                            {
                                                // Update scrollbar size
                                                this.$selectableContainer.add(this.$selectionContainer).find('.ms-list').perfectScrollbar('update');
                                            }
                                        });
                                    });</script>
                                <select class="form-control" multiple="multiple" id="multi-select" name="my-select[]">
                                    <option value="1">Silky Door</option>
                                    <option value="2">The Absent Twilight</option>

                                </select>

                            </div>
                        </div>

                    </form>

                    <br>



                    <div class="form-group">
                        <div class="col-sm-12 text-right">
                            <button type="submit" class="btn btn-danger btn-icon btn-icon-standalone btn-lg">
                                <i class="fa-graduation-cap"></i>
                                <span>Salva Modifiche</span>
                            </button>
                        </div>
                    </div>



            </div>
        </div>


        <!-- Imported styles on this page -->
        <link rel="stylesheet" href="../../assets/js/daterangepicker/daterangepicker-bs3.css">
        <link rel="stylesheet" href="../../assets/js/select2/select2.css">
        <link rel="stylesheet" href="../../assets/js/select2/select2-bootstrap.css">
        <link rel="stylesheet" href="../../assets/js/multiselect/css/multi-select.css">

        <!-- Bottom Scripts -->

        <script src="../../assets/js/moment.min.js"></script>


        <!-- Imported scripts on this page -->
        <script src="../../assets/js/daterangepicker/daterangepicker.js"></script>
        <script src="../../assets/js/datepicker/bootstrap-datepicker.js"></script>
        <script src="../../assets/js/timepicker/bootstrap-timepicker.min.js"></script>
        <script src="../../assets/js/colorpicker/bootstrap-colorpicker.min.js"></script>
        <script src="../../assets/js/select2/select2.min.js"></script>
        <script src="../../assets/js/jquery-ui/jquery-ui.min.js"></script>
        <script src="../../assets/js/selectboxit/jquery.selectBoxIt.min.js"></script>
        <script src="../../assets/js/tagsinput/bootstrap-tagsinput.min.js"></script>
        <script src="../../assets/js/typeahead.bundle.js"></script>
        <script src="../../assets/js/handlebars.min.js"></script>
        <script src="../../assets/js/multiselect/js/jquery.multi-select.js"></script>


        <!-- JavaScripts initializations and stuff -->
        <script src="../../assets/js/xenon-custom.js"></script>



        <!-- Bottom Scripts -->
        <script src="../../assets/js/bootstrap.min.js"></script>
        <script src="../../assets/js/TweenMax.min.js"></script>
        <script src="../../assets/js/resizeable.js"></script>
        <script src="../../assets/js/joinable.js"></script>
        <script src="../../assets/js/xenon-api.js"></script>
        <script src="../../assets/js/xenon-toggles.js"></script>

        <script src="../../assets/js/datepicker/bootstrap-datepicker.js"></script>
        <script src="../../assets/js/multiselect/js/jquery.multi-select.js"></script>
        <script src="../../assets/js/tagsinput/bootstrap-tagsinput.min.js"></script>
        <script src="../../assets/js/dropzone/dropzone.min.js"></script>

        <!-- JavaScripts initializations and stuff -->
        <script src="../../assets/js/xenon-custom.js"></script>
    </body>
</html>
