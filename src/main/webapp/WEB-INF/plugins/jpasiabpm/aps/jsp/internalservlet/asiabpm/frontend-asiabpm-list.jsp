<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="wp" uri="/aps-core" %>
<%@ taglib prefix="wpsa" uri="/apsadmin-core" %>

<%--CAL START --%>

<wp:info key="currentLang" var="currentLang" />

<c:set var="js_for_datepicker">
    /* Italian initialisation for the jQuery UI date picker plugin. */
    /* Written by Antonello Pasella (antonello.pasella@gmail.com). */
    jQuery(function($){
    $.datepicker.regional['it'] = {
    closeText: 'Chiudi',
    prevText: '&#x3c;Prec',
    nextText: 'Succ&#x3e;',
    currentText: 'Oggi',
    monthNames: ['Gennaio','Febbraio','Marzo','Aprile','Maggio','Giugno',
    'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre'],
    monthNamesShort: ['Gen','Feb','Mar','Apr','Mag','Giu',
    'Lug','Ago','Set','Ott','Nov','Dic'],
    dayNames: ['Domenica','Luned&#236','Marted&#236','Mercoled&#236','Gioved&#236','Venerd&#236','Sabato'],
    dayNamesShort: ['Dom','Lun','Mar','Mer','Gio','Ven','Sab'],
    dayNamesMin: ['Do','Lu','Ma','Me','Gi','Ve','Sa'],
    weekHeader: 'Sm',
    dateFormat: 'dd/mm/yy',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: ''};
    });
        
    jQuery(function($){
    if (Modernizr.touch && Modernizr.inputtypes.date) {
    $.each( $("input[data-isdate=true]"), function(index, item) {
    item.type = 'date';
    });
    } else {
    $.datepicker.setDefaults( $.datepicker.regional[ "<c:out value="${currentLang}" />" ] );
    $("input[data-isdate=true]").datepicker({
    changeMonth: true,
    changeYear: true,
    dateFormat: "dd/mm/yy"
    });
    }
    });
</c:set>
<wp:headInfo type="JS" info="entando-misc-html5-essentials/modernizr-2.5.3-full.js" />
<wp:headInfo type="JS_EXT" info="http://code.jquery.com/ui/1.10.1/jquery-ui.js" />
<wp:headInfo type="CSS_EXT" info="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<wp:headInfo type="JS_RAW" info="${js_for_datepicker}" />

<%--CAL END --%>

<%--
optional CSS
<wp:headInfo type="CSS" info="widgets/asiabpm_list.css" />
--%>

<section class="asiabpm_list">
    
    <h1><wp:i18n key="jpasiabpm_ASIABPM_SEARCH_ASIABPM" /></h1>
        
        <form action="<wp:action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/search.action" />" method="post" >
        
        <fieldset>
            <label for="asiabpm_id"><wp:i18n key="jpasiabpm_ASIABPM_ID" /></label>
            <input type="text" name="id" id="asiabpm_id" value="<s:property value="id" />" />
            <label for="asiabpm_afield"><wp:i18n key="jpasiabpm_ASIABPM_AFIELD" /></label>
            <input type="text" name="afield" id="asiabpm_afield" value="<s:property value="afield" />" />
        </fieldset>
            
        <button type="submit" class="btn btn-primary">
            <wp:i18n key="SEARCH" />
        </button>
            
        <wpsa:subset source="asiabpmsId" count="10" objectName="groupAsiabpm" advanced="true" offset="5">
            <s:set var="group" value="#groupAsiabpm" />
                
            <div class="margin-medium-vertical text-center">
                <s:include value="/WEB-INF/apsadmin/jsp/common/inc/pagerInfo.jsp" />
                <s:include value="/WEB-INF/apsadmin/jsp/common/inc/pager_formBlock.jsp" />
            </div>
                
            <p>
                <a href="<wp:action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/new.action"></wp:action>" title="<wp:i18n key="NEW" />" class="btn btn-info">
                        <span class="icon-plus-sign icon-white"></span>&#32;
                    <wp:i18n key="NEW" />
                </a>
            </p>
                
            <table class="table table-bordered table-condensed table-striped">
                <thead>
                    <tr>
                        <th class="text-right">
                            <wp:i18n key="jpasiabpm_ASIABPM_ID" />
                        </th>
                        <th
                            class="text-left"><wp:i18n key="jpasiabpm_ASIABPM_AFIELD" /></th>
                        <th>
                            <wp:i18n key="jpasiabpm_ASIABPM_ACTIONS" />
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator var="asiabpmId">
                        <tr>
                            <s:set var="asiabpm" value="%{getAsiabpm(#asiabpmId)}" />
                            <td class="text-right">
                                <a
                                    href="<wp:action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/edit.action"><wp:parameter name="id"><s:property value="#asiabpm.id" /></wp:parameter></wp:action>"
                                    title="<wp:i18n key="EDIT" />: <s:property value="#asiabpm.id" />"
                                    class="label label-info display-block">
                                    <s:property value="#asiabpm.id" />&#32;
                                    <span class="icon-edit icon-white"></span>
                                </a>
                            </td>
                            <td
                                >
                                <s:property value="#asiabpm.afield" />  </td>
                            <td class="text-center">
                                <a
                                    href="<wp:action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/trash.action"><wp:parameter name="id"><s:property value="#asiabpm.id" /></wp:parameter></wp:action>"
                                    title="<wp:i18n key="TRASH" />: <s:property value="#asiabpm.id" />"
                                    class="btn btn-warning btn-small">
                                    <span class="icon-trash icon-white"></span>&#32;
                                    <wp:i18n key="TRASH" />
                                </a>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
                
            <div class="margin-medium-vertical text-center">
                <s:include value="/WEB-INF/apsadmin/jsp/common/inc/pager_formBlock.jsp" />
            </div>
                
        </wpsa:subset>
            
    </form>
        
    <form action="<wp:action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/fileUpload.action" />" method="post" enctype="multipart/form-data">
        
        
        <s:file name="fileUpload" label="Select a File to upload" size="40" />
            
            
        <button type="submit" class="btn btn-primary">
            <wp:i18n key="KEY_UPLOAD" />
        </button>
            
    </form>
        
        
</section>