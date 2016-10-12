<html>
<head><title>all clients page</title>
<body>
<div id="header">
<H2>
	show clients page
</H2>
</div>

<div id="content">
<#if clients?exists>
	<#list clients as client>
		${client.name} <br>
	</#list>  
<#else>
	${"client is null"}
</#if>
    
    
</div>  
</body>
</html>  
