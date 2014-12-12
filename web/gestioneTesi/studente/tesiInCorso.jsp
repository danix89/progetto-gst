<%-- 
    Document   : tesiInCorso
    Created on : 12-dic-2014, 10.59.06
    Author     : CosimoAlessandro
--%>

<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="assets/js/multiselect/css/multi-select.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div id="inCorso" class="panel panel-color panel-danger"><!-- Add class "collapsed" to minimize the panel -->
            <div class="panel-heading">
                <h3 class="panel-title">Tesi In Corso</h3>
            </div>


            <div class="panel-body">
               

                <form  role="form" action="${pageContext.request.contextPath}/modificaTesi" method="POST" class="form-horizontal validate">
                   
                    <br>
                    
                    <div class="form-group">
                        <label class="col-sm-2 control-label text-primary" for="titolo">Titolo</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="titolo" data-validate="required" data-message-required="Campo obbligatorio." placeholder="Inserisci il titolo" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label text-primary" for="abstract">Abstract</label>

                        <div class="col-sm-10">
                            <textarea type="text" class="form-control" name="abstract" cols="5" data-validate="required" data-message-required="Campo obbligatorio." placeholder="Inserisci l'abstract" ></textarea>
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
                    


                    <div class="col-sm-4">

                        <div class="input-group">
                            <input placeholder="Data Fine Prevista" name="data_fine_prevista" type="text" class="form-control datepicker" data-format="D, dd MM yyyy">

                            <div class="input-group-addon">
                                <a href="#"><i class="linecons-calendar"></i></a>
                            </div>
                        </div>
                    </div>


                    <div class="col-sm-4">

                        <div class="input-group">
                            <input placeholder="Data Fine" name="data_fine" type="text" class="form-control datepicker" data-format="D, dd MM yyyy">

                            <div class="input-group-addon">
                                <a href="#"><i class="linecons-calendar"></i></a>
                            </div>
                        </div>
                    </div>
                             </div>

                    <br>
                    

                        <div class="form-group-separator"></div>
                        
                        <br>

                        <div class="form-group">
                            <label class="col-sm-2 control-label text-primary" for="tagsinput-1">Seleziona Relatori</label>

                            <div class="col-sm-10">

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
                                    });
                                </script>
                                <select class="form-control" multiple="multiple" id="multi-select" name="professors[]">
                                    <option value="1">Silky Door</option>
                                    <option value="2">The Absent Twilight</option>
                                    <option value="3">Tales of Flames</option>
                                    <option value="4">The Princess's Dream</option>
                                    <option value="5">The Fairy of the Wind</option>
                                    <option value="6">Children in the Boy</option>
                                    <option value="7">Frozen Savior</option>
                                    <option value="8">The Missing Thorns</option>
                                    <option value="9">Healing of Serpent</option>
                                    <option value="10">The Voyagers's Girlfriend</option>
                                    <option value="11">The Nothing of the Gate</option>
                                    <option value="12">Healing in the Scent</option>
                                    <option value="13">Final Twins</option>
                                    <option value="14">The Willing Rose</option>
                                    <option value="15">Thorn of Emperor</option>
                                    <option value="16" selected>The Predator's Pirates</option>
                                    <option value="17">The Lord of the Girl</option>
                                    <option value="18" selected>Flowers in the Spirit</option>
                                    <option value="19" selected>Healing in the Silence</option>
                                    <option value="20">Planet of Bridges</option>
                                </select>

                            </div>
                        </div>
                        
                        <br>

                    <div class="form-group-separator"></div>
                    
                    <br>

                    <div class="form-group">
                        <label class="col-sm-2 control-label text-primary" for="tagsinput-1">Argomenti</label>

                        <div class="col-sm-10">



                            <div class="input-group">
                                <input type="text" class="form-control" id="typeahead-1" />						
                                <span class="input-group-addon">
                                    <i class="fa-globe"></i>
                                </span>
                            </div>

                        </div>
                    </div>
                    
                    <br>

                    <div class="form-group-separator"></div>

                    <script type="text/javascript">
                        jQuery(document).ready(function ($)
                        {
                            var i = 1,
                                    $example_dropzone_filetable = $("#example-dropzone-filetable"),
                                    example_dropzone = $("#advancedDropzone").dropzone({
                                url: 'data/upload-file.php',
                                // Events
                                addedfile: function (file)
                                {
                                    if (i == 1)
                                    {
                                        $example_dropzone_filetable.find('tbody').html('');
                                    }

                                    var size = parseInt(file.size / 1024, 10);
                                    size = size < 1024 ? (size + " KB") : (parseInt(size / 1024, 10) + " MB");

                                    var $el = $('<tr>\
                                                                                                        <td class="text-center">' + (i++) + '</td>\
                                                                                                        <td>' + file.name + '</td>\
                                                                                                        <td><div class="progress progress-striped"><div class="progress-bar progress-bar-warning"></div></div></td>\
                                                                                                        <td>' + size + '</td>\
                                                                                                        <td>Uploading...</td>\
                                                                                                </tr>');

                                    $example_dropzone_filetable.find('tbody').append($el);
                                    file.fileEntryTd = $el;
                                    file.progressBar = $el.find('.progress-bar');
                                },
                                uploadprogress: function (file, progress, bytesSent)
                                {
                                    file.progressBar.width(progress + '%');
                                },
                                success: function (file)
                                {
                                    file.fileEntryTd.find('td:last').html('<span class="text-success">Uploaded</span>');
                                    file.progressBar.removeClass('progress-bar-warning').addClass('progress-bar-success');
                                },
                                error: function (file)
                                {
                                    file.fileEntryTd.find('td:last').html('<span class="text-danger">Failed</span>');
                                    file.progressBar.removeClass('progress-bar-warning').addClass('progress-bar-red');
                                }
                            });

                            $("#advancedDropzone").css({
                                minHeight: 200
                            });

                        });
                    </script>

                    <br />
                    <div class="row">
                        <div class="col-sm-3 text-center">

                            <div id="advancedDropzone" class="droppable-area">
                                Drop Files Here
                            </div>

                        </div>
                        <div class="col-sm-9">

                            <table class="table table-bordered table-striped" id="example-dropzone-filetable">
                                <thead>
                                    <tr>
                                        <th width="1%" class="text-center">#</th>
                                        <th width="50%">Name</th>
                                        <th width="20%">Upload Progress</th>
                                        <th>Size</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td colspan="5">Files list will appear here</td>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-12 text-right">
                            <button type="submit" class="btn btn-danger btn-icon btn-icon-standalone btn-lg">
                                <i class="fa-graduation-cap"></i>
                                <span>Salva Modifiche</span>
                            </button>
                        </div>
                    </div>

                </form>

            </div>
        </div>


        <script src="assets/js/datepicker/bootstrap-datepicker.js"></script>
        <script src="assets/js/multiselect/js/jquery.multi-select.js"></script>
        <script src="assets/js/tagsinput/bootstrap-tagsinput.min.js"></script>
        <script src="assets/js/dropzone/dropzone.min.js"></script>

    </body>
</html>
