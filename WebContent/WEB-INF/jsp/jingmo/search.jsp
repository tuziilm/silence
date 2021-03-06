<%@ include file="../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" href="${basePath}static/jquery/jquery-ui.css"/>
<div id="search">
    <form id="search_form" action="${basePath}jingmo/list" method="post"
          class="form-inline pull-right">
          <label>国家:</label>
        <select name="country" id="country_sel" class="input-small">
            <option value="all">所有国家</option>
            <c:forEach items="${countries}" var="c">
                <option value="${c.shortcut}">${c.chineseName}</option>
            </c:forEach>
        </select>
        <script type="text/javascript">
            document.getElementById("country_sel").value = '${rommer:defVal(param.country,"all")}';
        </script>
        <label>结束时间:</label>
        <input value="${rommer:defVal(param.datetime,rommer:yesterdayString("yyyy-MM-dd"))}" type="text" name="datetime" class="input-small" id="datetime"/>
        <input type="submit" class="btn" value="查询"/>
    </form>
</div>
