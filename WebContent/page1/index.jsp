<%@page import="java.sql.PseudoColumnUsage" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
String path = request.getContextPath();
%>
<HTML>
<HEAD>
    <style type="text/css">
    .n_body{
	width: 800px;
    margin: 0 auto;
    position: relative;
}

.n_content {
    padding:100px
}

.n_content .search {
    background: #f2f2f2;
    font-size: 14px;
    display: inline-block;
    width: 100%;
}

.n_content .search .t_input {
    display: inline-block;
    float: left;
}
    </style>
    
</HEAD>


<div class="n_body">
    <FORM id="form" name="form" action="<%=request.getContextPath()%>/account/accounts.do" method="post"
          enctype="multipart/form-data">
        <!-- <div class="n_content">
            <div class="search">
                <div class="s_bao">
                    <div class="t_input">
                        <label>请上传文件
                        </label>
                        <div class="se_i">
                            <input id="uploadFile" class="n_input" type="file" name="mapFile"/>
                        </div>
                    </div>
                    <div class="n_btn">
                               <button value="上传">上传</button>
                              <input name="Submit3" type="button" class="btn_save btn_p"
                               value="上传"
                               onclick="return commit();">
                    </div>
                </div>
            </div>
        </div> -->
        上传文件1：<input type="file" name="mapFile"><br/>
         <!-- 上传文件2：<input type="file" name="file2"><br/> -->
         <input type="submit" value="提交">
    </FORM>
</div>

</BODY>
<script type="text/javascript">

function commit() {
    $("#form").submit();
}
</script>
</HTML>
