app.service('uploadService', function ($http) {
    //上传文件
    this.uploadFile = function () {
        var formdata = new FormData();//FormData 代表表单数据
        formdata.append('file', file.files[0]);//第一个file是固定属性；第二个代表文件上传框的name
        return $http({
            url: '../upload.do',
            method: 'post',
            data: formdata,
            headers: {'Content-Type': undefined},//上传的文件类型
            transformRequest: angular.identity//angular提供的对表单进行二进制序列化
        });

    }
})