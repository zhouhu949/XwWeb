<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�б�</title>
	</head>
	<body class="body_bg">
				<s:form method="post" theme="simple" name="cms_form"
					action="/SysButtonAction_findByPage.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<table width="100%" align="center" class="searchstyle">
							<tr>
								<td>
									<dhcc:formTag property="formsys0031" mode="query" />
								</td>
							</tr>
						</table>
						<div class="tools_372">
							<dhcc:button value="��ѯ" action="��ѯ" commit="true"
								typeclass="btn_80"></dhcc:button>
						</div>
					</div>
				</div>
			</div>
		</div>
									
	<p class="p_blank">&nbsp;</p>
	
	<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<div class="tabCont">
							<div class="tabTitle">��Ϣ�б�</div>
							<dhcc:button value="����" action="����" typeclass="t_ico_tj"
								onclick="SysButtonAction_input.action"></dhcc:button>
						</div>
							
						<dhcc:tableTag paginate="sysButtonList" property="tablesys0031"
									head="true" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>
