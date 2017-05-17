<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>班级信息</title>
		<meta charset="utf-8" />
			<!-- basic styles -->

		<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->

		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${pageContext.request.contextPath}/assets/js/html5shiv.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
								<!-- PAGE CONTENT BEGINS -->

								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table id="sample-table-1" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>序号</th>
														<th>班级名</th>
														<th class="hidden-480">人数</th>
														<th class="hidden-480">平均分</th>
														<th class="hidden-480">修改</th>
														<th class="hidden-480">删除</th>
													</tr>
												</thead>
												<tbody>

												<c:choose>
													<c:when test="${empty myPage}">
														<tr>
															<td colspan="3">没有符合条件的数据</td>
														</tr>
													</c:when>
												<c:otherwise>
														<c:forEach items="${myPage}" var="classNos" varStatus="obj" >
															<tr>
																<td>${obj.index+1}</td>

																<td>${classNos.name}</td>

																<td>${classNos.studentSet.size()}</td>

																<td>
																	<a href="${pageContext.request.contextPath}/classNos/getClassNosAvgScore/${classNos.classNosId}">平均分</a>
																</td>

																<td>
																	<a href="${pageContext.request.contextPath}/classNos/updateClassNos/${classNos.classNosId}">修改</a>
																</td>
																<td>
																	<a href="${pageContext.request.contextPath}/classNos/deleteClassNos/${classNos.classNosId}">删除</a>
																</td>
															<tr>
														</c:forEach>
													</c:otherwise>
															</c:choose>
												</tbody>
											</table>

										</div><!-- /.table-responsive -->
									</div><!-- /span -->
								</div><!-- /row -->


								<table border="0" cellspacing="0" cellpadding="0" align="center">
									<tr>
										<td align="right">
											<span>
												<ul class="pagination">
													<li><a href="${pageContext.request.contextPath}/classNos/toSave">添加班级</a></li>
												</ul>
											</span>

											<span>
												<ul class="pagination">
													<li><a href="${pageContext.request.contextPath}/student/studentList">查看学生信息</a></li>
												</ul>
											</span>
											
											<span>
												<ul class="pagination">
													<li><a href="${pageContext.request.contextPath}/subject/subjectList">查看学科信息</a></li>
												</ul>
											</span>
											
										</td>
									</tr>

									<c:if test="${pageNos>0 }">
										<a href="${pageContext.request.contextPath}/classNos/classNosList?pageNos=0" >首页</a>
										<a href="${pageContext.request.contextPath}/classNos/classNosList?pageNos=${pageNos-1 }">上一页</a>
									</c:if>
									<c:if test="${pageNos <countPage-1 }">
										<a href="${pageContext.request.contextPath}/classNos/classNosList?pageNos=${pageNos+1 }">下一页</a>
										<a href="${pageContext.request.contextPath}/classNos/classNosList?pageNos=${countPage-1 }">末页</a>
									</c:if>
								</table>
								<form action="${pageContext.request.contextPath}/classNos/classNosList">
									<h4 align="center">共${countPage}页
										<input type="text" value="${pageNos}" name="pageNos" size="1">页
										<input type="submit" value="go">
									</h4>
								</form>
		<!-- basic scripts -->

		<!--[if !IE]> -->
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.bootstrap.js"></script>

		<!-- ace scripts -->

		<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function($) {
				var oTable1 = $('#sample-table-2').dataTable( {
				"aoColumns": [
			      { "bSortable": false },
			      null, null,null, null, null,
				  { "bSortable": false }
				] } );
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
			
			
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			})
		</script>
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
