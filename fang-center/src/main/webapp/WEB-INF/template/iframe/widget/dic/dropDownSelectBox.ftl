<select editable="false"
<#if id?exists>id="${id}"<#else>id="${keyValueType}"</#if> 
<#if name?exists>name="${name}"<#elseif id?exists>name="${id}"<#else>name="${keyValueType}"</#if>
 class="easyui-validatebox <#if class??> ${class}<#else> wid100</#if>"
<#if required == "true"> required="true"</#if>
<#if disabled == "true"> disabled</#if>
<#if style??>style="${style}"</#if>
>
	<#if isShowPlease == "true">
		<#if isShowBlank == "true">
			<option value=""></option>
		<#else>
			<option value="">---请选择---</option>
		</#if>
	</#if>
	<#list keyValueList as keyValue>
		<#if keyValue.key == value>
			<option value="${keyValue.key}" selected>${keyValue.value}</option>
		<#else>
			<option value="${keyValue.key}">${keyValue.value}</option>
		</#if>
	</#list>
</select>
