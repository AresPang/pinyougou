app.controller("baseController", function ($scope) {

    //分页控件配置 currentPage：当前页  totalItems：总记录数  itemsPerPage：每页记录数 perPageOptions：下拉页 页面改变触发
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };
    //刷新列表
    $scope.reloadList = function () {
        //切换页码
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    $scope.selectIds = [];//用户勾选的ID集合
    //用户勾选复选框
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {//$event：事件对象 $event.target事件对应的dom input  $event.target.checked 复选框是否被选中
            $scope.selectIds.push(id);//push向集合添加元素
        } else {
            var index = $scope.selectIds.indexOf(id);//查找的位置
            $scope.selectIds.splice(index, 1);//参数1：移除的位置 参数2 移除的个数
        }
    }

    $scope.jsonToString = function (jsonString, key) {
        var json = JSON.parse(jsonString);
        var value = "";
        for (var i = 0; i < json.length; i++) {
            if (i == 0) {
                value += json[i][key];
            } else {
                value += "," + json[i][key];
            }
        }
        return value;
    }

    //从集合中按照key查询对象
    $scope.searchObjectByKey=function(list,key,keyValue){
        for(var i=0;i<list.length;i++){
            if(list[i][key]==keyValue){
                return list[i];
            }
        }
        return null;
    }

})