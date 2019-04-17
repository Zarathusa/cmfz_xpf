<%@page  pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("path",request.getContextPath());
%>
 <script>
 	$(function(){
 		// 基于准备好的dom，初始化echarts实例
	        var myChart = echarts.init(document.getElementById('userMap'));
	
			$.post("${path}/user/showQuarterCityMap",function(result){
				
				var series=[];
				var data=result.data;
				for(var i=0;i<data.length;i++){
					var dat= data[i];
					
					series.push(
						{
				            name: dat.quarter,
				            type: 'map',
				            mapType: 'china',
				            label: {
				                normal: {
				                    show: false
				                },
				                emphasis: {
				                    show: true
				                }
				            },
				            data:dat.citys
				        }
					);
					
				}
				
		        // 指定图表的配置项和数据
				option = {
				    title : {
				        text: '用户注册地区分布图',
				        subtext: '季度分布',
				        left: 'center'
				    },
				    tooltip : {
				        trigger: 'item'
				    },
				    legend: {
				        orient: 'vertical',
				        left: 'left',
				        data:['第一季度','第二季度','第三季度','第四季度']
				    },
				    visualMap: {
				        min: 0,
				        max: 2500,
				        left: 'left',
				        top: 'bottom',
				        text:['高','低'],           // 文本，默认为数值文本
				        calculable : true
				    },
				    toolbox: {
				        show: true,
				        orient : 'vertical',
				        left: 'right',
				        top: 'center',
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    series : series
				};
		
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
				
			},"json");
 	});	
 </script>
 <div id="userMap" style="width: 600px;height:400px;"></div>
 
