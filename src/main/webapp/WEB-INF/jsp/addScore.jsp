<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>录入分数</title>

    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui-1.10.3.full.min.css" />

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

    <!-- ace styles -->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css" />

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/assets/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="page-content">
    <div class="page-header">
        <h1>
            录入分数
        </h1>
    </div><!-- /.page-header -->

    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->

            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/student/addScore/${id}"
                  method="post" name="addScore">
                <c:forEach  items="${subjectSet}" var="subject">
                    <input type="text" name="score"/>${subject.name}<br>
                </c:forEach>

                <div class="clearfix form-actions">
                    <div class="col-md-offset-3 col-md-9">
                        <button class="btn btn-info" type="submit">
                            <i class="icon-ok bigger-110"></i>
                            Submit
                        </button>

                        &nbsp; &nbsp; &nbsp;
                        <button class="btn" type="reset">
                            <i class="icon-undo bigger-110"></i>
                            Reset
                        </button>
                    </div>
                </div>
                <div class="space-12"></div>
            </form>

        </div>
    </div>



    <!-- basic scripts -->

    <!--[if !IE]> -->

    <!--[if !IE]> -->

    <script type="text/javascript">
        window.jQuery || document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
    </script>

    <!-- <![endif]-->

    <!--[if IE]>
    <script type="text/javascript">
        window.jQuery || document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
    </script>
    <![endif]-->

    <script type="text/javascript">
        if("ontouchend" in document) document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
    </script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/typeahead-bs2.min.js"></script>

    <!-- page specific plugin scripts -->

    <script src="${pageContext.request.contextPath}/assets/js/jquery-ui-1.10.3.full.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>

    <!-- ace scripts -->

    <script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

    <!-- inline scripts related to this page -->

    <script type="text/javascript">
        jQuery(function($) {

            $( "#datepicker" ).datepicker({
                showOtherMonths: true,
                selectOtherMonths: false,
                //isRTL:true,


                /*
                 changeMonth: true,
                 changeYear: true,

                 showButtonPanel: true,
                 beforeShow: function() {
                 //change button colors
                 var datepicker = $(this).datepicker( "widget" );
                 setTimeout(function(){
                 var buttons = datepicker.find('.ui-datepicker-buttonpane')
                 .find('button');
                 buttons.eq(0).addClass('btn btn-xs');
                 buttons.eq(1).addClass('btn btn-xs btn-success');
                 buttons.wrapInner('<span class="bigger-110" />');
                 }, 0);
                 }
                 */
            });


            //override dialog's title function to allow for HTML titles
            $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
                _title: function(title) {
                    var $title = this.options.title || '&nbsp;'
                    if( ("title_html" in this.options) && this.options.title_html == true )
                        title.html($title);
                    else title.text($title);
                }
            }));

            $( "#id-btn-dialog1" ).on('click', function(e) {
                e.preventDefault();

                var dialog = $( "#dialog-message" ).removeClass('hide').dialog({
                    modal: true,
                    title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i> jQuery UI Dialog</h4></div>",
                    title_html: true,
                    buttons: [
                        {
                            text: "Cancel",
                            "class" : "btn btn-xs",
                            click: function() {
                                $( this ).dialog( "close" );
                            }
                        },
                        {
                            text: "OK",
                            "class" : "btn btn-primary btn-xs",
                            click: function() {
                                $( this ).dialog( "close" );
                            }
                        }
                    ]
                });

                /**
                 dialog.data( "uiDialog" )._title = function(title) {
						title.html( this.options.title );
					};
                 **/
            });


            $( "#id-btn-dialog2" ).on('click', function(e) {
                e.preventDefault();

                $( "#dialog-confirm" ).removeClass('hide').dialog({
                    resizable: false,
                    modal: true,
                    title: "<div class='widget-header'><h4 class='smaller'><i class='icon-warning-sign red'></i> Empty the recycle bin?</h4></div>",
                    title_html: true,
                    buttons: [
                        {
                            html: "<i class='icon-trash bigger-110'></i>&nbsp; Delete all items",
                            "class" : "btn btn-danger btn-xs",
                            click: function() {
                                $( this ).dialog( "close" );
                            }
                        }
                        ,
                        {
                            html: "<i class='icon-remove bigger-110'></i>&nbsp; Cancel",
                            "class" : "btn btn-xs",
                            click: function() {
                                $( this ).dialog( "close" );
                            }
                        }
                    ]
                });
            });



            //autocomplete
            var availableTags = [
                "ActionScript",
                "AppleScript",
                "Asp",
                "BASIC",
                "C",
                "C++",
                "Clojure",
                "COBOL",
                "ColdFusion",
                "Erlang",
                "Fortran",
                "Groovy",
                "Haskell",
                "Java",
                "JavaScript",
                "Lisp",
                "Perl",
                "PHP",
                "Python",
                "Ruby",
                "Scala",
                "Scheme"
            ];
            $( "#tags" ).autocomplete({
                source: availableTags
            });

            //custom autocomplete (category selection)
            $.widget( "custom.catcomplete", $.ui.autocomplete, {
                _renderMenu: function( ul, items ) {
                    var that = this,
                        currentCategory = "";
                    $.each( items, function( index, item ) {
                        if ( item.category != currentCategory ) {
                            ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
                            currentCategory = item.category;
                        }
                        that._renderItemData( ul, item );
                    });
                }
            });

            var data = [
                { label: "anders", category: "" },
                { label: "andreas", category: "" },
                { label: "antal", category: "" },
                { label: "annhhx10", category: "Products" },
                { label: "annk K12", category: "Products" },
                { label: "annttop C13", category: "Products" },
                { label: "anders andersson", category: "People" },
                { label: "andreas andersson", category: "People" },
                { label: "andreas johnson", category: "People" }
            ];
            $( "#search" ).catcomplete({
                delay: 0,
                source: data
            });


            //tooltips
            $( "#show-option" ).tooltip({
                show: {
                    effect: "slideDown",
                    delay: 250
                }
            });

            $( "#hide-option" ).tooltip({
                hide: {
                    effect: "explode",
                    delay: 250
                }
            });

            $( "#open-event" ).tooltip({
                show: null,
                position: {
                    my: "left top",
                    at: "left bottom"
                },
                open: function( event, ui ) {
                    ui.tooltip.animate({ top: ui.tooltip.position().top + 10 }, "fast" );
                }
            });


            //Menu
            $( "#menu" ).menu();


            //spinner
            var spinner = $( "#spinner" ).spinner({
                create: function( event, ui ) {
                    //add custom classes and icons
                    $(this)
                        .next().addClass('btn btn-success').html('<i class="icon-plus"></i>')
                        .next().addClass('btn btn-danger').html('<i class="icon-minus"></i>')

                    //larger buttons on touch devices
                    if(ace.click_event == "tap") $(this).closest('.ui-spinner').addClass('ui-spinner-touch');
                }
            });

            //slider example
            $( "#slider" ).slider({
                range: true,
                min: 0,
                max: 500,
                values: [ 75, 300 ]
            });



            //jquery accordion
            $( "#accordion" ).accordion({
                collapsible: true ,
                heightStyle: "content",
                animate: 250,
                header: ".accordion-header"
            }).sortable({
                axis: "y",
                handle: ".accordion-header",
                stop: function( event, ui ) {
                    // IE doesn't register the blur when sorting
                    // so trigger focusout handlers to remove .ui-state-focus
                    ui.item.children( ".accordion-header" ).triggerHandler( "focusout" );
                }
            });
            //jquery tabs
            $( "#tabs" ).tabs();


            //progressbar
            $( "#progressbar" ).progressbar({
                value: 37,
                create: function( event, ui ) {
                    $(this).addClass('progress progress-striped active')
                        .children(0).addClass('progress-bar progress-bar-success');
                }
            });

        });
    </script>
    <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>

</div>
</body>
</html>
