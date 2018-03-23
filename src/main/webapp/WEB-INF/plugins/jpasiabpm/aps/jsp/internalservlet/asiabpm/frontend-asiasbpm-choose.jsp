<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="wp" uri="/aps-core" %>
<%@ taglib prefix="wpsa" uri="/apsadmin-core" %>


<b>    
    Percorso dove vengono pescate le risorse all'interno del progetto dal tag &LT;wp:resourceURL/&GT;<br/>
</b>
<wp:resourceURL/><br/>
<b>    
...il CSS &LT;wp:cssURL/&GT; ...<br/>
</b>
<wp:cssURL/><br/>
<b>    
...e immagini &LT;wp:imgURL/&GT;<br/>
</b>
<wp:imgURL/><br/>
<b>    
 Infine il tag &LT;wp:headInfo/&GT; permetet di modificare l'head della pagina direttamente dal widget!<br/>
</b>
<br/>



<wp:i18n key="KEY_CHOOSE" />


<form action="<wp:action path="/ExtStr2/do/FrontEnd/jpasiabpm/Asiabpm/choose.action" />" method="post">
        

<h2>
    <s:checkboxlist label="What's your favor color" list="options" 
name="chosen" value="defaultColor" />
</h2> 

<button type="submit" class="btn btn-primary">
    <wp:i18n key="KEY_SELECT" />
</button>

</form>