<%@include file="../../include/common.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:set var="_pageTitle" value="创建appInfo" scope="request" />
<c:set var="_underPushApp" value="active" scope="request" />
<c:set var="_activePush" value="active" scope="request" />
<c:set var="_module" value="push" scope="request" />
<c:import url="../../theme/${_theme}/header.jsp"></c:import>

<!-- main content -->
<div class="page-header">
	<h1>创建/修改AppInfo</h1>
</div>
<div id="pageContent">
	<c:import url="../../theme/${_theme}/errors.jsp"></c:import>
	<form action="${basePath}push/app/save" method="post"
		class="form-horizontal">
		<input name="id" type="hidden" value="${form.id}"> <input
			name="_queryString" type="hidden" value="${param.queryString}">
		<div class="control-group required-field">
			<label class="control-label">packageName:</label>
			<div class="controls">
				<input name="packageName" value="${fn:escapeXml(form.packageName)}"
					type="text" class="input-large">
			</div>
		</div>
		<div class="control-group required-field">
			<label class="control-label">url:</label>
			<div class="controls">
				<input name="url" value="${fn:escapeXml(form.url)}" type="text"
					class="input-large">
			</div>
		</div>
		<div class="control-group required-field">
			<label class="control-label">hash:</label>
			<div class="controls">
				<input name="hash" value="${fn:escapeXml(form.hash)}" type="text"
					class="input-large">
			</div>
		</div>
		<div class="control-group required-field">
			<label class="control-label">type:</label>
			<div class="controls">
				<input name="type" value="${fn:escapeXml(form.type)}" type="text"
					class="input-large">
			</div>
		</div>
		<div class="control-group required-field">
			<label class="control-label">version:</label>
			<div class="controls">
				<input name="version" value="${fn:escapeXml(form.version)}"
					type="text" class="input-large">
			</div>
		</div>
		<div class="control-group required-field">
			<label class="control-label">pushId:</label>
			<div class="controls">
				<select id="push_sel" name="pushId" class="input-large" onchange="javaScript:changeInfo(this.selectedIndex)"> 
					<c:forEach var="push" items="${pushRuleList}">
						<option value="${push.id}"
							${form.pushId==push.id?'selected="selected"':"" }>${push.id}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="page-rules">
			<div class="alert alert-success"
				style="display: inline-block; min-width: 300px;">
				push規則信息
				<ul>
					<li><span>安裝个数：</span><span id="_pr_apkNum"></span></li>
				</ul>
			</div>
		</div>
		<div class="form-actions">
			<input class="btn btn-primary" type="submit" value="保存">
			<button type="button" class="btn" onclick="javascript:history.go(-1)">取消</button>
		</div>
	</form>
</div>
<!-- end main content -->
<c:import url="../../theme/${_theme}/footer.jsp"></c:import>
