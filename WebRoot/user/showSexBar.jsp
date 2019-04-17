<%@page  pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
%>
	<script>
 	$(function(){
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('showSexRegDateBar'));
	    		
	    		$.post("${path}/user/showSexRegDateBar",function(data){

			        // 指定图表的配置项和数据
			        var option = {
			            title: {
			                text: '用户性别注册时间统计图',
			                //link:"${path}/main/main.jsp",
			                subtext:"用户注册数",
			                textStyle:{
			                	color:"#ccaadd"
			                }
			            },
			            tooltip: {},  //鼠标提示
			            legend: {
			                data:['男','女']
			            },
			            xAxis: {
			                data: data.months
			            },
			            yAxis: {},
			            series: [{
			                name: '男',
			                type: 'bar',
			                data: data.man
			            },{
			                name: '女',
			                type: 'line',
			                data: data.woman
			            }]
			        };
			
			        // 使用刚指定的配置项和数据显示图表。
			        myChart.setOption(option);
	    		},"JSON");
	
 	});	
 </script>
 
 <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="showSexRegDateBar" style="width: 600px;height:400px;"  style="text-align: 'center'"></div>
