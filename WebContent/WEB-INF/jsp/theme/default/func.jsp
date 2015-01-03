<%@ include file="../../include/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${_module=='jingmo' }">
        <li class="${_underJingmo}"><a href="${basePath}jingmo/list">在线量</a></li>
    </c:when>
    <c:when test="${_module=='rs' }">
        <li class="${_underRs}"><a href="${basePath}jingmo/list">激活量</a></li>
    </c:when>
    <c:when test="${_module=='pushrule' }">
        <li class="${_underPushRule}"><a href="${basePath}pushRule/list">push规则</a></li>
    </c:when>
    <c:when test="${_module=='push' }">
        <li class="${_underPushApp}"><a href="${basePath}push/app/list">appInfo</a></li>
        <li class="${_underPushActive}"><a href="${basePath}push/active/list">activeInfo</a></li>
        <li class="${_underPushDelete}"><a href="${basePath}push/delete/list">deleteInfo</a></li>
        <li class="${_underPushUpdate}"><a href="${basePath}push/update/list">updateInfo</a></li>
    </c:when>
	<c:when test="${_module=='system' }">
		<c:if test="${rommer:isAdmin()}">
			<li class="${_underSysUser}"><a href="${basePath}sysuser/list">系统用户</a></li>
		</c:if>
		<li class="${_underUserInfo}"><a href="${basePath}sysuser/${isUnderUserInfo?'info_modify':'modify'}/${rommer:uid()}">信息修改</a></li>
	</c:when>
</c:choose>
