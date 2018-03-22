INSERT INTO widgetcatalog (code, titles, parameters, plugincode, parenttypecode, defaultconfig, locked, maingroup) VALUES ('jpasiabpmAsiabpm', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="en">Publish Asiabpm</property>
<property key="it">Pubblica Asiabpm</property>
</properties>', '<config>
	<parameter name="id">id</parameter>
	<action name="jpasiabpmAsiabpmConfig"/>
</config>','jpasiabpm', NULL, NULL, 1, 'free');

INSERT INTO widgetcatalog (code, titles, parameters, plugincode, parenttypecode, defaultconfig, locked, maingroup) VALUES ('jpasiabpmAsiabpm_list_form', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="en">Asiabpm List and Form</property>
<property key="it">Lista e Form Asiabpm</property>
</properties>', NULL, 'jpasiabpm', 'formAction', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="actionPath">/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/list.action</property>
</properties>', 1, 'free');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_ID', 'en', 'id');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_ID', 'it', 'id');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_AFIELD', 'en', 'afield');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_AFIELD', 'it', 'afield');


INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_ACTIONS', 'it', 'Actions');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_ACTIONS', 'en', 'Actions');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_NEW', 'it', 'Asiabpm New');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_NEW', 'en', 'Asiabpm New');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_EDIT', 'it', 'Asiabpm Edit');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_EDIT', 'en', 'Asiabpm Edit');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_TRASH', 'it', 'Asiabpm Trash');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_TRASH', 'en', 'Asiabpm Trash');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_TRASH_CONFIRM', 'it', 'Asiabpm Trash confirm');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_TRASH_CONFIRM', 'en', 'Asiabpm Trash confirm');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_SEARCH_ASIABPM', 'it', 'Asiabpm search');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_SEARCH_ASIABPM', 'en', 'Asiabpm search');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_NOT_FOUND', 'it', 'Asiabpm not found');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jpasiabpm_ASIABPM_NOT_FOUND', 'en', 'Asiabpm not found');


INSERT INTO guifragment (code, widgettypecode, plugincode, gui, defaultgui, locked) VALUES ('jpasiabpm_is_front_Asiabpm_entry', 'jpasiabpmAsiabpm_list_form', 'jpasiabpm', NULL, '<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["/struts-tags"]>
<#assign wp=JspTaglibs["/aps-core"]>
<#assign wpsf=JspTaglibs["/apsadmin-form"]>

<@wp.info key="currentLang" var="currentLangVar" />

<#assign js_for_datepicker="jQuery(function($){
$.datepicker.regional[''it''] = {
closeText: ''Chiudi'',
prevText: ''&#x3c;Prec'',
nextText: ''Succ&#x3e;'',
currentText: ''Oggi'',
monthNames: [''Gennaio'',''Febbraio'',''Marzo'',''Aprile'',''Maggio'',''Giugno'',
''Luglio'',''Agosto'',''Settembre'',''Ottobre'',''Novembre'',''Dicembre''],
monthNamesShort:  [''Gen'',''Feb'',''Mar'',''Apr'',''Mag'',''Giu'',
''Lug'',''Ago'',''Set'',''Ott'',''Nov'',''Dic''],
dayNames: [''Domenica'',''Luned&#236'',''Marted&#236'',''Mercoled&#236'',''Gioved&#236'',''Venerd&#236'',''Sabato''],
dayNamesShort: [''Dom'',''Lun'',''Mar'',''Mer'',''Gio'',''Ven'',''Sab''],
dayNamesMin: [''Do'',''Lu'',''Ma'',''Me'',''Gi'',''Ve'',''Sa''],
weekHeader: ''Sm'',
dateFormat: ''dd/mm/yy'',
firstDay: 1,
isRTL: false,
showMonthAfterYear: false,
yearSuffix: ''''};
});

jQuery(function($) {
 if (Modernizr.touch && Modernizr.inputtypes.date) {
  $.each( $(\"input[data-isdate=true]\"), function(index, item) {
   item.type = ''date'';
  });
 } else {
  $.datepicker.setDefaults( $.datepicker.regional[ \"${currentLangVar}\" ] );
  $(\"input[data-isdate=true]\").datepicker({
	changeMonth: true,
	changeYear: true,
	dateFormat: \"dd/mm/yy\"
   });
 }
});
">
<@wp.headInfo type="JS" info="entando-misc-html5-essentials/modernizr-2.5.3-full.js" />
<@wp.headInfo type="JS_EXT" info="http://code.jquery.com/ui/1.10.1/jquery-ui.js" />
<@wp.headInfo type="CSS_EXT" info="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<@wp.headInfo type="JS_RAW" info="${js_for_datepicker}" />
<section>
<@s.if test="strutsAction==1">
	<h1><@wp.i18n key="jpasiabpm_ASIABPM_NEW" /></h1>
</@s.if>
<@s.elseif test="strutsAction==2">
	<h1><@wp.i18n key="jpasiabpm_ASIABPM_EDIT" /></h1>
</@s.elseif>
<form action="<@wp.action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/save.action" />" method="post">
	<@s.if test="hasFieldErrors()">
		<div class="alert alert-error">
			<h2><@s.text name="message.title.FieldErrors" /></h2>
			<ul>
				<@s.iterator value="fieldErrors">
					<@s.iterator value="value">
				<li><@s.property/></li>
					</@s.iterator>
				</@s.iterator>
			</ul>
		</div>
	</@s.if>
	<@s.if test="hasActionErrors()">
		<div class="alert alert-error">
			<h2><@s.text name="message.title.ActionErrors" /></h2>
			<ul>
				<@s.iterator value="actionErrors">
				<li><@s.property/></li>
				</@s.iterator>
			</ul>
		</div>
	</@s.if>
	<p class="sr-only">
		<@wpsf.hidden name="strutsAction" />
		<@wpsf.hidden name="id" />
	</p>
	<fieldset>
		<label for="asiabpm_afield"><@wp.i18n key="jpasiabpm_ASIABPM_AFIELD" /></label>
		<input type="text" name="afield" id="asiabpm_afield" value="<@s.property value="afield" />" />
	</fieldset>
	<@wpsf.submit type="button" cssClass="btn btn-primary">
		<@wp.i18n key="SAVE" />
	</@wpsf.submit>
</form>
</section>', 1);
INSERT INTO guifragment (code, widgettypecode, plugincode, gui, defaultgui, locked) VALUES ('jpasiabpm_is_front_Asiabpm_error', 'jpasiabpmAsiabpm_list_form', 'jpasiabpm', NULL, '<pre>
   __   _ __   _ __   ___   _ __  
 /''__`\/\`''__\/\`''__\/ __`\/\`''__\
/\  __/\ \ \/ \ \ \//\ \L\ \ \ \/ 
\ \____\\ \_\  \ \_\\ \____/\ \_\ 
 \/____/ \/_/   \/_/ \/___/  \/_/ 
                                  
</pre>', 1);




INSERT INTO guifragment (code, widgettypecode, plugincode, gui, defaultgui, locked) VALUES ('jpasiabpm_is_front_Asiabpm_list', 'jpasiabpmAsiabpm_list_form', 'jpasiabpm', NULL, '<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["/struts-tags"]>
<#assign wp=JspTaglibs["/aps-core"]>
<#assign wpsa=JspTaglibs["/apsadmin-core"]>

<@wp.info key="currentLang" var="currentLangVar" />

<#assign js_for_datepicker="jQuery(function($){
$.datepicker.regional[''it''] = {
closeText: ''Chiudi'',
prevText: ''&#x3c;Prec'',
nextText: ''Succ&#x3e;'',
currentText: ''Oggi'',
monthNames: [''Gennaio'',''Febbraio'',''Marzo'',''Aprile'',''Maggio'',''Giugno'',
''Luglio'',''Agosto'',''Settembre'',''Ottobre'',''Novembre'',''Dicembre''],
monthNamesShort:  [''Gen'',''Feb'',''Mar'',''Apr'',''Mag'',''Giu'',
''Lug'',''Ago'',''Set'',''Ott'',''Nov'',''Dic''],
dayNames: [''Domenica'',''Luned&#236'',''Marted&#236'',''Mercoled&#236'',''Gioved&#236'',''Venerd&#236'',''Sabato''],
dayNamesShort: [''Dom'',''Lun'',''Mar'',''Mer'',''Gio'',''Ven'',''Sab''],
dayNamesMin: [''Do'',''Lu'',''Ma'',''Me'',''Gi'',''Ve'',''Sa''],
weekHeader: ''Sm'',
dateFormat: ''dd/mm/yy'',
firstDay: 1,
isRTL: false,
showMonthAfterYear: false,
yearSuffix: ''''};
});

jQuery(function($) {
 if (Modernizr.touch && Modernizr.inputtypes.date) {
  $.each( $(\"input[data-isdate=true]\"), function(index, item) {
   item.type = ''date'';
  });
 } else {
  $.datepicker.setDefaults( $.datepicker.regional[ \"${currentLangVar}\" ] );
  $(\"input[data-isdate=true]\").datepicker({
	changeMonth: true,
	changeYear: true,
	dateFormat: \"dd/mm/yy\"
   });
 }
});
">
<@wp.headInfo type="JS" info="entando-misc-html5-essentials/modernizr-2.5.3-full.js" />
<@wp.headInfo type="JS_EXT" info="http://code.jquery.com/ui/1.10.1/jquery-ui.js" />
<@wp.headInfo type="CSS_EXT" info="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<@wp.headInfo type="JS_RAW" info="${js_for_datepicker}" />

<section class="asiabpm_list">

<h1><@wp.i18n key="jpasiabpm_ASIABPM_SEARCH_ASIABPM" /></h1>

<form action="<@wp.action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/search.action" />" method="post" >

  <fieldset>
		<label for="asiabpm_id"><@wp.i18n key="jpasiabpm_ASIABPM_ID" /></label>
		<input type="text" name="id" id="asiabpm_id" value="<@s.property value="id" />" />
		<label for="asiabpm_afield"><@wp.i18n key="jpasiabpm_ASIABPM_AFIELD" /></label>
		<input type="text" name="afield" id="asiabpm_afield" value="<@s.property value="afield" />" />
  </fieldset>

  <button type="submit" class="btn btn-primary">
    <@wp.i18n key="SEARCH" />
  </button>

<@wpsa.subset source="asiabpmsId" count=10 objectName="groupAsiabpm" advanced=true offset=5>
<@s.set name="group" value="#groupAsiabpm" />
<@wp.freemarkerTemplateParameter var="group" valueName="groupAsiabpm" removeOnEndTag=true >
<div class="margin-medium-vertical text-center">
	<@s.include value="/WEB-INF/apsadmin/jsp/common/inc/pagerInfo.jsp" />
	<@s.include value="/WEB-INF/apsadmin/jsp/common/inc/pager_formBlock.jsp" />
	<#--
	<@wp.fragment code="default_pagerInfo_is" escapeXml=false />
	<@wp.fragment code="default_pagerFormBlock_is" escapeXml=false />
	-->
</div>
<p>
  <a href="<@wp.action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/new.action"></@wp.action>" title="<@wp.i18n key="NEW" />" class="btn btn-info">
    <span class="icon-plus-sign icon-white"></span>&#32;
    <@wp.i18n key="NEW" />
  </a>
</p>
<table class="table table-bordered table-condensed table-striped">
<thead>
<tr>
  <th class="text-right">
    <@wp.i18n key="jpasiabpm_ASIABPM_ID" />
  </th>
	<th
                 class="text-left"><@wp.i18n key="jpasiabpm_ASIABPM_AFIELD" /></th>
	<th>
    <@wp.i18n key="jpasiabpm_ASIABPM_ACTIONS" />
  </th>
</tr>
</thead>
<tbody>
<@s.iterator var="asiabpmId">
<tr>
	<@s.set var="asiabpm" value="%{getAsiabpm(#asiabpmId)}" />
	<td class="text-right">
    <a
      href="<@wp.action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/edit.action"><@wp.parameter name="id"><@s.property value="#asiabpm.id" /></@wp.parameter></@wp.action>"
      title="<@wp.i18n key="EDIT" />: <@s.property value="#asiabpm.id" />"
      class="label label-info display-block">
    <@s.property value="#asiabpm.id" />&#32;
    <span class="icon-edit icon-white"></span>
    </a>
  </td>
	<td
            >
    <@s.property value="#asiabpm.afield" />  </td>
	<td class="text-center">
    <a
      href="<@wp.action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/trash.action"><@wp.parameter name="id"><@s.property value="#asiabpm.id" /></@wp.parameter></@wp.action>"
      title="<@wp.i18n key="TRASH" />: <@s.property value="#asiabpm.id" />"
      class="btn btn-warning btn-small">
      <span class="icon-trash icon-white"></span>&#32;
      <@wp.i18n key="TRASH" />
    </a>
  </td>
</tr>
</@s.iterator>
</tbody>
</table>
<div class="margin-medium-vertical text-center">
	<@s.include value="/WEB-INF/apsadmin/jsp/common/inc/pager_formBlock.jsp" />
	<#--
	<@wp.fragment code="default_pagerFormBlock_is" escapeXml=false />
	-->
</div>
</@wp.freemarkerTemplateParameter>
</@wpsa.subset>
</form>
</section>', 1);

INSERT INTO guifragment (code, widgettypecode, plugincode, gui, defaultgui, locked) VALUES ('jpasiabpm_is_front_Asiabpm_trash', 'jpasiabpmAsiabpm_list_form', 'jpasiabpm', NULL, '<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["/struts-tags"]>
<#assign wp=JspTaglibs["/aps-core"]>
<#assign wpsf=JspTaglibs["/apsadmin-form"]>

<section>
	<h1><wp:i18n key="jpasiabpm_ASIABPM_TRASH" /></h1>
	<form action="<@wp.action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/delete.action" />" method="post">
		<@s.if test="hasFieldErrors()">
			<div class="alert alert-error">
				<h2><@s.text name="message.title.FieldErrors" /></h2>
				<ul>
					<@s.iterator value="fieldErrors">
						<@s.iterator value="value">
						<li><@s.property /></li>
						</@s.iterator>
					</@s.iterator>
				</ul>
			</div>
		</@s.if>
		<@s.if test="hasActionErrors()">
			<div class="alert alert-error">
				<h2><@s.text name="message.title.ActionErrors" /></h2>
				<ul>
					<@s.iterator value="actionErrors">
					<li><@s.property /></li>
					</@s.iterator>
				</ul>
			</div>
		</@s.if>
		<p class="sr-only">
			<@wpsf.hidden name="strutsAction" />
			<@wpsf.hidden name="id" />
		</p>
		<div class="alert alert-warning">
			<p>
				<@wp.i18n key="jpasiabpm_ASIABPM_TRASH_CONFIRM" />&#32;<@wp.i18n key="jpasiabpm_ASIABPM_ID" />&#32;<@s.property value="id" />?
			</p>
			<p>
				<@wpsf.submit type="button" cssClass="btn btn-warning">
					<span class="icon-trash icon-white"></span>&#32;
					<@wp.i18n key="TRASH" />
				</@wpsf.submit>
			</p>
		</div>
	</form>
</section>', 1);

