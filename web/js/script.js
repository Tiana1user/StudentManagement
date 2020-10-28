//当页面加载完成
$(function(){
	//创建数据库
	var db = openDatabase('games','1.0','练习',1024*1024);
	展示();
	//谁被点击
	$("#添加").click(function(){
		//开启实务				回调
		var tx = db.transaction(function(tx){
			//执行SQL语句，引号中的是SQL语句'创建数据表如果这个表不存在的话（字段名 数据类型）'
			tx.executeSql('CREATE TABLE IF NOT EXISTS demo (id INTEGER, games TEXT, clas TEXT, xue TEXT)');
			tx.executeSql(
				//添加数据到demo表中 ，其中的？是要填的数据
				'INSERT INTO demo VALUES (?,?,?,?)',
				//要添加的数据
				[$("#编号").val(),$("#游戏").val(),$("#班级").val(),$("#学号").val()],
				//成功后
				
				function(tx, rs){
					alert("添加成功");
				},
				//失败后
				function(tx, error){
					alert("添加失败" + error.message);
				}
			);
		});
		展示();
	});
	
	$("#结果").delegate("button:contains(删除)","click",function(){
		var 要删除的编号 = $(this).val();
		var tx = db.transaction(function(tx){
			tx.executeSql(
				'DELETE FROM demo WHERE id=?',
				[要删除的编号],
				function(tx, rs){
					alert("删除成功");
					展示();
				},
				function(tx, error){
					alert("删除失败");
				}
			);
		});
	});
	
	$("#结果").delegate("button:contains(修改)","click",function(){
		//得到表格中的数据
		//$(this):点击的当前修改按钮
		//parents : 选取父级元素
		//find ： 选取子级元素
		//td:eq(0) : 选取第一个td标签
		//html ： 页面内的内容
		var 前编号 = $(this).parents("tr").find("td:eq(0)").html();
		var 前游戏 = $(this).parents("tr").find("td:eq(1)").html();
		var 前班级 = $(this).parents("tr").find("td:eq(2)").html();
		var 前学号 = $(this).parents("tr").find("td:eq(3)").html();
		//将表格中的数据输出到对应的表单中
		$("#编号").val(前编号);
		$("#游戏").val(前游戏);
		$("#班级").val(前班级);
		$("#学号").val(前学号);		
		$("#编号").prop("disabled", true);
		//parent : 选取父级元素
		//append : 附加
		if($("#添加").parent().children().length < 2){
			$("#添加").parent().append("<button id='修改'>修改</button>");
		}
		
		
	});
	
	$("#表单").delegate("#修改","click",function(){
		var tx = db.transaction(function(tx){
			tx.executeSql(
				'UPDATE demo SET games=?, clas=?, xue=? WHERE id=?',
				[$("#游戏").val(),$("#班级").val(),$("#学号").val(),$("#编号").val()],
				function(tx, rs){
					展示();
					alert("修改成功");
					$("#修改").remove();
					$("#编号").prop("disabled", false);
				},
				function(tx, error){
					alert("修改失败");
				}
			);
		});
	});
	
	function 展示(){
		//拿到数据
		//开事务
		//清空id为结果的THML元素里的所有子元素。
		$("#结果").empty();
		var tx = db.transaction(function(tx){
			//sql语句（查询数据库语句）
			tx.executeSql(
				'SELECT * FROM demo',
				//需要添加的数据（无）
				[],
				//成功后
				function(tx, rs){
					//循环输出数据(因为有可能是一条数据，也有可能是多条数据)
					//rs就是第39行函数中的第二个参数，它是成功后返回的结果
					//rows查询数据库后返回的结果的行数
					//length长度（个数）
					for (var i = 0; i < rs.rows.length; i++) {
						$("#结果").append('<tr><td>' + rs.rows.item(i).id + '</td><td>' + rs.rows.item(i).games + '</td><td>' + rs.rows.item(i).clas + '</td><td>' + rs.rows.item(i).xue + '</td><td><button value="'  + rs.rows.item(i).id +  '">修改</button><button value="'  + rs.rows.item(i).id +  '">删除</button></td></tr>');
					}
				},
				//失败后
				function(tx, error){
					alert("暂无数据");
				}
			);
		});
		
		
	}
	

	
});